package dao;
import entity.Manager;
/**
 * 修改管理员密码的数据库实现
 * @author 刘鹏鑫
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
