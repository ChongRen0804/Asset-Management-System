package Biz;
import java.util.Scanner;

import dao.LoginandRegisterDao;
import dao.LoginandRegisterDaoImpl;
import entity.Manager;
import MainMenu.Menu;
/**
 * ��¼���湦����
 * @author ����
 * 2016-7-14
 */
public class LoginandRegister {
	public String login()//////��¼
	{
		System.out.println("��¼>>>");
		System.out.println("�������û�����");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		System.out.println("���������룺");
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		LoginandRegisterDao editpassworddao=new LoginandRegisterDaoImpl();
		int result=editpassworddao.find(manager);
		if(result==1){
			System.out.println(">>>��¼�ɹ�");
			return name;
		}
		else{
			System.out.println(">>>��¼ʧ��");
			return null;
		}
	}

	public void register()//////ע��
	{
		System.out.println("ע��>>>");
		System.out.println("�������û�����");
		Scanner input=new Scanner(System.in);
		String name=input.next();
		System.out.println("����������");
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		LoginandRegisterDao editpassworddao=new LoginandRegisterDaoImpl();
		int result=editpassworddao.search(manager);
		if(result==1){
			System.out.println(">>>�û����ظ���ע��ʧ�ܣ�");
		}
		else{
			result=editpassworddao.add(manager);
			if(result==1){
				System.out.println(">>>ע��ɹ�");
			}
			else{
				System.out.println(">>>ע��ʧ��");
			}
		}
	}
}
