package MainMenu;
import java.util.Scanner;

import Biz.EditPassword;
import Biz.FixedAssetsManage;
import Biz.PersonInfoManage;
import Biz.AdoptandReturn;
import Biz.ReviewAssetsInfo;
import Biz.LoginandRegister;
/**
 * 管理系统框架，包括三级菜单
 * @author 任翀
 * 2016-7-13
 */
public class Menu {
	private String name;
	public void firstMenu()
	{
		int choice;
		do{
			//登录界面
			System.out.println("***********登录界面***********");
			System.out.println("\t1. 注册用户");
			System.out.println("\t2. 登录");
			System.out.println("\t3. 退出");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			LoginandRegister lr=new LoginandRegister();
			choice=input.nextInt();
			switch(choice){
			case 1:
				//注册用户
				lr.register();
				break;
			case 2:
				//登录
				if((this.name=lr.login())!=null)
				{
					mainMenu();
				}
				else
					break;
			case 3:
				//退出系统
				System.out.println("***********成功退出系统***********");
				System.exit(0);
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(choice!=3);
	}

	public void mainMenu()//二级菜单
	{
		int choice;
		do{
			//主界面
			System.out.println("***********系统主界面***********");
			System.out.println("\t1. 修改密码");
			System.out.println("\t2. 固定资产管理");
			System.out.println("\t3. 人员信息管理");
			System.out.println("\t4. 资产领用与归还");
			System.out.println("\t5. 资产信息浏览查询");
			System.out.println("\t6. 退出系统");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			choice=input.nextInt();
			switch(choice){
			case 1:
				//进入修改密码界面
				passwordMenu();
				break;
			case 2:
				//进入固定资产管理界面
				FixedAssetsMenu();
				break;
			case 3:
				//进入人员信息管理界面
				personinfoMenu();
				break;
			case 4:
				//进入资产领用与归还管理界面
				adoptandreturnMenu();
				break;
			case 5:
				//进入资产信息浏览查询管理界面
				reviewassetsMenu();
				break;
			case 6:
				//退出系统
				System.out.println("***********成功退出系统***********");
				System.exit(0);
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(choice!=6);
	}

	public void passwordMenu()
	{
		boolean flag=true;
		//修改密码界面
		do{
			System.out.println("****修改密码界面****");
			System.out.println("1. 修改密码");
			System.out.println("2. 返回上一级");
			EditPassword ep=new EditPassword();
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//进入修改密码界面
				ep.edit(this.name);
				mainMenu();
				break;
			case 2:
				//返回主界面
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void FixedAssetsMenu()
	{
		boolean flag=true;
		do{
			//固定资产管理界面
			System.out.println("****固定资产管理界面****");		
			System.out.println("1. 固定资产类别管理");
			System.out.println("2. 固定资产信息管理");
			System.out.println("3. 返回上一级");
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//固定资产类别管理
				typeMenu();
				break;
			case 2:
				//固定资产信息管理
				infoMenu();
				break;
			case 3:
				//返回固定资产管理界面
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void typeMenu()
	{
		boolean flag=true;
		do{
			//固定资产类别管理界面
			System.out.println("****固定资产类别管理界面****");		
			System.out.println("1. 显示所有类别");
			System.out.println("2. 增加类别");
			System.out.println("3. 删除类别");
			System.out.println("4. 返回上一级");
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//显示所有类别
				fa.showAlltype();
				break;
			case 2:
				//增加类别(考虑大类小类写在哪？)
				fa.addType();
				break;
			case 3:
				//删除类别(考虑大类小类写在哪？)
				fa.delType();
				break;
			case 4:
				//返回上一级
				flag=false;
				FixedAssetsMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void infoMenu()
	{
		boolean flag=true;
		do{
			//固定资产信息管理界面
			System.out.println("****固定资产信息管理界面****");		
			System.out.println("1. 显示所有资产");
			System.out.println("2. 增加资产");
			System.out.println("3. 修改资产");
			System.out.println("4. 删除资产");
			System.out.println("5. 返回上一级");
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//显示所有资产
				fa.showAllAssets();
				break;
			case 2:
				//增加资产
				fa.addAsset();
				break;
			case 3:
				//修改资产
				fa.editAsset();
				break;
			case 4:
				//删除资产
				fa.delAsset();
				break;
			case 5:
				//返回上一级
				flag=false;
				FixedAssetsMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void personinfoMenu()
	{
		boolean flag=true;
		do{
			//人员信息管理界面
			System.out.println("****人员信息管理界面****");		
			System.out.println("1. 显示所有人员");
			System.out.println("2. 增加人员");
			System.out.println("3. 删除人员");
			System.out.println("4. 修改人员");
			System.out.println("5. 返回上一级");
			PersonInfoManage pf=new PersonInfoManage();
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//显示所有人员
				pf.showAll();
				break;
			case 2:
				//增加人员
				pf.add();
				break;
			case 3:
				//删除人员
				pf.del();
				break;
			case 4:
				//修改人员
				pf.edit();
				break;
			case 5:
				//返回上一级
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void adoptandreturnMenu(){
		boolean flag=true;
		do{
			//资产领用与归还界面
			System.out.println("****资产领用与归还界面****");		
			System.out.println("1. 显示所有资产");
			System.out.println("2. 领用资产");
			System.out.println("3. 归还资产");
			System.out.println("4. 显示所有资产的领用归还信息");
			System.out.println("5. 返回上一级");
			AdoptandReturn ar=new AdoptandReturn();
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//显示所有资产
				fa.showAllAssets();
				break;
			case 2:
				//领用资产
				ar.adopt(this.name);
				break;
			case 3:
				//归还资产
				ar.Return(this.name);
				break;
			case 4:
				//显示所有资产的领用归还信息
				ar.showAdoptReturn();
				break;
			case 5:
				//返回上一级
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}

	public void reviewassetsMenu()
	{
		boolean flag=true;
		do{
			//资产信息浏览查询界面
			System.out.println("****资产信息浏览查询界面****");		
			System.out.println("1. 按类别浏览");
			System.out.println("2. 按资产编号查询");
			System.out.println("3. 按小类查询");
			System.out.println("4. 按使用者查询");
			System.out.println("5. 返回上一级");
			ReviewAssetsInfo ra=new ReviewAssetsInfo();
			System.out.print("请选择命令:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//按类别浏览
				ra.reviewType();
				break;
			case 2:
				//按资产编号浏览
				ra.searchID();
				break;
			case 3:
				//按小类浏览
				ra.searchType();
				break;
			case 4:
				//按使用者浏览
				ra.searchUser();
				break;
			case 5:
				//返回上一级
				flag=false;
				mainMenu();
				break;
			default:
				//命令无效
				System.out.println("命令无效!");
			}
		}while(flag);	
	}
}
