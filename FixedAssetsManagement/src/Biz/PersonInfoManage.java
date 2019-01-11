package Biz;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import entity.Person;
import dao.PersonInfoManageDao;
import dao.PersonInfoManageDaoImpl;
/**
 * ��Ա������
 * @author ������
 * 2016-7-13
 */
public class PersonInfoManage {
	public void showAll(){
		System.out.println("��ӡ������Ա��Ϣ>>>");
		List<Person> per=new ArrayList();
		PersonInfoManageDao personinfomanagedao=new PersonInfoManageDaoImpl();
		per=personinfomanagedao.showAll();
		System.out.println("ID\t����\tְ��\t��ע");
		if(per!=null){
			Iterator it=per.iterator();
			while(it.hasNext()){
				Person perr=(Person)it.next();
				System.out.println(perr.getId()+"\t"+perr.getName()+"\t"+perr.getPosition()+"\t"+perr.getRemark());
			}
			System.out.println(">>>������Ա��Ϣ�Ѵ�ӡ���");
		}
	}
	public void add(){
		System.out.println("�������Ա��Ϣ>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������������");
		String name=input.next();
		System.out.println("������ְ��");
		String position=input.next();
		System.out.println("�����뱸ע��");
		String remark=input.next();
		Person per=new Person();
		per.setName(name);
		per.setPosition(position);
		per.setRemark(remark);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		if(perdao.findByName(name)!=null){
			System.out.println(">>>����Ա�Ѵ��ڣ�����������������");
		}
		else{
			int result=perdao.add(per);
			if(result==1)
				System.out.println(">>>����Ա��Ϣ��ӳɹ�");
			else
				System.out.println(">>>����Ա��Ϣ���ʧ��");
		}
	}
	public void edit(){
		System.out.println("�޸���Ա��Ϣ>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�޸���Ա��������");
		String name=input.next();
		System.out.println("��������ְ��");
		String position=input.next();
		System.out.println("�������±�ע��");
		String remark=input.next();
		Person per=new Person();
		per.setName(name);
		per.setPosition(position);
		per.setRemark(remark);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		int result=perdao.edit(per);
		if(result==1)
			System.out.println(">>>��Ա��Ϣ�޸ĳɹ�");
		else
			System.out.println(">>>��Ա��Ϣ�޸�ʧ��");
	}
	public void del(){
		System.out.println("ɾ����Ա��Ϣ>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ������Ա������");
		String name=input.next();
		Person per=new Person();
		per.setName(name);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		if(perdao.findByName(name)!=null){
			int result=perdao.del(per);
			if(result==1)
				System.out.println(">>>��Ա��Ϣɾ���ɹ�");
			else
				System.out.println(">>>��Ա��Ϣɾ��ʧ��");
		}
		else
			System.out.println(">>>δ�ҵ�����������Ա��ɾ��ʧ��");
	}
}
