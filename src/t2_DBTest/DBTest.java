package t2_DBTest;

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
  
  public void searchTest(String pName) {
    try {
      Statement stmt = conn.createStatement(); 
      sql = "select * from aaa where name='" + pName + "'";
      //RecordSet이 ResultSet으로 바꼈다
      ResultSet rs = stmt.executeQuery(sql);//R검색(###단, 여러검색결과가 있으면 1번째줄만 가져옴###)
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
      
    } catch (SQLException e) {
      System.out.println("SQL오류" + e.getMessage());
    }
  }
}