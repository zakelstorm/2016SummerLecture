package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	Connection con;
	public UserDAO(Connection con) {
		this.con = con;
	}
	public boolean select(String id,String pw){
		boolean result = false;
		try{
			//DBCP를 이용해서 connection을 효율적으로 이용하기 위함.
			String sql = "select * from user_tbl where uid =? and upw=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				result = true;
			}else{
				result  = false;
			}
			
		}catch(Exception e){
			
		}
		
		return result;
	}
}
