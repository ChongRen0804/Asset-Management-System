package entity;
/**
 * 管理员信息类
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class Manager {
	int id;//管理员ID
	String name;//管理员姓名
	String password;//管理员密码
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
