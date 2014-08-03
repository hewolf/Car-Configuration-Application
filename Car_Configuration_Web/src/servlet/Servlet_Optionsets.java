package servlet;

/* This servlet communicates with the jsp, sending out the available options */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Automobile;
import adapter.ProxyAutomobile;
import bean.AutomobileBean;

import java.util.*;
import java.util.Map.Entry;

/**
 * Servlet implementation class Servlet_Optionsets
 */
@WebServlet("/Servlet_Optionsets")
public class Servlet_Optionsets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Optionsets() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String absoluteDiskPath = getServletContext().getRealPath("car.Properties");
		out.println(absoluteDiskPath);
		doPost(request,response);
		///Users/zhaokunli/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Car_Configuration_Web/car.Properties
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedHashMap<String, Automobile> lhm = ProxyAutomobile.getMobileHash();
		String selectedModel = request.getParameter("model");
		Iterator<Entry<String, Automobile>> itr = lhm.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<String, Automobile> entry = (Entry<String, Automobile>) itr
					.next();
		}
        //Get the selected model form the lhm
		Automobile auto = lhm.get(selectedModel);
		if (auto != null) {
			AutomobileBean carBean = new AutomobileBean();
			carBean.setWithAutomobile(auto);		
			
			response.setContentType("text/html");
			//send all the corresponding options
			PrintWriter out = response.getWriter();
			out.println(carBean.getSerializedModel()
					+ carBean.getSerializedPrice()
					+ carBean.getSerializedColor()
					+ carBean.getSerializedTransmission()
					+ carBean.getSerializedABS() + carBean.getSerializedBags()
					+ carBean.getSerializedMoonroof());
		}
	}

}
