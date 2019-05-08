package mx.ipn.escom.wad.entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {
	private String firstName;
	private String lastName;
	private String secondLastName;
	private String CURP;
	private Date birthday;
	private String nickname;
	private String password;
	
	
	public User(String fn, String ln, String sln, 
			String curp, String birthday, String nickname) {
		firstName = fn;
		lastName = ln;
		secondLastName = sln;
		CURP = curp;
		this.birthday = Date.valueOf(birthday); 
		this.nickname = nickname;
		password = null;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	@Override
	public String toString()
	{
	 return "Nombre:"+firstName+"\nApellido:"+lastName+"\nSegundo Apellido:"+secondLastName+
			 "\nCURP:"+CURP+"\nNacimiento:"+birthday+"\nNickname:"+nickname;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSecondLastName() {
		return secondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}
	public String getCURP() {
		return CURP;
	}
	public void setCURP(String cURP) {
		CURP = cURP;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = Date.valueOf(birthday);
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	
}
