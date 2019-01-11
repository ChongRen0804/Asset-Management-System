package Biz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.FixedAssetsManageDao;
import dao.FixedAssetsManageDaoImpl;
import entity.Asset;
import entity.bigClass;
import entity.smallClass;
/**
 * 固定资产管理功能类
 * @author 任翀
 * 2016-7-15
 */
public class FixedAssetsManage {
	public void showAlltype(){
		System.out.println("打印所有类别>>>");
		List<bigClass> bigtypelist=new ArrayList<bigClass>();
		List<smallClass> smalltypelist=new ArrayList<smallClass>();
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		bigtypelist=fa.getBigclass();
		smalltypelist=fa.getSmallclass();
		System.out.println("\tID\t\t类名\t\t大类ID");
		int i=1;
		if(bigtypelist!=null){
			Iterator bigit=bigtypelist.iterator();
			while(bigit.hasNext()){
				bigClass bc=(bigClass)bigit.next();
				System.out.println("大类"+i+":\t"+bc.getId()+"\t\t"+bc.getBigclassname());
				if(smalltypelist!=null){
					Iterator smallit=smalltypelist.iterator();
					System.out.print("小类：");
					while(smallit.hasNext()){
						smallClass sc=(smallClass)smallit.next();
						if(sc.getBigclassID()==bc.getId())
							System.out.println("\t"+sc.getId()+"\t\t"+sc.getSmallclassname()+"\t\t"+sc.getBigclassID());
					}
				}
				i++;
			}
			System.out.println(">>>所有类别已打印完毕");
		}
	}

	public void addType(){
		System.out.println("请输入你想添加的类别:(1.大类  2.小类)>>>");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1)
		{
			System.out.println("请输入大类名:");
			String bigclassname=input.next();
			bigClass bc=new bigClass();
			bc.setBigclassname(bigclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			if(fa.findByBigName(bigclassname)!=null){
				System.out.println(">>>该大类已存在，请更换类名后再添加");
			}
			else{
				int result=fa.addBigClass(bc);
				if(result==1)
					System.out.println(">>>新建大类成功");
				else
					System.out.println(">>>新建大类失败");
			}
		}
		else
		{
			System.out.println("请输入小类名:");
			String smallclassname=input.next();
			System.out.println("请输入小类所属的大类ID:");
			int bigclassid=input.nextInt();
			smallClass sc=new smallClass();
			sc.setSmallclassname(smallclassname);
			sc.setBigclassID(bigclassid);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			if(fa.findBySmallName(smallclassname)!=null){
				System.out.println(">>>该小类已存在，请更换类名后再添加");
			}
			else{
				int result=fa.addSmallClass(sc);
				if(result==1)
					System.out.println(">>>新建小类成功");
				else
					System.out.println(">>>新建小类失败");
			}

		}
	}

	public void delType(){
		System.out.println("请输入你想删除的类别:(1.大类  2.小类)>>>");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1)
		{
			System.out.println("请输入要删除的大类名:");
			String bigclassname=input.next();
			bigClass bc=new bigClass();
			bc.setBigclassname(bigclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			int result=fa.delBigClass(bc);
			if(result==1)
				System.out.println(">>>删除大类成功");
			else
				System.out.println(">>>删除大类失败");
			List<smallClass> smalltypelist=new ArrayList<smallClass>();
			smalltypelist=fa.getSmallclass();
			if(smalltypelist!=null)
			{
				Iterator smallit=smalltypelist.iterator();
				while(smallit.hasNext()){
					smallClass sc=(smallClass)smallit.next();
					if(sc.getBigclassID()==bc.getId())
					{

						int result2=fa.delSmallClass(sc);
						if(result==1)
							System.out.println(">>>删除小类成功");
						else
							System.out.println(">>>删除小类失败");
					}
				}
			}
		}
		else
		{
			System.out.println("请输入要删除的小类名:");
			String smallclassname=input.next();
			smallClass sc=new smallClass();
			sc.setSmallclassname(smallclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			int result=fa.delSmallClass(sc);
			if(result==1)
				System.out.println(">>>删除小类成功");
			else
				System.out.println(">>>删除小类失败");
		}
	}

	public void showAllAssets()
	{
		System.out.println("显示所有资产>>>");
		List<Asset> assetlist=new ArrayList<Asset>();
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		assetlist=fa.getAsset();
		if(assetlist!=null){
			Iterator it=assetlist.iterator();
			System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
			System.out.println(">>>所有资产信息已显示完毕");
		}
	}

	public void addAsset(){
		System.out.println("添加新资产信息>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入资产名称：");
		String name=input.next();
		System.out.println("请输入资产类型：");
		String type=input.next();
		System.out.println("请输入资产型号：");
		String model=input.next();
		System.out.println("请输入资产价值：");
		float value=input.nextFloat();
		System.out.println("请输入资产购买日期：");
		String purchaseDate=input.next();
		System.out.println("请输入资产状态：");
		String state=input.next();
		System.out.println("请输入资产使用者姓名：");
		String username=input.next();
		System.out.println("请输入资产备注：");
		String remark=input.next();
		Asset as=new Asset();
		as.setName(name);
		as.setType(type);
		as.setModel(model);
		as.setValue(value);
		as.setPurchaseDate(purchaseDate);
		as.setState(state);
		as.setUserName(username);
		as.setRemark(remark);
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		if(fa.findByAssetName(as.getName())!=null){
			System.out.println(">>>改资产已存在，请更换名称后再添加");
		}
		else{
			int result=fa.addAsset(as);
			if(result==1)
				System.out.println(">>>新资产信息添加成功");
			else
				System.out.println(">>>新资产信息添加失败");
		}
	}

	public void editAsset(){
		System.out.println("修改资产信息>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要修改的资产名称：");
		String name=input.next();
		System.out.println("请输入新的资产类型：");
		String type=input.next();
		System.out.println("请输入新的资产型号：");
		String model=input.next();
		System.out.println("请输入新的资产价值：");
		float value=input.nextFloat();
		System.out.println("请输入新的资产购买日期：");
		String purchaseDate=input.next();
		System.out.println("请输入新的资产状态：");
		String state=input.next();
		System.out.println("请输入新的资产使用者姓名：");
		String username=input.next();
		System.out.println("请输入新的资产备注：");
		String remark=input.next();
		Asset as=new Asset();
		as.setName(name);
		as.setType(type);
		as.setModel(model);
		as.setValue(value);
		as.setPurchaseDate(purchaseDate);
		as.setState(state);
		as.setUserName(username);
		as.setRemark(remark);
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		int result=fa.editAsset(as);
		if(result==1)
			System.out.println(">>>资产信息修改成功");
		else
			System.out.println(">>>资产信息修改失败");
	}

	public void delAsset(){
		System.out.println("删除资产>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要删除的资产名称：");
		String name=input.next();
		Asset as=new Asset();
		as.setName(name);
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		if(fa.findByAssetName(name)!=null){
			int result=fa.delAs(as);
			if(result==1)
				System.out.println(">>>资产删除成功");
			else
				System.out.println(">>>资产删除失败");
		}
		else
			System.out.println(">>>未找到该资产，删除失败");
	}
}
