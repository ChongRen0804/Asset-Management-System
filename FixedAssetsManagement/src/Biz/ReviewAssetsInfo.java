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
 * �ʲ���Ϣ������ѯ��
 * @author ������
 * 2016-7-15
 */
public class ReviewAssetsInfo {
	public void reviewType(){
		System.out.println("��������>>>");
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
		System.out.println("��ѡ������:");
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
		System.out.println("��ѡ������:");
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
		System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
		if(assets!=null){
			Iterator it=assets.iterator();
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
		}
		System.out.println(">>>�����������ʲ��Ѵ�ӡ���");
	}
	public void searchID(){
		System.out.println("���ʲ���Ų�ѯ>>>");
		System.out.println("������Ҫ��ѯ���ʲ���ţ�");
		Scanner input=new Scanner(System.in);
		int id=input.nextInt();
		Asset asset=new Asset();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		asset=RAIDao.searchID(id);
		if(asset!=null){
			System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
			System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			System.out.println(">>>�ñ�ŵ��ʲ���Ϣ�Ѵ�ӡ���");
		}
		else
			System.out.println(">>>δ���ҵ��ñ�ŵ��ʲ�");
	}
	public void searchType(){
		System.out.println("���ʲ�����ѯ>>>");
		System.out.println("������Ҫ��ѯ���ʲ����");
		Scanner input=new Scanner(System.in);
		String type=input.next();
		List<Asset> assets=new ArrayList();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		assets=RAIDao.searchType(type);
		if(assets!=null){
			Iterator it=assets.iterator();
			System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
				System.out.println(">>>�����������ʲ��Ѵ�ӡ���");
			}
		}
		else
			System.out.println(">>>δ���ҵ��������ʲ�");
	}
	public void searchUser(){
		System.out.println("���ʲ�ʹ���߲�ѯ>>>");
		System.out.println("������Ҫ��ѯ���ʲ�ʹ���ߣ�");
		Scanner input=new Scanner(System.in);
		String userName=input.next();
		List<Asset> assets=new ArrayList();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		assets=RAIDao.searchUser(userName);
		if(assets!=null){
			Iterator it=assets.iterator();
			System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
			System.out.println(">>>��ʹ���ߵ������ʲ��Ѵ�ӡ���");
		}
		else
			System.out.println(">>>δ���ҵ���ʹ���ߵ��ʲ�");
	}
}
