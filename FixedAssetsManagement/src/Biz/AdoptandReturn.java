package Biz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.AdoptandReturnDao;
import dao.AdoptandReturnDaoImpl;
import dao.ReviewAssetsInfoDao;
import dao.ReviewAssetsInfoDaoImpl;
import entity.Asset;
import entity.AdoptandReturnInfo;
/**
 * 资产领用与归还类
 * @author 刘鹏鑫
 * 2016-7-15
 */
public class AdoptandReturn {
	public void adopt(String name){
		System.out.println("资产领用>>>");
		System.out.println("请输入领用人员姓名：");
		Scanner input=new Scanner(System.in);
		String adoptName=input.next();
		AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
		if(ARDao.isRegister(adoptName)){
			System.out.println("请输入要领用的资产设备编号：");
			int id=input.nextInt();
			ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
			Asset asset=RAIDao.searchID(id);
			String state=asset.getState();
			String userName=asset.getUserName();
			if(state.equals("正常")&&userName==null){
				System.out.println("请输入领用日期：");
				String date=input.next();
				System.out.println("请输入用途：");
				String purpose=input.next();
				System.out.println("请输入备注：");
				String remark=input.next();
				int result1=ARDao.add(id, date, name, purpose, remark);
				int result2=ARDao.update(id, adoptName);
				System.out.println(">>>领用成功");
			}
			else if(state.equals("正常")&&userName!=null)
				System.out.println(">>>该设备已经被"+userName+"领用，请等设备归还后再来领用");
			else if(state.equals("维修")&&userName==null)
				System.out.println(">>>该设备正在维修，请等设备恢复后再来领用");
			else
				System.out.println(">>>该设备已经报废，不能被领用");
		}
		else
			System.out.println(">>>该人员还未登记，请先完成登记");
	}
	public void Return(String name){
		System.out.println("资产归还>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入要归还的资产设备编号：");
		int id=input.nextInt();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		Asset asset=RAIDao.searchID(id);
		String state=asset.getState();
		String userName=asset.getUserName();
		if(state.equals("正常")&&userName!=null){
			System.out.println("请输入归还日期：");
			String date=input.next();
			AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
			int result1=ARDao.updateadd(id, date, name);
			int result2=ARDao.updatedel(id);
			System.out.println(">>>归还成功");
		}
		else if(state.equals("正常")&&userName==null)
			System.out.println(">>>该设备还未被领用，不能归还");
		else if(state.equals("维修")&&userName==null)
			System.out.println(">>>该设备正在维修，不能归还");
		else
			System.out.println(">>>该设备已经报废，不能归还");
	}
	public void showAdoptReturn(){
		System.out.println("打印所有资产的领用归还信息>>>");
		List<AdoptandReturnInfo> AaRIs=new ArrayList();
		AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
		AaRIs=ARDao.showAllAdoptReturn();
		System.out.println("设备编号\t领用日期\t\t领用操作管理员\t用途\t备注\t归还日期\t\t归还操作管理员");
		if(AaRIs!=null){
			Iterator it=AaRIs.iterator();
			while(it.hasNext()){
				AdoptandReturnInfo AaRI=(AdoptandReturnInfo)it.next();
				System.out.print(AaRI.getEquipmentID()+"\t"+AaRI.getAdoptDate()+"\t"+AaRI.getAdoptManager()+"\t\t"+AaRI.getPurpose()+"\t"+AaRI.getRemark()+"\t");
				if(AaRI.getReturnDate()!=null)
					System.out.println(AaRI.getReturnDate()+"\t"+AaRI.getReturnManager());
				else
					System.out.println(AaRI.getReturnDate()+"\t\t"+AaRI.getReturnManager());
			}
			System.out.println(">>>所有资产的领用归还信息已打印完毕");
		}
	}
}
