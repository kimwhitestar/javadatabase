package t3_DBTestCRUD;

import java.util.Scanner;

public class DBTestRun {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = null;
    int age = 0;
    String gender = null;
    String joinday = null;
    int res = 0, itemNo = 0;
    
    //DB연동 후 작업
    DBTest dbTest = new DBTest();
    System.out.println("DB 처리 작업중입니다...");
    
    //메뉴작업
    int sel = 6;
    while(true) {
      System.out.println("___작업선택___");
      System.out.println("1. 자료입력 2.개별조회 3.전체조회 4.수정 5.삭제 6.종료");
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
            dbTest.searchTest(name, "s");//DB검색(개별검색)
            System.out.print("계속할까요?(y/n) ");
            String ans = scanner.next();
            if (!ans.toUpperCase().equals("Y")) break;
          }
          break;
        //전체조회
        case 3:
          while(true) {
            dbTest.list();//DB검색(전체검색)
            System.out.print("계속할까요?(y/n) ");
            String ans = scanner.next();
            if (!ans.toUpperCase().equals("Y")) break;
          }
          break;
        //수정
        case 4:
          System.out.print("검색할 이름 입력 : ");
          name = scanner.next();
          System.out.println();
          res = dbTest.searchTest(name, "u");//개별조회
          if (1 == res) {//찾는 자료 검색되어 수정
            while(true) {
              System.out.println("==>> 수정할 항목을 선택하세요");
              System.out.println("1.나이 2.성별 3.가입일 4.종료");
              System.out.print("항목 선택>");
              itemNo = scanner.nextInt();
              System.out.println();
              
              if (1 == itemNo) {
                System.out.print("나이 : ");
                age = scanner.nextInt();
                dbTest.update(itemNo, name, age);
              } else if (2 == itemNo) {
                System.out.print("성별 : ");
                gender = scanner.next();
                dbTest.update(itemNo, name,  gender);
              } else if (3 == itemNo) {
                System.out.print("가입일 : ");
                joinday = scanner.next();
                dbTest.update(itemNo, name,  joinday);
              } else {
                break;
              }
            }
          }
          break;
        //삭제
        case 5:
          System.out.print("검색할 이름 입력 : ");
          name = scanner.next();
          System.out.println();
          res = dbTest.searchTest(name, "d");//개별조회
          if (1 == res) {//찾는 자료 검색되어 수정
            while(true) {
              System.out.print("삭제할까요(y,n) : ");
              String ans = scanner.next();
              System.out.println();
              if (ans.toUpperCase().equals("Y")) dbTest.delete(name);
              break;
            }
          }
          break;
        default:
          break;
      }
    }
    
    //DB Close처리
    dbTest.dbClose();
    System.out.println("DB 처리 작업끝입니다...");
    scanner.close();
  }

}
