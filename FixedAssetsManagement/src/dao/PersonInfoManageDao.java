package dao;
import java.util.List;

import entity.Person;
/**
 * 人员管理接口
 * @author 刘鹏鑫
 * 2016-7-13
 */
public interface PersonInfoManageDao {
	public int add(Person per);
	public int del(Person per);
	public int edit(Person per);
	public Person findByName(String name);
	List<Person> showAll();
}
