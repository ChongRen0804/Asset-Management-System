package Biz;
import java.util.Scanner;

import dao.EditPasswordDao;
import dao.EditPasswordDaoImpl;
import entity.Manager;
/**
 * �޸Ĺ���Ա������
 * @author ������
 * 2016-7-13
 */
public class EditPassword {
	public void edit(String name){//�޸Ĺ���Ա����
		System.out.println("�޸Ĺ���Ա����>>>");
		System.out.println("�����������룺");
		Scanner input=new Scanner(System.in);
		String password=input.next();
		Manager manager=new Manager();
		manager.setName(name);
		manager.setPassword(password);
		EditPasswordDao editpassworddao=new EditPasswordDaoImpl();
		int result=editpassworddao.update(manager);
		if(result==1){
			System.out.println(">>>�޸�����ɹ�");
		}
		else{
			System.out.println(">>>�޸�����ʧ��");
		}
	}
}
