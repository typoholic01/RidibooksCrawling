package web.db.vo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User implements Serializable {
	private static final long serialVersionUID = -7935894412001241428L;
	
	private String email;
	private String nickname;
	private String password;
	private int auth;
	private int status;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", nickname=" + nickname + ", password=" + password + ", auth=" + auth
				+ ", status=" + status + "]";
	}

}
