package dao;
import entity.Manager;
/**
 * ��¼���湦��Dao��
 * @author ����
 * 2016-7-14
 */
public interface LoginandRegisterDao {
	public int search(Manager manager);
	public int find(Manager manager);
	public int add(Manager manager);
}
