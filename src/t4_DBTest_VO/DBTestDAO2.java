package t4_DBTest_VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTestDAO2 {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  String sql = "";

  //처음 DAO생성시에 Database 연결
  public DBTestDAO2() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/javagreen";
      String user = "root";
      String password = "1234";
      conn = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 검색 실패");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("데이터베이스 연결 실패");
      e.printStackTrace();
    }
  }
  public void rsClose() {
    try {
      if (rs != null) rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void pstmtClose() {
    try {
      if (pstmt != null) pstmt.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void dbClose() {
    try {
      if (null != conn) conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void input(DBTestVO vo) {
    try {
      sql = "insert into dbtest values(default, ?, ?, ?, ? )";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, vo.getName());
      pstmt.setInt(2, vo.getAge());
      pstmt.setString(3, vo.getGender());
      pstmt.setString(4, vo.getJoinday());
      int result = pstmt.executeUpdate();
      if (1 == result) System.out.println(vo.getName() + "자료가 등록되었습니다");
      else System.out.println(vo.getName() + "자료등록에 실패했습니다");
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      pstmtClose();
    }
  }
  public ArrayList<DBTestVO> list() {
    ArrayList<DBTestVO> vos = new ArrayList<>();
    try {
      sql = "select * from dbtest order by idx desc";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        DBTestVO vo = new DBTestVO();
        vo.setIdx(rs.getInt("idx"));
        vo.setName(rs.getString("name"));
        vo.setAge(rs.getInt("age"));
        vo.setGender(rs.getString("gender"));
        vo.setJoinday(rs.getString("joinday"));
        vos.add(vo);
      }
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      rsClose();
      pstmtClose();
    }
    return vos;
  }
  public ArrayList<DBTestVO> search(DBTestVO pVO) {
    ArrayList<DBTestVO> vos = new ArrayList<>();
    try {
      sql = "select * from dbtest where name = ? order by idx desc";
      pstmt.setString(1, pVO.getName());
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        DBTestVO vo = new DBTestVO();
        vo.setIdx(rs.getInt("idx"));
        vo.setName(rs.getString("name"));
        vo.setAge(rs.getInt("age"));
        vo.setGender(rs.getString("gender"));
        vo.setJoinday(rs.getString("joinday"));
        vos.add(vo);
      }
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      rsClose();
      pstmtClose();
    }
    return vos;
  }
  public void update(DBTestVO vo) {
    try {
      StringBuffer sql = new StringBuffer("");
      sql.append("update dbtest set ");
      if (null != vo.getName()) sql.append(" name = ?,");
      if (0 != vo.getAge()) sql.append(" age = ?,");
      if (null != vo.getGender()) sql.append(" gender = ?,");
      if (null != vo.getJoinday()) sql.append(" joinday = ?");
      if (sql.lastIndexOf(",") == sql.length()-1)
        sql.replace(sql.lastIndexOf(","), sql.length(), "");
      sql.append(" where idx = ?");
      pstmt = conn.prepareStatement(sql.toString());
      pstmt.setString(1, vo.getName());
      pstmt.setInt(2, vo.getAge());
      pstmt.setString(3, vo.getGender());
      pstmt.setString(4, vo.getJoinday());
      pstmt.setInt(5, vo.getIdx());
      int result = pstmt.executeUpdate();
      if (1 == result) System.out.println(vo.getIdx() + "번째 자료가 수정되었습니다");
      else System.out.println(vo.getName() + "자료수정에 실패했습니다");
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      pstmtClose();
    }
  }
  public void delete(DBTestVO vo) {
    try {
      sql = "delete from dbtest where idx = ?";
      pstmt.setInt(1, vo.getIdx());
      pstmt = conn.prepareStatement(sql);
      int result = pstmt.executeUpdate();
      if (1 == result) System.out.println(vo.getIdx() + "번째 자료가 삭제되었습니다");
      else System.out.println(vo.getName() + "자료삭제에 실패했습니다");
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      pstmtClose();
    }
  }
}