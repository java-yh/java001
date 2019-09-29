/**
 * 
 */
package cn.yunhe.entity;

/**
 * @迪丽惹bug
 *
 * 2019年9月25日下午5:28:41
 */
public class UserInfo {
	
	private int userid;
	private String username;
	private String password;
	public UserInfo() {}
	/**
	 * @param userid
	 * @param username
	 * @param password
	 */
	public UserInfo(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	
}
