package mx.ipn.escom.wad.servlets;
import mx.ipn.escom.wad.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import mx.ipn.escom.wad.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableServlet
 */
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Consultar registros
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>"); 
		pw.println("<meta charset=\"UTF-8\">"); 
		pw.println("<title>List of users</title>"); 
		pw.println("</head>"); 
		pw.println("<body>"); 
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<th>First Name(job title)</th>"
				+  "<th>Last Name</th>"
				+  "<th>Second Last Name</th>"
				+  "<th>CURP</th>"
				+  "<th>Birthday</th>"
				+  "<th>Nickname</th>");
		pw.println("</tr>");
		UserDao ud = new UserDao();
		List<User> users = ud.getUsers();
		for(User user: users)
		{
			pw.println("<tr>");
			pw.println("<td>"+user.getFirstName()+"</td>"
					+  "<td>"+user.getLastName()+"</td>"
					+  "<td>"+user.getSecondLastName()+"</td>"
					+  "<td>"+user.getCURP()+"</td>"
					+  "<td>"+user.getBirthday()+"</td>"
					+  "<td>"+user.getNickname()+"</td>");
			pw.println("</tr>");
		}
		 
		pw.println("</table>");  
		pw.println("</body>"); 
		pw.println("</html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Dar de alta 
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		User user;
		UserDao ud = new UserDao();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>"); 
		pw.println("<meta charset=\"UTF-8\">"); 
		pw.println("<title>Registro exitoso</title>"); 
		pw.println("</head>"); 
		pw.println("<body>"); 
		pw.println("<h1>Se recibieron tus datos:</h1>");
		user = new User(request.getParameter("fname"),request.getParameter("lname"),
				request.getParameter("slname"),request.getParameter("curp"),
				request.getParameter("birthday"),request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		if(ud.insertUser(user))
		{
			pw.println("<h2>Se inserto exitosamente el usuario</h2>");
		}else
		{
			pw.println("<h2>No se pudo insertar el usuario</h2>");
			
		}
		/*
		pw.println("<h2>"+request.getParameter("fname")+"</h2>"
				+  "<h2>"+request.getParameter("lname")+"</h2>"
				+  "<h2>"+request.getParameter("slname")+"</h2>"
				+  "<h2>"+request.getParameter("curp")+"</h2>"
				+  "<h2>"+request.getParameter("birthday")+"</h2>"
				+  "<h2>"+request.getParameter("login")+"</h2>"
				+  "<h2>"+request.getParameter("password")+"</h2>");
		*/
		pw.println("</body>"); 
		pw.println("</html>");
		pw.close();
	}

}
