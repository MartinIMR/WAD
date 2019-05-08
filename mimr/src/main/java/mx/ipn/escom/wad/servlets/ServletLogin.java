package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.dao.UserDao;
import mx.ipn.escom.wad.entities.User;
import mx.ipn.escom.wad.util.SessionObject;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("username");
		String pass = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		UserDao ud = new UserDao();
		User user = ud.getUser(login, pass);
		RequestDispatcher rd;
		response.setContentType("text/html");
		HttpSession sesion = request.getSession();
		if(user == null)
		{
			sesion.setAttribute(SessionObject.USER, user);
			rd = request.getRequestDispatcher("/Tareas/Login.html");
			pw.println("Username and/or password are wrong");
			rd.include(request, response);
		}else {
			System.out.println("Se entro");
			sesion.setAttribute(SessionObject.USER, user);
			rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}
		pw.close();
		
	}

}
