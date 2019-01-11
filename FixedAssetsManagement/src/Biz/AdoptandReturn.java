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
 * �ʲ�������黹��
 * @author ������
 * 2016-7-15
 */
public class AdoptandReturn {
	public void adopt(String name){
		System.out.println("�ʲ�����>>>");
		System.out.println("������������Ա������");
		Scanner input=new Scanner(System.in);
		String adoptName=input.next();
		AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
		if(ARDao.isRegister(adoptName)){
			System.out.println("������Ҫ���õ��ʲ��豸��ţ�");
			int id=input.nextInt();
			ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
			Asset asset=RAIDao.searchID(id);
			String state=asset.getState();
			String userName=asset.getUserName();
			if(state.equals("����")&&userName==null){
				System.out.println("�������������ڣ�");
				String date=input.next();
				System.out.println("��������;��");
				String purpose=input.next();
				System.out.println("�����뱸ע��");
				String remark=input.next();
				int result1=ARDao.add(id, date, name, purpose, remark);
				int result2=ARDao.update(id, adoptName);
				System.out.println(">>>���óɹ�");
			}
			else if(state.equals("����")&&userName!=null)
				System.out.println(">>>���豸�Ѿ���"+userName+"���ã�����豸�黹����������");
			else if(state.equals("ά��")&&userName==null)
				System.out.println(">>>���豸����ά�ޣ�����豸�ָ�����������");
			else
				System.out.println(">>>���豸�Ѿ����ϣ����ܱ�����");
		}
		else
			System.out.println(">>>����Ա��δ�Ǽǣ�������ɵǼ�");
	}
	public void Return(String name){
		System.out.println("�ʲ��黹>>>");
		Scanner input=new Scanner(System.in);
		System.out.println("������Ҫ�黹���ʲ��豸��ţ�");
		int id=input.nextInt();
		ReviewAssetsInfoDao RAIDao=new ReviewAssetsInfoDaoImpl();
		Asset asset=RAIDao.searchID(id);
		String state=asset.getState();
		String userName=asset.getUserName();
		if(state.equals("����")&&userName!=null){
			System.out.println("������黹���ڣ�");
			String date=input.next();
			AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
			int result1=ARDao.updateadd(id, date, name);
			int result2=ARDao.updatedel(id);
			System.out.println(">>>�黹�ɹ�");
		}
		else if(state.equals("����")&&userName==null)
			System.out.println(">>>���豸��δ�����ã����ܹ黹");
		else if(state.equals("ά��")&&userName==null)
			System.out.println(">>>���豸����ά�ޣ����ܹ黹");
		else
			System.out.println(">>>���豸�Ѿ����ϣ����ܹ黹");
	}
	public void showAdoptReturn(){
		System.out.println("��ӡ�����ʲ������ù黹��Ϣ>>>");
		List<AdoptandReturnInfo> AaRIs=new ArrayList();
		AdoptandReturnDao ARDao=new AdoptandReturnDaoImpl();
		AaRIs=ARDao.showAllAdoptReturn();
		System.out.println("�豸���\t��������\t\t���ò�������Ա\t��;\t��ע\t�黹����\t\t�黹��������Ա");
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
			System.out.println(">>>�����ʲ������ù黹��Ϣ�Ѵ�ӡ���");
		}
	}
}
