package dao;
import java.util.List;

import entity.AdoptandReturnInfo;
/**
 * �ʲ�������黹�ӿ�
 * @author ������
 * 2016-7-15
 */
public interface AdoptandReturnDao {
	public boolean isRegister(String adoptName);
	public int add(int id,String date,String name,String purpose,String remark);
	public int update(int id,String adoptName);
	public int updateadd(int id,String date,String name);
	public int updatedel(int id);
	public List<AdoptandReturnInfo> showAllAdoptReturn();
}
