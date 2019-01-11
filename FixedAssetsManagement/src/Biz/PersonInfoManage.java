package Biz;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import entity.Person;
import dao.PersonInfoManageDao;
import dao.PersonInfoManageDaoImpl;
/**
 * 人员管理类
 * @author 刘鹏鑫
 * 2016-7-13
 */
public class PersonInfoManage {
	public void showAll(){
		System.out.println("打印所有人员信息>>>");
		List<Person> per=new ArrayList();
		PersonInfoManageDao personinfomanagedao=new PersonInfoManageDaoImpl();
		per=personinfomanagedao.showAll();
		System.out.println("ID\t姓名\t职务\t备注");
		if(per!=null){
			Iterator it=per.iterator();
			while(it.hasNext()){
				Person perr=(Person)it.next();
				System.out.println(perr.getId()+"\t"+perr.getName()+"\t"+perr.getPosition()+"\t"+perr.getRemark());
			}
			System.out.println(">>>所有人员信息已打印完毕");
		}
	}
	public void add(){
		System.out.println("添加新人员信息>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name=input.next();
		System.out.println("请输入职务：");
		String position=input.next();
		System.out.println("请输入备注：");
		String remark=input.next();
		Person per=new Person();
		per.setName(name);
		per.setPosition(position);
		per.setRemark(remark);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		if(perdao.findByName(name)!=null){
			System.out.println(">>>改人员已存在，请更换姓名后再添加");
		}
		else{
			int result=perdao.add(per);
			if(result==1)
				System.out.println(">>>新人员信息添加成功");
			else
				System.out.println(">>>新人员信息添加失败");
		}
	}
	public void edit(){
		System.out.println("修改人员信息>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要修改人员的姓名：");
		String name=input.next();
		System.out.println("请输入新职务：");
		String position=input.next();
		System.out.println("请输入新备注：");
		String remark=input.next();
		Person per=new Person();
		per.setName(name);
		per.setPosition(position);
		per.setRemark(remark);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		int result=perdao.edit(per);
		if(result==1)
			System.out.println(">>>人员信息修改成功");
		else
			System.out.println(">>>人员信息修改失败");
	}
	public void del(){
		System.out.println("删除人员信息>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除的人员姓名：");
		String name=input.next();
		Person per=new Person();
		per.setName(name);
		PersonInfoManageDao perdao=new PersonInfoManageDaoImpl();
		if(perdao.findByName(name)!=null){
			int result=perdao.del(per);
			if(result==1)
				System.out.println(">>>人员信息删除成功");
			else
				System.out.println(">>>人员信息删除失败");
		}
		else
			System.out.println(">>>未找到该姓名的人员，删除失败");
	}
}
