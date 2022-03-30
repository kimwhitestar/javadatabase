package t1_DBConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  public DBConnection() {
    try {
      //1. 드라이버 검색
      //import com.mysql.jdbc.Driver;
      Class.forName("com.mysql.jdbc.Driver");//java api의 class도 찾네요
      System.out.println("드라이버 검색 성공");
      
      //2. 데이터베이스 연결
      DriverManager.getConnection("jdbc:mysql://localhost:3306/javagreen", "root", "1234");
      System.out.println("데이터베이스 연결 성공!!!");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("드라이버 검색 실패~~~");
      System.exit(0);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("데이타베이스 연동 실패~~~");
      System.exit(0);
    }
    System.out.println("작업끝...");
  }
}