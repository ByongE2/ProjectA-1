package util;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {

    	String DB_URL = "jdbc:mysql://localhost:3306/pojecta?useUnicode=true&characterEncoding=utf8";

        // DB id,password 체크
        String DB_USER = "ByongE";
        String DB_PASSWORD = "1234";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        Statement stmt  = conn.createStatement(); 

        String query = "SELECT now()"; // 현재시간
        ResultSet rs = stmt.executeQuery(query); 

        while (rs.next()) {
            String curDate = rs.getString(1);  
            System.out.println(curDate);      
            //현재시간 뜨면 테스트 성공.
        }
    } // main()
}