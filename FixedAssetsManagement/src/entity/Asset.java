package entity;
/**
 * 资产信息类
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class Asset {
	private int id;//资产编号
	private String name;//资产名称
	private String type;//资产类别
	private String model;//资产型号
	private float value;//资产价值
	private String purchaseDate;//资产购买日期
	private String state;//资产状态
	private String userName;//资产使用者
	private String remark;//资产备注
	public int getId() {
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getModel() {
		return model;
	}
	public float getValue() {
		return value;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public String getState() {
		return state;
	}
	public String getUserName() {
		return userName;
	}
	public String getRemark() {
		return remark;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
