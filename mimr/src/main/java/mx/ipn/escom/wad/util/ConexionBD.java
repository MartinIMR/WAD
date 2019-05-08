package mx.ipn.escom.wad.util;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	protected static Connection connection;
	protected static PreparedStatement ps;
	protected static ResultSet rs;
	// ServletContext context;
	
	private static final int ERR_DRIVER_CLASS = -1;
	private static final int NOT_CLOSED = -2;
	private static final int SUCCESS = 0;
	public static int connect() {
		try {
			Class.forName("org.postgresql.Driver");
			/*
			String url = context.getInitParameter("DBHost") + context.getInitParameter("DBName") ;
			String user = context.getInitParameter("DBUser");
			String pass = context.getInitParameter("DBPassword");
			*/
			String url = "jdbc:postgresql://localhost:5432/homework-6";
			String user = "postgres";
			String pass = "postgres";
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Sql Driver not found ");
			System.out.println(e.getMessage());
            return ERR_DRIVER_CLASS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERR_DRIVER_CLASS;
		} 
		return SUCCESS;
	}
	
	public static int disconnect()
	{
		try {
		connection.close();
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return NOT_CLOSED;
		}
		return SUCCESS;
	}
	
	public ResultSet doQuery(String query)
	{
		Statement stmt;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	
}

