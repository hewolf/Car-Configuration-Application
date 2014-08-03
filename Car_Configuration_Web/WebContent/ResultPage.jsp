<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	double totalCost = 0;
	String color = "", transmission = "", abs = "", bags = "", moonroof = "", colorPrice = "", transmissionPrice = "", absPrice = "", bagsPrice = "", moonroofPrice = "";
	String model = request.getParameter("model");
	String basePrice = request.getParameter("base_price");
	if (basePrice != null && basePrice.trim().length() > 0) {
		System.out.println("basePrice:" + basePrice);
		totalCost += Double.parseDouble(basePrice);

		String[] ss;
		String colorPair = request.getParameter("drp_color");
		if (colorPair != null && colorPair.trim().length() > 0) {
			ss = colorPair.split("=");
			color = ss[0];
			colorPrice = ss[1];
			totalCost += Double.parseDouble(colorPrice);
		}

		String transmissionPair = request
				.getParameter("drp_transmission");
		if (transmissionPair != null
				&& transmissionPair.trim().length() > 0) {
			ss = transmissionPair.split("=");
			transmission = ss[0];
			transmissionPrice = ss[1];
			totalCost += Double.parseDouble(transmissionPrice);
		}

		String absPair = request.getParameter("drp_abs");
		if (absPair != null && absPair.trim().length() > 0) {
			ss = absPair.split("=");
			abs = ss[0];
			absPrice = ss[1];
			totalCost += Double.parseDouble(absPrice);
		}

		String bagsPair = request.getParameter("drp_bags");
		if (bagsPair != null && bagsPair.trim().length() > 0) {
			ss = bagsPair.split("=");
			bags = ss[0];
			bagsPrice = ss[1];
			totalCost += Double.parseDouble(bagsPrice);
		}

		String moonroofPair = request.getParameter("drp_transmission");
		if (moonroofPair != null && moonroofPair.trim().length() > 0) {
			ss = moonroofPair.split("=");
			moonroof = ss[0];
			moonroofPrice = ss[1];
			totalCost += Double.parseDouble(moonroofPrice);
		}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>

<body>
<CENTER>
	<h3>You have successfully configured a car!</h3>
	<table border="1" cellpadding="10" width="400">
		<tr>
			<td><%=model%></td>
			<td>base price</td>
			<td><%=basePrice%></td>
		</tr>
		<tr>
			<td>Color</td>
			<td><%=color%></td>
			<td><%=colorPrice%></td>
		</tr>
		<tr>
			<td>Transmission</td>
			<td><%=transmission%></td>
			<td><%=transmissionPrice%></td>
		</tr>
		<tr>
			<td>ABS/Traction Control</td>
			<td><%=abs%></td>
			<td><%=absPrice%></td>
		</tr>
		<tr>
			<td>Side Impact Air Bags</td>
			<td><%=bags%></td>
			<td><%=bagsPrice%></td>
		</tr>
		<tr>
			<td>Power Moonroof</td>
			<td><%=moonroof%></td>
			<td><%=moonroofPrice%></td>
		</tr>
		<tr>
			<td><b>Total Cost</b></td>
			<td></td>
			<td><%=totalCost%></td>
		</tr>
	</table>
</CENTER>
</body>
</html>