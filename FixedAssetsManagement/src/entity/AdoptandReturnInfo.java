package entity;
/**
 * 领用与归还信息类
 * @author 刘鹏鑫
 * 2016-7-16
 */
public class AdoptandReturnInfo {
	private int id;
	private int equipmentID;
	private String adoptDate;
	private String adoptManager;
	private String purpose;
	private String remark;
	private String returnDate;
	private String returnManager;
	public int getId() {
		return id;
	}
	public int getEquipmentID() {
		return equipmentID;
	}
	public String getAdoptDate() {
		return adoptDate;
	}
	public String getAdoptManager() {
		return adoptManager;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getRemark() {
		return remark;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public String getReturnManager() {
		return returnManager;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}
	public void setAdoptDate(String adoptDate) {
		this.adoptDate = adoptDate;
	}
	public void setAdoptManager(String adoptManager) {
		this.adoptManager = adoptManager;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public void setReturnManager(String returnManager) {
		this.returnManager = returnManager;
	}
}
