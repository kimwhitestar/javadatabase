package t4_DBTest_VO;

import java.util.ArrayList;

public class DBTestService {
  DBTestDAO dao = new DBTestDAO();
  DBTestVO vo = null;
  
  //자료 등록
  public void input(DBTestVO vo) {
    dao.input(vo);
  }
  //개별 자료 검색
  public void search(DBTestVO pVO) {
    ArrayList<DBTestVO> vos = dao.search(pVO);

    System.out.println("===============");
    System.out.println("번호\t성명\t나이\t성별\t가입일자");
    System.out.println("---------------");
    for (int i=0; i<vos.size(); i++) {
      vo = vos.get(i);
      System.out.println(vo.getIdx() + "\t" + vo.getName() + "\t" + vo.getAge() + "\t" + vo.getGender() + "\t" + vo.getJoinday());
    }
    System.out.println("===============");
  }
  //전체 자료 검색
  public void list() {
    ArrayList<DBTestVO> vos = dao.list();
    
    System.out.println("===============");
    System.out.println("번호\t성명\t나이\t성별\t가입일자");
    System.out.println("---------------");
    for (int i=0; i<vos.size(); i++) {
      vo = vos.get(i);
      System.out.println(vo.getIdx() + "\t" + vo.getName() + "\t" + vo.getAge() + "\t" + vo.getGender() + "\t" + vo.getJoinday());
    }
    System.out.println("===============");
  }
  //자료 수정
  public void update(DBTestVO vo) {
    dao.update(vo);
  }
  //자료 삭제
  public void delete(DBTestVO vo) {
    dao.delete(vo);
  }
}
