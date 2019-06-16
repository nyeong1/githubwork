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
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반 2.대학 3.회사" );
		System.out.print("선택 >> ");
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
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	// 1번 입력
	public void inputInfo() {
		
		String name, phone;
		
		System.out.print("이름 : ");
		name=scanner.next(); 
		System.out.print("전화번호 : ");
		phone=scanner.next();
		
		
		book[currentData]=new PhoneInfo(name, phone);
		currentData++;
	}
	
	// 대학 입력
	public void inputColleage() {
		
		String name, number, major;
		int grade;

		System.out.print("이름 : ");
		name=scanner.next();
		System.out.print("전화번호 : ");
		number=scanner.next();
		System.out.print("전공 : ");
		major=scanner.next();
		System.out.print("학년 : ");
		grade=scanner.nextInt();
		
		book[currentData]=new PhoneColleage(name, number, major, grade);
		currentData++;
		
	}
	
	// 회사 입력
	public void inputCompany() {
		
		String name, number, company;

		System.out.print("이름 : ");
		name=scanner.next();
		System.out.print("전화번호 : ");
		number=scanner.next();
		System.out.print("회사 : ");
		company=scanner.next();
		
		book[currentData]=new PhoneCompany(name, number, company);
		currentData++;
	}
	
	// 데이터를 검색하는 메쏘드
	public void searchData() {
		
		int result=search();
		
		if(result==-10) {
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
			return;
			
		}else {
			book[result].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다.");
		}
	}
	
	public int search() {
		
		System.out.println("데이터 검색을 시작합니다...");
		System.out.print("이름 : ");
		String name=scanner.next();
		
		for(int i=0;i<currentData;i++) {
			
			if(book[i].name.equals(name)) {
				return i;
			}
		}
		
		return -10;
	}
	
	// 데이터를 삭제하는 메쏘드
	public void deleteData() {
		
		int deletion=search();
		
		System.out.println("=====삭제할 데이터=====");
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 : ");
		
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
