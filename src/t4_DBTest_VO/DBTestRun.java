package t4_DBTest_VO;

import java.util.Scanner;

public class DBTestRun {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    DBTestService service = new DBTestService();
    
    int sel;//작업선택 메뉴
    boolean run = true;
    while (run) {
      System.out.println("*** 작업선택 ***");
      System.out.println("1.자료입력 2.개별조회 3.전체조회 4.수정 5.삭제 6.종료");
      sel = scanner.nextInt();
      
      switch (sel) {
        case 1:
          service.input();
          break;
        //개별조회
        case 2:
          service.search();
          break;
        //전체조회
        case 3:
          service.list();
          break;
        case 4:
          service.update();
          break;
        case 5:
          service.delete();
          break;
        //종료
        default:
          run = false;
          break;
      }
    }
    System.out.println("==================");
    System.out.println("작업 끝...");
    System.out.println("==================");
    
    scanner.close();
  }
}
