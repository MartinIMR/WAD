package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.wad.entities.User;
import mx.ipn.escom.wad.util.SessionObject;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>"); 
		pw.println("<meta charset=\"UTF-8\">"); 
		pw.println("<title>User</title>"); 
		pw.println("</head>"); 
		pw.println("<body>"); 
		pw.println("<h1>Welcome:</h1>");
		User user = (User) request.getSession().getAttribute(SessionObject.USER);
		pw.println("<h2>"+user.getFirstName()+" "+user.getLastName()+" "+user.getSecondLastName()+"</h2>");
		pw.println("</body>"); 
		pw.println("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
