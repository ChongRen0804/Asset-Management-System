package dao;
import entity.Manager;
/**
 * 登录界面功能Dao类
 * @author 任翀
 * 2016-7-14
 */
public interface LoginandRegisterDao {
	public int search(Manager manager);
	public int find(Manager manager);
	public int add(Manager manager);
}
