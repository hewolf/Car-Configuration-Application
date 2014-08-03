<%@ page import="java.util.*"%>
<%@ page import="adapter.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Car Configuration Tool by Zac Li</title>
<LINK REL=STYLESHEET HREF="JSP-Styles.css" TYPE="text/css">
</head>

<script type="text/javascript" src='http://code.jquery.com/jquery-latest.min.js'></script>
<script type="text/javascript">
$(document).ready(function () {
	$('#drp_model option:first-child').attr("selected", "selected");
    $('#drp_model').change(function () {
        $.ajax({
            url: '/Car_Configuration_Web/servletoptions',
            type: 'POST',
            data: "model=" + $('#drp_model').val(),
            success: function(data) {
                var mix = data.split(";");
                var modelMix = mix[0];
                var basicPriceMix = mix[1];
                var colorMix = mix[2];
                var transmisionMix = mix[3];
                var absMix = mix[4];
                var bagsMix = mix[5];
                var moonroofMix = mix[6];
                var modelBody = modelMix.split("~");
                var model = modelBody[1];
                $("#model").val(model);
                
                var basicPriceBody = basicPriceMix.split("~");
                var basicPrice = basicPriceBody[1];
                $("#basic_price").val(basicPrice);
                
                var colorBody = colorMix.split("~");
                var colorPairs = colorBody[1].split("%");
                var colors = [];
                $("#drp_color").empty();
                for(var i=0; i<colorPairs.length; i++) {
                	var val = colorPairs[i].split("=")[0];
                	if(val.trim().length > 0){
                		colors.push(val);
                    	$("#drp_color").append( $("<option>")
                        	    .val(colorPairs[i])
                        	    .html(val)
                        	);
                	}
                }
                
                
                var transmisionBody = transmisionMix.split("~");
                var transmisionPairs = transmisionBody[1].split("%");
                var transmisions = [];
                $("#drp_transmission").empty();
                for(var i=0; i<transmisionPairs.length; i++) {
                	var val = transmisionPairs[i].split("=")[0];
                	if(val.trim().length > 0){
                		transmisions.push(val);
                		$("#drp_transmission").append( $("<option>")
                        	    .val(transmisionPairs[i])
                        	    .html(val)
                        	);
                	}
                }
                
                var absBody = absMix.split("~");
                var absPairs = absBody[1].split("%");
                var abss = [];
                $("#drp_abs").empty();
                for(var i=0; i<absPairs.length; i++) {
                	var val = absPairs[i].split("=")[0];
                	if(val.trim().length > 0){
                		abss.push(val);
                		$("#drp_abs").append( $("<option>")
                        	    .val(absPairs[i])
                        	    .html(val)
                        	);
                	}
                }
                
                var bagsBody = bagsMix.split("~");
                var bagsPairs = bagsBody[1].split("%");
                var bags = [];
                $("#drp_bags").empty();
                for(var i=0; i<bagsPairs.length; i++) {
                	var val = bagsPairs[i].split("=")[0];
                	if(val.trim().length > 0){
                		bags.push(val);
                		$("#drp_bags").append( $("<option>")
                        	    .val(bagsPairs[i])
                        	    .html(val)
                        	);
                	}
                }

                var moonroofBody = moonroofMix.split("~");
                var moonroofPairs = moonroofBody[1].split("%");
                var moonroof = [];
                $("#drp_moonroof").empty();
                for(var i=0; i<moonroofPairs.length; i++) {
                	var val = moonroofPairs[i].split("=")[0];
                	if(val.trim().length > 0){
                		moonroof.push(val);
                		$("#drp_moonroof").append( $("<option>")
                        	    .val(moonroofPairs[i])
                        	    .html(val)
                        	);
                	}
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert("error: " + errorThrown);
            }
        });
    });
    
});
</script>
<body>

	<CENTER>
		<H2>Car Configuration Tool</H2>
		<H4>by Zac Li</H4>
		<%!private int accessCount = 0;%>
		<H5>
			Number of visits:
			<%=++accessCount%></H5>

    <jsp:useBean id="carBean" class="bean.AutomobileBean" scope="page" />
	<jsp:useBean id="mlBean" class="server.BuildCarModelOptions" scope="page" />
	<%
	    ArrayList<String> modelLists = new ArrayList<String>();
	    if(mlBean!=null) {
		modelLists = mlBean.getModelList(); }
	    if (modelLists==null) modelLists.add("");
	%>

	<form action="ResultPage.jsp" method="POST">
		<input type="hidden" id="model" name="model" value="${carBean.model}"/>
		<input type="hidden" id="basic_price" name="base_price" value="${carBean.basePrice}"/>
		<table border="1" cellpadding="10" width="400">
			<tr>
				<td><b>Make/Model:</b></td>
				<td><select id="drp_model" name="drp_model">
						<c:forEach var="item_model" items="<%= modelLists %>">
							<option value="${item_model}">${item_model}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>Color:</b></td>
				<td><select id="drp_color" name="drp_color">
						<c:forEach var="item_color" items="${carBean.color}">
							<option value="${item_color}">${item_color.key}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>Transmission:</b></td>
				<td><select id="drp_transmission" name="drp_transmission">
						<c:forEach var="item_transmission" items="${carBean.transmission}">
							<option value="${item_transmission}">${item_transmission.key}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>ABS/Traction Control:</b></td>
				<td><select id="drp_abs" name="drp_abs">
						<c:forEach var="item_abs" items="${carBean.abs}">
							<option value="${item_abs}">${item_abs.key}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>Side Impact Air Bags:</b></td>
				<td><select id="drp_bags" name="drp_bags">
						<c:forEach var="item_bags" items="${carBean.bags}">
							<option value="${item_bags}">${item_bags.key}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><b>Power Moonroof:</b></td>
				<td><select id="drp_moonroof" name="drp_moonroof">
						<c:forEach var="item_moonroof" items="${carBean.moonroof}">
							<option value="${item_moonroof}">${item_moonroof.key}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Done" />
	</form>
	</CENTER>

</body>
</html>
