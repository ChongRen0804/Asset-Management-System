package entity;
/**
 * 人员信息类
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class Person {
	private int id;//领用资产的人员编号
	private String name;//姓名
	private String position;//职务
	private String remark;//备注
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
