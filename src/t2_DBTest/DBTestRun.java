package t2_DBTest;

import java.util.Scanner;

public class DBTestRun {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    //DB연동 후 작업
    DBTest dbTest = new DBTest();
    System.out.println("DB 처리 작업중입니다...");
    
    //DB검색(이름으로 검색)
    System.out.print("검색할 이름 입력 : ");
    String name = scanner.next();
    dbTest.searchTest(name);//DB검색
    
    //DB Close처리
    dbTest.dbClose();
    System.out.println("DB 처리 작업끝입니다...");
    scanner.close();
  }

}
