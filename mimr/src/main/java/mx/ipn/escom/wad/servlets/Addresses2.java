package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addresses2
 */
public class Addresses2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addresses2() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html");
  		PrintWriter pw = response.getWriter();
  		pw.println("<!DOCTYPE html>");
  		pw.println("<html>");
  		pw.println("<head>"); 
  		pw.println("<meta charset=\"UTF-8\">"); 
  		pw.println("<title>Outside</title>"); 
  		pw.println("</head>"); 
  		pw.println("<body>"); 
  		pw.println("<h1>The variable i is out of service method</h1>");  
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
