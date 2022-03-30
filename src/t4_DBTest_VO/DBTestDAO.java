package t4_DBTest_VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTestDAO {
  Connection conn = null;
  Statement stmt = null;
  ResultSet rs = null;
  String sql = "";

  //처음 DAO생성시에 Database 연결
  public DBTestDAO() {
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
  public void stmtClose() {
    try {
      if (stmt != null) stmt.close();
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
      stmt = conn.createStatement();
      sql = "insert into dbtest"
          + " values"
          + "(default, '"+vo.getName()+"', "+vo.getAge()+", '"+vo.getGender()+"', '"+vo.getJoinday()+"')";
      stmt.executeUpdate(sql);
      System.out.println(vo.getName() + "자료가 등록되었습니다");
    } catch (SQLException e) {
      System.out.println("SQL 오류 : " + e.getMessage());
    } finally {
      stmtClose();
    }
  }
  public ArrayList<DBTestVO> list() {
    ArrayList<DBTestVO> vos = new ArrayList<>();
    try {
      stmt = conn.createStatement();
      sql = "select * from dbtest order by idx desc";
      rs = stmt.executeQuery(sql);
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
    }
    return vos;
  }
}