package entity;
/**
 * �ʲ���Ϣ��
 * @author ������
 * 2016-7-13
 */
public class Asset {
	private int id;//�ʲ����
	private String name;//�ʲ�����
	private String type;//�ʲ����
	private String model;//�ʲ��ͺ�
	private float value;//�ʲ���ֵ
	private String purchaseDate;//�ʲ���������
	private String state;//�ʲ�״̬
	private String userName;//�ʲ�ʹ����
	private String remark;//�ʲ���ע
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
