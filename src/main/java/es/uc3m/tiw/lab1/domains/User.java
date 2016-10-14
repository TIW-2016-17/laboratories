
package es.uc3m.tiw.lab1.domains;

/**
 * @author David Palomar
 *
 */
public class User {
	private String name;
	private String lastName;
	private String user;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String lastName, String user,
			String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.user = user;
		this.password = password;
	}
	public User(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String usuario) {
		this.user = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
