/*
 * (숙제 1) Service, DAO, VO객체를 사용해서 
 * Statement문장으로 database query를 실행하여 
 * 입력받은 자료를 입력,조회,수정,삭제 처리
 * 실행환경: eclipse에 mysql database, github연결된 상태에서 
 * git repository에 class와 sql화일을 commit반영 확인
 */
package t4_DBTest_VO;

import java.util.Scanner;

public class DBTestRun {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DBTestService service = new DBTestService();
    DBTestVO searchVO = null;
    DBTestVO vo = null;
    
    int sel;//작업선택 메뉴
    boolean run = true;
    String yn = null;
    while (run) {
      System.out.println("*** 작업선택 ***");
      System.out.println("1.자료입력 2.개별조회 3.전체조회 4.수정 5.삭제 6.종료");
      System.out.print("선택>");
      sel = sc.nextInt();
      
      switch (sel) {
        case 1:
          vo = new DBTestVO();
          System.out.print("성명 : ");
          vo.setName(sc.next());
          System.out.print("나이 : ");
          vo.setAge(sc.nextInt());
          System.out.print("성별 : ");
          vo.setGender(sc.next());
          System.out.print("입사일(예:2022-01-31) : ");
          vo.setJoinday(sc.next());
          service.input(vo);
          break;
        //개별조회
        case 2:
          searchVO = new DBTestVO();
          System.out.print("조회할 사람 이름 : ");
          searchVO.setName(sc.next());
          service.search(searchVO);
          break;
        //전체조회
        case 3:
          service.list();
          break;
        case 4:
          searchVO = new DBTestVO();
          System.out.print("수정할 사람 이름 : ");
          searchVO.setName(sc.next());
          service.search(searchVO);
          vo = new DBTestVO();
          System.out.print("수정할 사람의 번호 : ");
          vo.setIdx(sc.nextInt());
          int itemNo;
          while(true) {
            System.out.println("==>> 수정할 항목을 선택하세요");
            System.out.println("1.나이 2.성별 3.가입일 4.종료");
            System.out.print("항목 선택>");
            itemNo = sc.nextInt();
            if (1 == itemNo) {
              System.out.print("나이 : ");
              vo.setAge(sc.nextInt());
              continue;
            } else if (2 == itemNo) {
              System.out.print("성별 : ");
              vo.setGender(sc.next());
              continue;
            } else if (3 == itemNo) {
              System.out.print("가입일(예:2022-01-31) : ");
              vo.setJoinday(sc.next());
              continue;
            } else {
              break;
            }
          }          
          System.out.print("수정할까요?(y/n)");
          yn = sc.next();
          if (yn.equalsIgnoreCase("y")) {
            service.update(vo);
          }
          break;
        case 5:
          searchVO = new DBTestVO();
          System.out.print("삭제할 사람 이름 : ");
          searchVO.setName(sc.next());
          service.search(searchVO);
          vo = new DBTestVO();
          System.out.print("삭제할 사람의 번호 : ");
          vo.setIdx(sc.nextInt());
          System.out.print("삭제할까요?(y/n)");
          yn = sc.next();
          if (yn.equalsIgnoreCase("y")) {
            service.delete(vo);
          }
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
    
    sc.close();
  }
}
