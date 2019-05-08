package mx.ipn.escom.wad.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mx.ipn.escom.wad.entities.User;
import mx.ipn.escom.wad.util.ConexionBD;

public class UserDao {

	private List<User> users;
	private ConexionBD conexion;
	
	public UserDao()
	{
	users = new ArrayList<User>();	
	conexion = new ConexionBD();
	}
	
	public boolean insertUser(User user)
	{
		conexion.connect();
		boolean success = false;
		String query = null;
		PreparedStatement ps;
		try {
			query = " INSERT INTO person(tx_first_name,tx_last_name_a,tx_last_name_b,tx_curp,fh_birth)"
					+ "VALUES(?,?,?,?,?)";
			ps = conexion.getConnection().prepareStatement(query);
			ps.setString(1,user.getFirstName());
			ps.setString(2,user.getLastName());
			ps.setString(3, user.getSecondLastName());
			ps.setString(4, user.getCURP());
			ps.setDate(5, user.getBirthday());
			ps.executeUpdate();
			ps.close();
			success = true;
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
			success = false;
		}
		
		int id = 2500;
		try {
			query = "SELECT id_person FROM person WHERE tx_curp='"+user.getCURP()+"';";
			ResultSet set = conexion.doQuery(query);
			while(set.next())
			{
				id = set.getInt(1);	
			}
			System.out.println("Id es:"+id);
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		
		try {
			query = "INSERT INTO users(id_user,tx_login,tx_password) VALUES(?,?,?)";
			ps = conexion.getConnection().prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, user.getNickname());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			ps.close();
			success = success && true;
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
			success = false;
		}
		conexion.disconnect();
		return success;
	}
	
	
	public User getUser(String login,String password)
	{
		User user = null;
		conexion.connect();
		ResultSet result = null;
		String lr = null;
		String pr = null;
		int id = 0;
		String query = null;
		try {
			query ="SELECT id_user,tx_login, tx_password FROM users WHERE tx_login = ? ";
			PreparedStatement ps = conexion.getConnection().prepareStatement(query);
			ps.setString(1,login);
			result = ps.executeQuery();
			if(result.next())
			{
				lr = result.getString("tx_login");
			    pr = result.getString("tx_password");
			    id = result.getInt("id_user");
			}
		    ps.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if( lr == null || (!password.equals(pr)))
		{
			return user;
		}
		result = conexion.doQuery("SELECT * FROM person WHERE id_person="+id+";");
		try {
			while(result.next())
			{
				user = new User(result.getString(2), result.getString(3),
						result.getString(4), result.getString(5),result.getString(6),lr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPassword(password);
		conexion.disconnect();
		return user;
	}
	
	
	public List<User> getUsers()
	{
		conexion.connect();
		String query = "SELECT person.tx_first_name, person.tx_last_name_a, person.tx_last_name_b, person.tx_curp, "
				+ "person.fh_birth, users.tx_login FROM person JOIN users ON person.id_person = users.id_user; ";
		ResultSet result = conexion.doQuery(query);
		try {
			while(result.next())
			{
				users.add( new User(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),result.getString(5),
						result.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conexion.disconnect();
		return users;
	}
	
}
