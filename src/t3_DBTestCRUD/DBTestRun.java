package t3_DBTestCRUD;

import java.util.Scanner;

public class DBTestRun {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = null;
    int age = 0;
    String gender = null;
    String joinday = null;
    
    //DB연동 후 작업
    DBTest dbTest = new DBTest();
    System.out.println("DB 처리 작업중입니다...");
    
    //메뉴작업
    int sel = 6;
    while(true) {
      System.out.println("___작업선택___");
      System.out.println("1. 자료입력 2.개별조회 3.전체조회 4.수정 5.삭제");
      System.out.print("번호>");
      sel = scanner.nextInt();
      System.out.println();
      
      if (sel < 1 || sel > 5) break;
      switch(sel) {
        //자료입력
        case 1:
          System.out.print("이름 입력 : ");
          name = scanner.next();
          System.out.print("나이 입력 : ");
          age = scanner.nextInt();
          System.out.print("성별 입력(1.남자, 2.여자) : ");
          gender = scanner.next();
          System.out.print("입사일 입력(yyyy-mm-dd) : ");
          joinday = scanner.next();
          
          if (gender.equals("1")) gender = "m";
          else gender = "f";//default
          
          dbTest.input(name, age, gender, joinday);
          break;
        //개별조회
        case 2:
          while(true) {
            System.out.print("검색할 이름 입력 : ");
            name = scanner.next();
            dbTest.searchTest(name);//DB검색(개별검색)
            System.out.print("계속할까요?(y/n) ");
            String ans = scanner.next();
            if (!ans.toUpperCase().equals("Y")) break;
          }
        //전체조회
        case 3:
          while(true) {
            dbTest.list();//DB검색(전체검색)
            System.out.print("계속할까요?(y/n) ");
            String ans = scanner.next();
            if (!ans.toUpperCase().equals("Y")) break;
          }
        //수정
        case 4:
          break;
        //삭제
        case 5:
          break;
        default:
          break;
      }
    }
    
    //DB Close처리
    dbTest.rsClose();
    dbTest.dbClose();
    System.out.println("DB 처리 작업끝입니다...");
    scanner.close();
  }

}
