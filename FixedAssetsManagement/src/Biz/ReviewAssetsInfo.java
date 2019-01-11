package Biz;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import entity.Asset;
import entity.bigClass;
import entity.smallClass;
import dao.ReviewAssetsInfoDao;
import dao.ReviewAssetsInfoDaoImpl;
/**
 * 资产信息浏览与查询类
 * @author 刘鹏鑫
 * 2016-7-15
 */
public class ReviewAssetsInfo {
	public void reviewType(){
		System.out.println("按类别浏览>>>");
		List<bigClass> bigclasses=new ArrayList();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		bigclasses=RAIDao.showbigClass();
		if(bigclasses!=null){
			Iterator it=bigclasses.iterator();
			while(it.hasNext()){
				bigClass bigclass=(bigClass)it.next();
				System.out.println(bigclass.getId()+"."+bigclass.getBigclassname());
			}
		}
		System.out.println("请选择命令:");
		Scanner input=new Scanner(System.in);
		int bigClassID=input.nextInt();
		List<smallClass> smallclasses=new ArrayList();
		smallclasses=RAIDao.showsmallClass(bigClassID);
		int i=0;
		if(smallclasses!=null){
			Iterator it=smallclasses.iterator();
			while(it.hasNext()){
				smallClass smallclass=(smallClass)it.next();
				System.out.println((i+1)+"."+smallclass.getSmallclassname());
				i++;
			}
		}
		System.out.println("请选择命令:");
		int choice=input.nextInt();
		String smallClassName=null;
		i=1;
		if(smallclasses!=null){
			Iterator it=smallclasses.iterator();
			while(it.hasNext()){
				smallClass smallclass=(smallClass)it.next();
				if(i==choice){
					smallClassName=smallclass.getSmallclassname();
					break;
				}
				i++;
			}
		}
		List<Asset> assets=new ArrayList();
		assets=RAIDao.showAssets(smallClassName);
		System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
		if(assets!=null){
			Iterator it=assets.iterator();
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
		}
		System.out.println(">>>该类别的所有资产已打印完毕");
	}
	public void searchID(){
		System.out.println("按资产编号查询>>>");
		System.out.println("请输入要查询的资产编号：");
		Scanner input=new Scanner(System.in);
		int id=input.nextInt();
		Asset asset=new Asset();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		asset=RAIDao.searchID(id);
		if(asset!=null){
			System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
			System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			System.out.println(">>>该编号的资产信息已打印完毕");
		}
		else
			System.out.println(">>>未查找到该编号的资产");
	}
	public void searchType(){
		System.out.println("按资产类别查询>>>");
		System.out.println("请输入要查询的资产类别：");
		Scanner input=new Scanner(System.in);
		String type=input.next();
		List<Asset> assets=new ArrayList();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		assets=RAIDao.searchType(type);
		if(assets!=null){
			Iterator it=assets.iterator();
			System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
				System.out.println(">>>该类别的所有资产已打印完毕");
			}
		}
		else
			System.out.println(">>>未查找到该类别的资产");
	}
	public void searchUser(){
		System.out.println("按资产使用者查询>>>");
		System.out.println("请输入要查询的资产使用者：");
		Scanner input=new Scanner(System.in);
		String userName=input.next();
		List<Asset> assets=new ArrayList();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		assets=RAIDao.searchUser(userName);
		if(assets!=null){
			Iterator it=assets.iterator();
			System.out.println("编号\t名称\t类别\t型号\t价值\t购买日期\t\t状态\t使用者\t备注");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
			System.out.println(">>>该使用者的所有资产已打印完毕");
		}
		else
			System.out.println(">>>未查找到该使用者的资产");
	}
}
