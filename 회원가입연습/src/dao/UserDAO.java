package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entity.UserEntity;

public class UserDAO {
	

	public void insert(UserEntity entity) {
		
		//JDBC 코드 (Java를 이용한 Database처리코드)
		// 1. Database를 이용하기 위해서 필요한 기본 Driver 클래스를 로딩
		// 2. 사용하는 Database종류에 따라서 작성하는 코드가 달라져요.
		// mysql을 사용하기 때문에 mysql에 대한 코드를 작성해야 해요.
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로딩
			String id = "zakelstorm"; // Database의 id
			String pw = "rnrn0808"; // 해당 id에 대한 pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database 접속 URL
			//2 . 접속
			Connection con = DriverManager.getConnection(url,id,pw);
			// 3. SQL을 이용해서 문장을 생성
			String sql = "insert into user_tbl values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			pstmt.setString(3, entity.getUname());
			pstmt.setString(4, entity.getUemail());
			// 4.실행
			pstmt.executeUpdate();
			//5. 결과처리
			// 6. 사용한 자원해제
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void Delete(UserEntity entity){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String id = "zakelstorm";
			String pw = "rnrn0808";
			String url = "jdbc:mysql://localhost:3306/library";
			
			Connection con = DriverManager.getConnection(url,id,pw);
			
			String sql = "delete from user_tbl where uid=? and upw = ? and uname = ? and uemail = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			pstmt.setString(3,entity.getUname());
			pstmt.setString(4, entity.getUemail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
