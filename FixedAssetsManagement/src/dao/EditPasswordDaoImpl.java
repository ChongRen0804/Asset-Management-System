package dao;
import entity.Manager;
/**
 * �޸Ĺ���Ա��������ݿ�ʵ��
 * @author ������
 * 2016-7-13
 */
public class EditPasswordDaoImpl extends BaseDao implements EditPasswordDao{
	public int update(Manager manager) {
		String sql="update Manager set password=? where name=?";
		Object[] param={manager.getPassword(),manager.getName()};
		int result=this.executeUpdate(sql,param);
		return result;
	}
}
