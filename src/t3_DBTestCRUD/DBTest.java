package t3_DBTestCRUD;

//import com.mysql.jdbc.Connection;//이거는 가져오면 안됨!!!
//### 어떤 jdbc든 java.sql.Connection로 연결!!!###
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//### 어떤 jdbc든 java.sql.Statement로 가져오기!!!###
import java.sql.Statement;

public class DBTest {
  public Connection conn = null;
  public String sql = "";
  public Statement stmt = null;
  public ResultSet rs = null;
  
  public DBTest() {
    try {
      //1. JDBC Driver 검색
      Class.forName("com.mysql.jdbc.Driver");
      //2. 데이터베이스 연결
      String url = "jdbc:mysql://localhost:3306/javagreen";//jdbc와 'javagreen' database명
      String user = "root";
      String password = "1234";
      conn = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("드라이버 검색 실패~~~");
      System.exit(0);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("데이타베이스 연동 실패~~~");
      System.exit(0);
    }
  }
  
  //전체조회
  public void list() {
    String name = null;
    int age = 0;
    String gender = null;
    String genderName = null;
    String joinday = null;
    
    try {
      stmt = conn.createStatement();
      sql = "select * from aaa order by name";
      rs = stmt.executeQuery(sql);
      
      System.out.println("===============");
      System.out.println("성명\t나이\t성별\t가입일자");
      System.out.println("---------------");
      while(rs.next()) {//ResultSet의 record한줄 읽어서 있으면 boolean리턴
        name = rs.getString("name");
        age = rs.getInt("age");
        gender = rs.getString("gender");//char로 받아도 됨
        joinday = rs.getString("joinday");
        System.out.println(name +"\t"+ age +"\t"+ gender +"\t"+ joinday);
        if (gender == null) genderName = "";
        else if (gender.equals("m")) genderName = "남자";
        else if (gender.equals("f")) genderName = "여자";
      }
      System.out.println("===============");
    } catch (SQLException e) {
      System.out.println("SQL오류" + e.getMessage());
    }
  }
  
  public void searchTest(String pName) {
    try {
      stmt = conn.createStatement(); 
      sql = "select * from aaa where name='" + pName + "'";
      //RecordSet이 ResultSet으로 바꼈다
      rs = stmt.executeQuery(sql);//R검색(###단, 여러검색결과가 있으면 1번째줄만 가져옴###)
      /*### stmt.executeUpdate(sql);//CUD입력수정삭제 ###*/
      if (rs.next()) {
        //System.out.println("홍길동");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");//char로 받아도 됨
        String joinday = rs.getString("joinday");
        
        System.out.println("===============");
        System.out.println("성명 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("성별 : " + gender);
        System.out.println("가입일 : " + joinday);
        System.out.println("===============");
      } else {
        System.out.println(pName + "은 없음");
      }
//      stmt.close();
    } catch (SQLException e) {
      System.out.println("SQL오류" + e.getMessage());
    }
  }
  
  public void input(String name, int age, String gender, String joinday) {
    try {    
      stmt = conn.createStatement();
      sql = "insert into aaa values ('"+name+"', "+age+", '"+gender+"', '"+joinday+"')";
      stmt.executeUpdate(sql);//insert
      System.out.println("자료가 등록되었습니다");
    } catch (SQLException e) {
      System.out.println("SQL오류" + e.getMessage());
    }
  }
  
  public void rsClose() {
    try {
      if (null != rs) {
        rs.close();   
        stmt.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void dbClose() {
    try {
      if (null != conn) conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}