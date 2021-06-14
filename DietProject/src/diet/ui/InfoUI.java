package diet.ui;

import java.util.Scanner;
import diet.service.InfoService;
import diet.vo.Info;
import diet.vo.Exer;

public class InfoUI {
	Scanner keyin = new Scanner(System.in);
	InfoService service = new InfoService();
	public InfoUI() {
		String choice = null;
		String choice2 = null;
		String choice3 = null;
		String choice4 = null;
		
		while(true) {
			menu();
			choice = keyin.nextLine();
				switch(choice) {
				case "1":
					System.out.println("a. [[ȸ�� ���� ���� �Է�]]");
					System.out.println("b. [[ȸ�� ��ü ���� �Է�]]");
					System.out.println("c. [[ȸ�� � ���� �Է�]]");
					System.out.println("d. [[ȸ�� � ��� �Է�]]");
					System.out.println("======================");
				    System.out.print("���� ������> ");
				    choice2 = keyin.nextLine();
				    switch(choice2) {
				    case "a":
				    	inputinfo();
				    	break;
				    case "b":
				    	break;
				    case "c":
				    	break;
				    case "d":
				    	inputexer();
				    	break;
				    }
				    break; 

				case "2":
					System.out.println("a. [[ȸ�� ���� ���� ��ȸ]]");
					System.out.println("b. [[ȸ�� ��ü ���� ��ȸ]]");
					System.out.println("c. [[ȸ�� � ���� ��ȸ]]");
					System.out.println("d. [[ȸ�� � ��� ��ȸ]]");
					System.out.println("======================");
				    System.out.print("���� ������> ");
				    choice3 = keyin.nextLine();
				    switch(choice3) {
				    case "a":
				    	selectOne();
				    	break;
				    case "b":
				    	break;
				    case "c":
				    	break;
				    case "d":
				    	break;
				    }
					break;
				case "3":
					System.out.println("a. [[ȸ�� ���� ���� ����]]");
					System.out.println("b. [[ȸ�� ��ü ���� ����]]");
					System.out.println("c. [[ȸ�� � ���� ����]]");
					System.out.println("d. [[ȸ�� � ��� ����]]");
					System.out.println("======================");
				    System.out.print("���� ������> ");
				    choice4 = keyin.nextLine();
				    switch(choice4) {
				    case "a":
				    	update();
				    	break;
				    case "b":
				    	break;
				    case "c":
				    	break;
				    case "d":
				    	break;
				    }
					break;
				case "4":
					deleteOne();
					break;
				case "0":
					System.out.println("**���α׷��� ����ƽ��ϴ�.");
					return;
				default:
					System.out.println("**��ȣ�� �߸� �Է��߽��ϴ�.");
					continue;
				}
			}
		
		}

private void inputexer() {
		System.out.println("[[ȸ�� � ��� �Է�]]");
		System.out.println("==================");
		
		String userid, recomid, recomexer, exerstat, exerdate;

		System.out.print("> ID: ");
		userid = keyin.nextLine();
		
		if(userid == null) {
			System.out.println("** ID ����!");
			return;
		}
		
		System.out.print("> EXCERCISE ID: ");
		recomid = keyin.nextLine();
		
		System.out.print("> EXERCISE: ");
		recomexer = keyin.nextLine();
		
		if(recomexer == null) {
			System.out.println("** � �Ѱ� ����!");
			return;
		}
		
		System.out.print("> EXERCISE STATUS: ");
		exerstat = keyin.nextLine();
		
		if(exerstat.equals("o")  && exerstat.equals("x")) {
			System.out.println("**� ���δ� o/x�θ� �Է� �����մϴ�!");
			return;
		}
		
		System.out.print("> EXERCISE DATE: ");
		exerdate = keyin.nextLine();
		
	}

private void selectOne() {
	System.out.println("\n [[ȸ�� ���� ���� ��ȸ]]");
	System.out.println("=====================");
	
	String userid;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	Info userinfo = service.selectOne(userid);
	
	if(userinfo == null) System.out.println("** NO INFO");
	else System.out.println(userinfo);
		
	}


private void deleteOne() {
	System.out.println("\n [[ȸ�� ���� ����]]");
	System.out.println("=====================");
	
	String userid;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	int result = service.deleteOne(userid);
	
	if(result == 0) System.out.println("** ȸ�� ���� ����");
	else System.out.println("**ȸ�� Ż�� ����");
		
	}


private void update() {
	System.out.println("\n [[ȸ�� ���� ���� ����]]");
	System.out.println("=====================");
	
	String userid, userpwd, userphone, userarea;
	String userbirth;
	
	System.out.print(">ID: ");
	userid = keyin.nextLine();
	
	Info d = service.selectOne(userid);
	
	if(d == null) {
		System.out.println("**���� ����.");
		return;
	}
	
	System.out.print(">CHANGED PW>> ");
	userpwd = keyin.nextLine();
	
	System.out.print("CHANGED PHONE NUMBER>> ");
	userphone = keyin.nextLine();
	
	System.out.print("CHANGED AGE>> ");
	userbirth = keyin.nextLine();
	
	System.out.print("CHANGED AREA>> ");
	userarea = keyin.nextLine();
	
	Info diet = new Info(d.getUser_id(), userpwd, null, userbirth, null, userphone, userarea, null);
	
	int result = service.update(diet);
	
	if(result == 0) {
		System.out.println("**���� ���� ����.");
	}else System.out.println("**���� ���� ����.");
}


private void inputinfo() {
	System.out.println("\n [[ȸ�� ���� ���� �Է�]]");
	System.out.println("=====================");
	
	String userid, userpwd, username, usergender, userphone, userarea, regdate;
	String userbirth=null;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	Info d = service.selectOne(userid);
	
	if(d != null) {
		System.out.println("**�ߺ��� ���̵��Դϴ�!");
		return;
	}
	else System.out.println("** ��� ������ ���̵��Դϴ�.");
	
	System.out.print("> PW: ");
	userpwd = keyin.nextLine();
	if(userpwd == null) {
		System.out.println("**��й�ȣ�� �Է��ϼ���!");
	}
	
	System.out.print("> NAME: ");
	username = keyin.nextLine();
	if(username == null) {
		System.out.println("**�̸��� �Է��ϼ���!");
	}
	
	
	///int�� �ٲ�
	System.out.print("> AGE: ");
	
	try 
	{ 
		userbirth = keyin.nextLine(); 
	} 
	catch(NumberFormatException e) 
	{ 
		e.printStackTrace(); 
	}

	if(userbirth == null) {
		System.out.println("**���̸� �Է��ϼ���!");
	}
	
	System.out.print("> GENDER(��/���θ� �Է��� �ּ���): ");
	usergender = keyin.nextLine();
	if(usergender.equals("��")  && usergender.equals("��")) {
		System.out.println("������ ��/���θ� �Է� �����մϴ�!");
		return;
	}
	//��ȭ��ȣ ������ 010-xxxx-xxxx
	System.out.print("> PHONE NUMBER: ");
	userphone = keyin.nextLine();
	if((userphone.length() != 13)) {//Early Stopping
		System.out.println("�߸��� ��ȭ��ȣ");
		return;
	}
	
	if((userphone.charAt(3) != '-')) {
		System.out.println("�߸��� ��ȭ��ȣ");
		return;
	}
	
	if(userphone.charAt(8) != '-') {
		System.out.println("�߸��� ��ȭ��ȣ");
		return;
	}
	
	System.out.print("> ADDRESS: ");
	userarea = keyin.nextLine();
	
	System.out.print("> REGISTER DATE: ");
	regdate = keyin.nextLine();
	
	int result = service.insertDiet(new Info(userid, userpwd, username, userbirth, usergender, userphone, userarea, regdate));
	System.out.println(result);
}


public void menu() {
	 System.out.println("\n [[ȸ�� ��ü���� ����]]");
     System.out.println("=================");
     System.out.println("1. ȸ�� ���� �Է�");
     System.out.println("2. ȸ�� ���� ��ȸ");
     System.out.println("3. ȸ�� ���� ����");
     System.out.println("4. ȸ�� ���� ����");
     System.out.println("0. ��                 ��");   
     System.out.println("=======================");
     System.out.print("���� ������> ");

	}
}