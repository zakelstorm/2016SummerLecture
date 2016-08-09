package DAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.user.UserEntity;

public class UserDAO {
	public boolean select(UserEntity entity){
		boolean result = false;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로딩
			String id = "zakelstorm"; // Database의 id
			String pw = "rnrn0808"; // 해당 id에 대한 pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database 접속 URL
			//2 . 접속
			Connection con = DriverManager.getConnection(url,id,pw);
			
			String sql = "select * from user_tbl where uid = ? and upw = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs = pstmt.executeQuery();//select 에 관해서는 무조건 executeQuery();
			
			if(rs.next()){
				System.out.println("있어요");
				result = true;
			}else{
				System.out.println("없어요");
				result = false;
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
		
	}
}
