package servlet;

/* This servlet communicates with the server, starting the server */

import java.io.IOException;
import java.net.UnknownHostException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.Server;


/**
 * Servlet implementation class Servlet_Model
 */
@WebServlet("/Servlet_Model")
public class Servlet_Model extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Servlet_Model() throws UnknownHostException {
        super();
    }

    //Open a new thread and run the server.
    @Override
	public void init() throws ServletException {
		super.init();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
			Server server = new Server();
			server.runServer();
			}
		});
		t1.start();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///Users/zhaokunli/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Car_Configuration_Web/car.Properties
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
