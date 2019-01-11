package MainMenu;
import java.util.Scanner;

import Biz.EditPassword;
import Biz.FixedAssetsManage;
import Biz.PersonInfoManage;
import Biz.AdoptandReturn;
import Biz.ReviewAssetsInfo;
import Biz.LoginandRegister;
/**
 * ����ϵͳ��ܣ����������˵�
 * @author ����
 * 2016-7-13
 */
public class Menu {
	private String name;
	public void firstMenu()
	{
		int choice;
		do{
			//��¼����
			System.out.println("***********��¼����***********");
			System.out.println("\t1. ע���û�");
			System.out.println("\t2. ��¼");
			System.out.println("\t3. �˳�");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			LoginandRegister lr=new LoginandRegister();
			choice=input.nextInt();
			switch(choice){
			case 1:
				//ע���û�
				lr.register();
				break;
			case 2:
				//��¼
				if((this.name=lr.login())!=null)
				{
					mainMenu();
				}
				else
					break;
			case 3:
				//�˳�ϵͳ
				System.out.println("***********�ɹ��˳�ϵͳ***********");
				System.exit(0);
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(choice!=3);
	}

	public void mainMenu()//�����˵�
	{
		int choice;
		do{
			//������
			System.out.println("***********ϵͳ������***********");
			System.out.println("\t1. �޸�����");
			System.out.println("\t2. �̶��ʲ�����");
			System.out.println("\t3. ��Ա��Ϣ����");
			System.out.println("\t4. �ʲ�������黹");
			System.out.println("\t5. �ʲ���Ϣ�����ѯ");
			System.out.println("\t6. �˳�ϵͳ");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			choice=input.nextInt();
			switch(choice){
			case 1:
				//�����޸��������
				passwordMenu();
				break;
			case 2:
				//����̶��ʲ��������
				FixedAssetsMenu();
				break;
			case 3:
				//������Ա��Ϣ�������
				personinfoMenu();
				break;
			case 4:
				//�����ʲ�������黹�������
				adoptandreturnMenu();
				break;
			case 5:
				//�����ʲ���Ϣ�����ѯ�������
				reviewassetsMenu();
				break;
			case 6:
				//�˳�ϵͳ
				System.out.println("***********�ɹ��˳�ϵͳ***********");
				System.exit(0);
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(choice!=6);
	}

	public void passwordMenu()
	{
		boolean flag=true;
		//�޸��������
		do{
			System.out.println("****�޸��������****");
			System.out.println("1. �޸�����");
			System.out.println("2. ������һ��");
			EditPassword ep=new EditPassword();
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�����޸��������
				ep.edit(this.name);
				mainMenu();
				break;
			case 2:
				//����������
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void FixedAssetsMenu()
	{
		boolean flag=true;
		do{
			//�̶��ʲ��������
			System.out.println("****�̶��ʲ��������****");		
			System.out.println("1. �̶��ʲ�������");
			System.out.println("2. �̶��ʲ���Ϣ����");
			System.out.println("3. ������һ��");
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//�̶��ʲ�������
				typeMenu();
				break;
			case 2:
				//�̶��ʲ���Ϣ����
				infoMenu();
				break;
			case 3:
				//���ع̶��ʲ��������
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void typeMenu()
	{
		boolean flag=true;
		do{
			//�̶��ʲ����������
			System.out.println("****�̶��ʲ����������****");		
			System.out.println("1. ��ʾ�������");
			System.out.println("2. �������");
			System.out.println("3. ɾ�����");
			System.out.println("4. ������һ��");
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//��ʾ�������
				fa.showAlltype();
				break;
			case 2:
				//�������(���Ǵ���С��д���ģ�)
				fa.addType();
				break;
			case 3:
				//ɾ�����(���Ǵ���С��д���ģ�)
				fa.delType();
				break;
			case 4:
				//������һ��
				flag=false;
				FixedAssetsMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void infoMenu()
	{
		boolean flag=true;
		do{
			//�̶��ʲ���Ϣ�������
			System.out.println("****�̶��ʲ���Ϣ�������****");		
			System.out.println("1. ��ʾ�����ʲ�");
			System.out.println("2. �����ʲ�");
			System.out.println("3. �޸��ʲ�");
			System.out.println("4. ɾ���ʲ�");
			System.out.println("5. ������һ��");
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//��ʾ�����ʲ�
				fa.showAllAssets();
				break;
			case 2:
				//�����ʲ�
				fa.addAsset();
				break;
			case 3:
				//�޸��ʲ�
				fa.editAsset();
				break;
			case 4:
				//ɾ���ʲ�
				fa.delAsset();
				break;
			case 5:
				//������һ��
				flag=false;
				FixedAssetsMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void personinfoMenu()
	{
		boolean flag=true;
		do{
			//��Ա��Ϣ�������
			System.out.println("****��Ա��Ϣ�������****");		
			System.out.println("1. ��ʾ������Ա");
			System.out.println("2. ������Ա");
			System.out.println("3. ɾ����Ա");
			System.out.println("4. �޸���Ա");
			System.out.println("5. ������һ��");
			PersonInfoManage pf=new PersonInfoManage();
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//��ʾ������Ա
				pf.showAll();
				break;
			case 2:
				//������Ա
				pf.add();
				break;
			case 3:
				//ɾ����Ա
				pf.del();
				break;
			case 4:
				//�޸���Ա
				pf.edit();
				break;
			case 5:
				//������һ��
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void adoptandreturnMenu(){
		boolean flag=true;
		do{
			//�ʲ�������黹����
			System.out.println("****�ʲ�������黹����****");		
			System.out.println("1. ��ʾ�����ʲ�");
			System.out.println("2. �����ʲ�");
			System.out.println("3. �黹�ʲ�");
			System.out.println("4. ��ʾ�����ʲ������ù黹��Ϣ");
			System.out.println("5. ������һ��");
			AdoptandReturn ar=new AdoptandReturn();
			FixedAssetsManage fa=new FixedAssetsManage();
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//��ʾ�����ʲ�
				fa.showAllAssets();
				break;
			case 2:
				//�����ʲ�
				ar.adopt(this.name);
				break;
			case 3:
				//�黹�ʲ�
				ar.Return(this.name);
				break;
			case 4:
				//��ʾ�����ʲ������ù黹��Ϣ
				ar.showAdoptReturn();
				break;
			case 5:
				//������һ��
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}

	public void reviewassetsMenu()
	{
		boolean flag=true;
		do{
			//�ʲ���Ϣ�����ѯ����
			System.out.println("****�ʲ���Ϣ�����ѯ����****");		
			System.out.println("1. ��������");
			System.out.println("2. ���ʲ���Ų�ѯ");
			System.out.println("3. ��С���ѯ");
			System.out.println("4. ��ʹ���߲�ѯ");
			System.out.println("5. ������һ��");
			ReviewAssetsInfo ra=new ReviewAssetsInfo();
			System.out.print("��ѡ������:");
			Scanner input=new Scanner(System.in);
			int choice=input.nextInt();
			switch(choice){
			case 1:
				//��������
				ra.reviewType();
				break;
			case 2:
				//���ʲ�������
				ra.searchID();
				break;
			case 3:
				//��С�����
				ra.searchType();
				break;
			case 4:
				//��ʹ�������
				ra.searchUser();
				break;
			case 5:
				//������һ��
				flag=false;
				mainMenu();
				break;
			default:
				//������Ч
				System.out.println("������Ч!");
			}
		}while(flag);	
	}
}
