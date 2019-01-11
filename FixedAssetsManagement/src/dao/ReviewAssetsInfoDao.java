package dao;
import java.util.List;

import entity.bigClass;
import entity.smallClass;
import entity.Asset;
/**
 * �ʲ���Ϣ������ѯ�ӿ�
 * @author ������
 * 2016-7-15
 */
public interface ReviewAssetsInfoDao {
	public List<bigClass> showbigClass();
	public List<smallClass> showsmallClass(int bigClassID);
	public List<Asset> showAssets(String smallClassName);
	public Asset searchID(int id);
	public List<Asset> searchType(String type);
	public List<Asset> searchUser(String userName);
}
