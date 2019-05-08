package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addresses
 */
public class Addresses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addresses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int i = 0;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>"); 
		pw.println("<meta charset=\"UTF-8\">"); 
		pw.println("<title>Inside</title>"); 
		pw.println("</head>"); 
		pw.println("<body>"); 
		pw.println("<h1>The variable i is inside of service method</h1>"); 
		pw.println("<h1>Value of i:"+i+"</h1>");  
		pw.println("</body>"); 
		pw.println("</html>");
		pw.close();
	  i++;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
