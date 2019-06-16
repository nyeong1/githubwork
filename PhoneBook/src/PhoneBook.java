import java.util.Scanner;

class PhoneInfo{
	
	public String name;
	public String number;
	
	PhoneInfo(String name, String number) {
		this.name=name;
		this.number=number;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : "+this.name);
		System.out.println("phone : "+this.number);
	}
}

class PhoneColleage extends PhoneInfo{

	public String major;
	public int grade;
	
	PhoneColleage(String name, String number, String major, int grade) {
		super(name, number);
		this.major=major;
		this.grade=grade;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : "+this.name);
		System.out.println("phone : "+this.number);
		System.out.println("major : "+this.major);
		System.out.println("grade : "+this.grade);
	}
}

class PhoneCompany extends PhoneInfo{
	
	public String company;
	
	PhoneCompany(String name, String number, String company){
		super(name, number);
		this.company=company;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : "+this.name);
		System.out.println("phone : "+this.number);
		System.out.println("company : "+this.company);
	}
}

class PhoneBookManager{
	
	Scanner scanner=new Scanner(System.in);
	PhoneInfo[] book=new PhoneInfo[10];
	int currentData=0;
	private PhoneInfo PhoneInfo;
	
	public void typeInfo() {
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.println("1.�Ϲ� 2.���� 3.ȸ��" );
		System.out.print("���� >> ");
		int type=scanner.nextInt();
		
		switch(type) {
		case 1:
			inputInfo();
			break;
		case 2:
			inputColleage();
			break;
		case 3:
			inputCompany();
			break;
		}
		
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.");
	}
	
	// 1�� �Է�
	public void inputInfo() {
		
		String name, phone;
		
		System.out.print("�̸� : ");
		name=scanner.next(); 
		System.out.print("��ȭ��ȣ : ");
		phone=scanner.next();
		
		
		book[currentData]=new PhoneInfo(name, phone);
		currentData++;
	}
	
	// ���� �Է�
	public void inputColleage() {
		
		String name, number, major;
		int grade;

		System.out.print("�̸� : ");
		name=scanner.next();
		System.out.print("��ȭ��ȣ : ");
		number=scanner.next();
		System.out.print("���� : ");
		major=scanner.next();
		System.out.print("�г� : ");
		grade=scanner.nextInt();
		
		book[currentData]=new PhoneColleage(name, number, major, grade);
		currentData++;
		
	}
	
	// ȸ�� �Է�
	public void inputCompany() {
		
		String name, number, company;

		System.out.print("�̸� : ");
		name=scanner.next();
		System.out.print("��ȭ��ȣ : ");
		number=scanner.next();
		System.out.print("ȸ�� : ");
		company=scanner.next();
		
		book[currentData]=new PhoneCompany(name, number, company);
		currentData++;
	}
	
	// �����͸� �˻��ϴ� �޽��
	public void searchData() {
		
		int result=search();
		
		if(result==-10) {
			System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.");
			return;
			
		}else {
			book[result].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	public int search() {
		
		System.out.println("������ �˻��� �����մϴ�...");
		System.out.print("�̸� : ");
		String name=scanner.next();
		
		for(int i=0;i<currentData;i++) {
			
			if(book[i].name.equals(name)) {
				return i;
			}
		}
		
		return -10;
	}
	
	// �����͸� �����ϴ� �޽��
	public void deleteData() {
		
		int deletion=search();
		
		System.out.println("=====������ ������=====");
		book[deletion].showPhoneInfo();
		
		for(int i=deletion+1;i<currentData;i++) {
			
			i=i-1;
			
		}
		currentData--;
	}
	
	public void showAllData() {
		
		System.out.println("\n======All Record======");
		
		for(int i=0;i<currentData;i++) {
			book[i].showPhoneInfo();
		}
	}
	
}

class MenuViewer{
	
	public static void print() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("���� : ");
		
	}
	
}

public class PhoneBook {
	
	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		PhoneBookManager manager=new PhoneBookManager();
	
		int choice=0;
		
		do {
			MenuViewer.print();
			choice=keyboard.nextInt();
			
			switch(choice) {
			case 1:
				manager.typeInfo();
				break;
			case 2:
				manager.searchData();
				break;
			case 3:
				manager.deleteData();
				break;
			}
		manager.showAllData();
		
		}while(choice!=4);
		
	}

}
