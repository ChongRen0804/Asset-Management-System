package entity;
/**
 * ��Ա��Ϣ��
 * @author ������
 * 2016-7-13
 */
public class Person {
	private int id;//�����ʲ�����Ա���
	private String name;//����
	private String position;//ְ��
	private String remark;//��ע
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
