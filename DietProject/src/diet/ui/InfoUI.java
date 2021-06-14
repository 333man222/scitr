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
					System.out.println("a. [[회원 개인 정보 입력]]");
					System.out.println("b. [[회원 신체 정보 입력]]");
					System.out.println("c. [[회원 운동 정보 입력]]");
					System.out.println("d. [[회원 운동 기록 입력]]");
					System.out.println("======================");
				    System.out.print("절대 선택해> ");
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
					System.out.println("a. [[회원 개인 정보 조회]]");
					System.out.println("b. [[회원 신체 정보 조회]]");
					System.out.println("c. [[회원 운동 정보 조회]]");
					System.out.println("d. [[회원 운동 기록 조회]]");
					System.out.println("======================");
				    System.out.print("절대 선택해> ");
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
					System.out.println("a. [[회원 개인 정보 수정]]");
					System.out.println("b. [[회원 신체 정보 수정]]");
					System.out.println("c. [[회원 운동 정보 수정]]");
					System.out.println("d. [[회원 운동 기록 수정]]");
					System.out.println("======================");
				    System.out.print("절대 선택해> ");
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
					System.out.println("**프로그램이 종료됐습니다.");
					return;
				default:
					System.out.println("**번호를 잘못 입력했습니다.");
					continue;
				}
			}
		
		}

private void inputexer() {
		System.out.println("[[회원 운동 기록 입력]]");
		System.out.println("==================");
		
		String userid, recomid, recomexer, exerstat, exerdate;

		System.out.print("> ID: ");
		userid = keyin.nextLine();
		
		if(userid == null) {
			System.out.println("** ID 없음!");
			return;
		}
		
		System.out.print("> EXCERCISE ID: ");
		recomid = keyin.nextLine();
		
		System.out.print("> EXERCISE: ");
		recomexer = keyin.nextLine();
		
		if(recomexer == null) {
			System.out.println("** 운동 한거 내놔!");
			return;
		}
		
		System.out.print("> EXERCISE STATUS: ");
		exerstat = keyin.nextLine();
		
		if(exerstat.equals("o")  && exerstat.equals("x")) {
			System.out.println("**운동 여부는 o/x로만 입력 가능합니다!");
			return;
		}
		
		System.out.print("> EXERCISE DATE: ");
		exerdate = keyin.nextLine();
		
	}

private void selectOne() {
	System.out.println("\n [[회원 개인 정보 조회]]");
	System.out.println("=====================");
	
	String userid;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	Info userinfo = service.selectOne(userid);
	
	if(userinfo == null) System.out.println("** NO INFO");
	else System.out.println(userinfo);
		
	}


private void deleteOne() {
	System.out.println("\n [[회원 정보 삭제]]");
	System.out.println("=====================");
	
	String userid;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	int result = service.deleteOne(userid);
	
	if(result == 0) System.out.println("** 회원 정보 없음");
	else System.out.println("**회원 탈퇴 성공");
		
	}


private void update() {
	System.out.println("\n [[회원 개인 정보 수정]]");
	System.out.println("=====================");
	
	String userid, userpwd, userphone, userarea;
	String userbirth;
	
	System.out.print(">ID: ");
	userid = keyin.nextLine();
	
	Info d = service.selectOne(userid);
	
	if(d == null) {
		System.out.println("**정보 없음.");
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
		System.out.println("**정보 수정 실패.");
	}else System.out.println("**정보 수정 성공.");
}


private void inputinfo() {
	System.out.println("\n [[회원 개인 정보 입력]]");
	System.out.println("=====================");
	
	String userid, userpwd, username, usergender, userphone, userarea, regdate;
	String userbirth=null;
	
	System.out.print("> ID: ");
	userid = keyin.nextLine();
	
	Info d = service.selectOne(userid);
	
	if(d != null) {
		System.out.println("**중복된 아이디입니다!");
		return;
	}
	else System.out.println("** 사용 가능한 아이디입니다.");
	
	System.out.print("> PW: ");
	userpwd = keyin.nextLine();
	if(userpwd == null) {
		System.out.println("**비밀번호를 입력하세요!");
	}
	
	System.out.print("> NAME: ");
	username = keyin.nextLine();
	if(username == null) {
		System.out.println("**이름을 입력하세요!");
	}
	
	
	///int로 바꿔
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
		System.out.println("**나이를 입력하세요!");
	}
	
	System.out.print("> GENDER(남/여로만 입력해 주세요): ");
	usergender = keyin.nextLine();
	if(usergender.equals("남")  && usergender.equals("여")) {
		System.out.println("성별은 남/여로만 입력 가능합니다!");
		return;
	}
	//전화번호 형식은 010-xxxx-xxxx
	System.out.print("> PHONE NUMBER: ");
	userphone = keyin.nextLine();
	if((userphone.length() != 13)) {//Early Stopping
		System.out.println("잘못된 전화번호");
		return;
	}
	
	if((userphone.charAt(3) != '-')) {
		System.out.println("잘못된 전화번호");
		return;
	}
	
	if(userphone.charAt(8) != '-') {
		System.out.println("잘못된 전화번호");
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
	 System.out.println("\n [[회원 신체정보 관리]]");
     System.out.println("=================");
     System.out.println("1. 회원 정보 입력");
     System.out.println("2. 회원 정보 조회");
     System.out.println("3. 회원 정보 수정");
     System.out.println("4. 회원 정보 삭제");
     System.out.println("0. 종                 료");   
     System.out.println("=======================");
     System.out.print("절대 선택해> ");

	}
}