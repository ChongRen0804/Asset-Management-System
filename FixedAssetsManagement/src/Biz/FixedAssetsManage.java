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
 * �̶��ʲ���������
 * @author ����
 * 2016-7-15
 */
public class FixedAssetsManage {
	public void showAlltype(){
		System.out.println("��ӡ�������>>>");
		List<bigClass> bigtypelist=new ArrayList<bigClass>();
		List<smallClass> smalltypelist=new ArrayList<smallClass>();
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		bigtypelist=fa.getBigclass();
		smalltypelist=fa.getSmallclass();
		System.out.println("\tID\t\t����\t\t����ID");
		int i=1;
		if(bigtypelist!=null){
			Iterator bigit=bigtypelist.iterator();
			while(bigit.hasNext()){
				bigClass bc=(bigClass)bigit.next();
				System.out.println("����"+i+":\t"+bc.getId()+"\t\t"+bc.getBigclassname());
				if(smalltypelist!=null){
					Iterator smallit=smalltypelist.iterator();
					System.out.print("С�ࣺ");
					while(smallit.hasNext()){
						smallClass sc=(smallClass)smallit.next();
						if(sc.getBigclassID()==bc.getId())
							System.out.println("\t"+sc.getId()+"\t\t"+sc.getSmallclassname()+"\t\t"+sc.getBigclassID());
					}
				}
				i++;
			}
			System.out.println(">>>��������Ѵ�ӡ���");
		}
	}

	public void addType(){
		System.out.println("������������ӵ����:(1.����  2.С��)>>>");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1)
		{
			System.out.println("�����������:");
			String bigclassname=input.next();
			bigClass bc=new bigClass();
			bc.setBigclassname(bigclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			if(fa.findByBigName(bigclassname)!=null){
				System.out.println(">>>�ô����Ѵ��ڣ�����������������");
			}
			else{
				int result=fa.addBigClass(bc);
				if(result==1)
					System.out.println(">>>�½�����ɹ�");
				else
					System.out.println(">>>�½�����ʧ��");
			}
		}
		else
		{
			System.out.println("������С����:");
			String smallclassname=input.next();
			System.out.println("������С�������Ĵ���ID:");
			int bigclassid=input.nextInt();
			smallClass sc=new smallClass();
			sc.setSmallclassname(smallclassname);
			sc.setBigclassID(bigclassid);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			if(fa.findBySmallName(smallclassname)!=null){
				System.out.println(">>>��С���Ѵ��ڣ�����������������");
			}
			else{
				int result=fa.addSmallClass(sc);
				if(result==1)
					System.out.println(">>>�½�С��ɹ�");
				else
					System.out.println(">>>�½�С��ʧ��");
			}

		}
	}

	public void delType(){
		System.out.println("����������ɾ�������:(1.����  2.С��)>>>");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		if(choice==1)
		{
			System.out.println("������Ҫɾ���Ĵ�����:");
			String bigclassname=input.next();
			bigClass bc=new bigClass();
			bc.setBigclassname(bigclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			int result=fa.delBigClass(bc);
			if(result==1)
				System.out.println(">>>ɾ������ɹ�");
			else
				System.out.println(">>>ɾ������ʧ��");
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
							System.out.println(">>>ɾ��С��ɹ�");
						else
							System.out.println(">>>ɾ��С��ʧ��");
					}
				}
			}
		}
		else
		{
			System.out.println("������Ҫɾ����С����:");
			String smallclassname=input.next();
			smallClass sc=new smallClass();
			sc.setSmallclassname(smallclassname);
			FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
			int result=fa.delSmallClass(sc);
			if(result==1)
				System.out.println(">>>ɾ��С��ɹ�");
			else
				System.out.println(">>>ɾ��С��ʧ��");
		}
	}

	public void showAllAssets()
	{
		System.out.println("��ʾ�����ʲ�>>>");
		List<Asset> assetlist=new ArrayList<Asset>();
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		assetlist=fa.getAsset();
		if(assetlist!=null){
			Iterator it=assetlist.iterator();
			System.out.println("���\t����\t���\t�ͺ�\t��ֵ\t��������\t\t״̬\tʹ����\t��ע");
			while(it.hasNext()){
				Asset asset=(Asset)it.next();
				System.out.println(asset.getId()+"\t"+asset.getName()+"\t"+asset.getType()+"\t"+asset.getModel()+"\t"+asset.getValue()+"\t"+asset.getPurchaseDate()+"\t"+asset.getState()+"\t"+asset.getUserName()+"\t"+asset.getRemark());
			}
			System.out.println(">>>�����ʲ���Ϣ����ʾ���");
		}
	}

	public void addAsset(){
		System.out.println("������ʲ���Ϣ>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("�������ʲ����ƣ�");
		String name=input.next();
		System.out.println("�������ʲ����ͣ�");
		String type=input.next();
		System.out.println("�������ʲ��ͺţ�");
		String model=input.next();
		System.out.println("�������ʲ���ֵ��");
		float value=input.nextFloat();
		System.out.println("�������ʲ��������ڣ�");
		String purchaseDate=input.next();
		System.out.println("�������ʲ�״̬��");
		String state=input.next();
		System.out.println("�������ʲ�ʹ����������");
		String username=input.next();
		System.out.println("�������ʲ���ע��");
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
			System.out.println(">>>���ʲ��Ѵ��ڣ���������ƺ������");
		}
		else{
			int result=fa.addAsset(as);
			if(result==1)
				System.out.println(">>>���ʲ���Ϣ��ӳɹ�");
			else
				System.out.println(">>>���ʲ���Ϣ���ʧ��");
		}
	}

	public void editAsset(){
		System.out.println("�޸��ʲ���Ϣ>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ��ʲ����ƣ�");
		String name=input.next();
		System.out.println("�������µ��ʲ����ͣ�");
		String type=input.next();
		System.out.println("�������µ��ʲ��ͺţ�");
		String model=input.next();
		System.out.println("�������µ��ʲ���ֵ��");
		float value=input.nextFloat();
		System.out.println("�������µ��ʲ��������ڣ�");
		String purchaseDate=input.next();
		System.out.println("�������µ��ʲ�״̬��");
		String state=input.next();
		System.out.println("�������µ��ʲ�ʹ����������");
		String username=input.next();
		System.out.println("�������µ��ʲ���ע��");
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
			System.out.println(">>>�ʲ���Ϣ�޸ĳɹ�");
		else
			System.out.println(">>>�ʲ���Ϣ�޸�ʧ��");
	}

	public void delAsset(){
		System.out.println("ɾ���ʲ�>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫɾ�����ʲ����ƣ�");
		String name=input.next();
		Asset as=new Asset();
		as.setName(name);
		FixedAssetsManageDao fa=new FixedAssetsManageDaoImpl();
		if(fa.findByAssetName(name)!=null){
			int result=fa.delAs(as);
			if(result==1)
				System.out.println(">>>�ʲ�ɾ���ɹ�");
			else
				System.out.println(">>>�ʲ�ɾ��ʧ��");
		}
		else
			System.out.println(">>>δ�ҵ����ʲ���ɾ��ʧ��");
	}
}
