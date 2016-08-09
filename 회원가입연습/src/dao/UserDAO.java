package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entity.UserEntity;

public class UserDAO {
	

	public void insert(UserEntity entity) {
		
		//JDBC �ڵ� (Java�� �̿��� Databaseó���ڵ�)
		// 1. Database�� �̿��ϱ� ���ؼ� �ʿ��� �⺻ Driver Ŭ������ �ε�
		// 2. ����ϴ� Database������ ���� �ۼ��ϴ� �ڵ尡 �޶�����.
		// mysql�� ����ϱ� ������ mysql�� ���� �ڵ带 �ۼ��ؾ� �ؿ�.
		try {
			Class.forName("com.mysql.jdbc.Driver");//����̹� �ε�
			String id = "zakelstorm"; // Database�� id
			String pw = "rnrn0808"; // �ش� id�� ���� pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database ���� URL
			//2 . ����
			Connection con = DriverManager.getConnection(url,id,pw);
			// 3. SQL�� �̿��ؼ� ������ ����
			String sql = "insert into user_tbl values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, entity.getUid());
			pstmt.setString(2, entity.getUpw());
			pstmt.setString(3, entity.getUname());
			pstmt.setString(4, entity.getUemail());
			// 4.����
			pstmt.executeUpdate();
			//5. ���ó��
			// 6. ����� �ڿ�����
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
