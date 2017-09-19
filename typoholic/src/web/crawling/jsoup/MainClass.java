package web.crawling.jsoup;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;

import web.crawling.vo.Ridibook;

public class MainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//		Crawling ctrl = new Crawling();
//
//		List<Ridibook> list = ctrl.getRidibookFantasyList(1);
		
		// 1. Driver를 로딩한다. 
		   Class.forName("com.mysql.jdbc.Driver"); 
		   System.out.println("OracleDriver의 로딩이 정상적으로 이뤄졌습니다."); 
		   
		   Connection conn;
		   PreparedStatement psmt;
		   // 2. Connection 얻어오기 
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crawling?useUnicode=true&amp;characterEncoding=UTF-8&amp;characterSetResults=UTF-8&amp;jdbcCompliantTruncation=false&amp;useOldUTF8Behavior=true", 
				   "admin", 
				   "secret"); 
		   System.out.println("데이터베이스의 연결에 성공하였습니다."); 
		    
		   String sql = "INSERT INTO RIDIBOOKS(category, link, cover, title, author, star, starredPerson)\r\n" + 
		   		"		VALUES('판타지', '야', '3', '안녕', '하세요', 1, 2)";
		   
		   // 3. Statement 얻기 --> 쿼리문 작성하여 적용하기 위한 용도 
		   psmt = conn.prepareStatement(sql);
		   psmt.executeUpdate();
		   
		   psmt.close(); 
		   conn.close(); 

	}

}
