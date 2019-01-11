package Biz;
import java.util.Scanner;

import dao.EditPasswordDao;
import dao.EditPasswordDaoImpl;
import entity.Manager;
/**
 * 修改管理员密码类
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class EditPassword {
	public void edit(String name){//修改管理员密码
		System.out.println("修改管理员密码>>>");
		System.out.println("请输入新密码：");
		Scanner input=new Scanner(System.in);
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		EditPasswordDao editpassworddao=new EditPasswordDaoImpl();
		int result=editpassworddao.update(manager);
		if(result==1){
			System.out.println(">>>修改密码成功");
		}
		else{
			System.out.println(">>>修改密码失败");
		}
	}
}
