package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Headers
 */
public class Headers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Headers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Enumeration<String> headers;
		headers = request.getHeaderNames();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>"); 
		pw.println("<meta charset=\"UTF-8\">"); 
		pw.println("<title>Headers</title>"); 
		pw.println("</head>"); 
		pw.println("<body>"); 
		pw.println("<h1>Headers</h1>");
		pw.println("<ul>");
		int i=1;
		while(headers.hasMoreElements())
		{
			String header = headers.nextElement();
			pw.println("<li>");
			pw.println("Header "+ i +":<br/>");
			pw.println("Nombre: "+ header +"<br/>");
		    pw.println("Valor: "+request.getHeader(header));
			pw.println("</li>");
			i++;
		} 
		pw.println("</ul>");  
		pw.println("</body>"); 
		pw.println("</html>");
		pw.close();
	}

}
