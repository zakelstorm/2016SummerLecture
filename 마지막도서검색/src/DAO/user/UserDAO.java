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
			
			Class.forName("com.mysql.jdbc.Driver");//����̹� �ε�
			String id = "zakelstorm"; // Database�� id
			String pw = "rnrn0808"; // �ش� id�� ���� pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database ���� URL
			//2 . ����
			Connection con = DriverManager.getConnection(url,id,pw);
			
			String sql = "select * from user_tbl where uid = ? and upw = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			ResultSet rs = pstmt.executeQuery();//select �� ���ؼ��� ������ executeQuery();
			
			if(rs.next()){
				System.out.println("�־��");
				result = true;
			}else{
				System.out.println("�����");
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
