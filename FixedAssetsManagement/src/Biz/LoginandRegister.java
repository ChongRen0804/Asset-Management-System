package Biz;
import java.util.Scanner;

import dao.LoginandRegisterDao;
import dao.LoginandRegisterDaoImpl;
import entity.Manager;
import MainMenu.Menu;
/**
 * 登录界面功能类
 * @author 任翀
 * 2016-7-14
 */
public class LoginandRegister {
	public String login()//////登录
	{
		System.out.println("登录>>>");
		System.out.println("请输入用户名：");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		System.out.println("请输入密码：");
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		LoginandRegisterDao editpassworddao=new LoginandRegisterDaoImpl();
		int result=editpassworddao.find(manager);
		if(result==1){
			System.out.println(">>>登录成功");
			return name;
		}
		else{
			System.out.println(">>>登录失败");
			return null;
		}
	}

	public void register()//////注册
	{
		System.out.println("注册>>>");
		System.out.println("请输入用户名：");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		System.out.println("请输入密码");
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		LoginandRegisterDao editpassworddao=new LoginandRegisterDaoImpl();
		int result=editpassworddao.search(manager);
		if(result==1){
			System.out.println(">>>用户名重复，注册失败！");
		}
		else{
			result=editpassworddao.add(manager);
			if(result==1){
				System.out.println(">>>注册成功");
			}
			else{
				System.out.println(">>>注册失败");
			}
		}
	}
}
