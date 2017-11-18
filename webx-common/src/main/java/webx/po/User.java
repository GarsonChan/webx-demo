package webx.po;

import java.io.Serializable;

/**
 * Created by Garson in 22:48 2017/11/9
 * Description :
 */
public class User implements Serializable {

	int id;
	String userName;
	String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
