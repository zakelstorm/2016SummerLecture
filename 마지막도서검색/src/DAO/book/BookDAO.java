package DAO.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.book.BookEntity;

public class BookDAO {
	
	public ArrayList<BookEntity> select(BookEntity entity){
		ArrayList<BookEntity> result = new ArrayList<BookEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로딩
			String id = "zakelstorm"; // Database의 id
			String pw = "rnrn0808"; // 해당 id에 대한 pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database 접속 URL
			//2 . 접속
			Connection con = DriverManager.getConnection(url,id,pw);
			
			String sql = "select * from books where btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + entity.getBtitle() + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BookEntity willadd = new BookEntity();
				willadd.setBimgurl((rs.getString("bimgurl")));
				willadd.setBtitle(rs.getString("btitle"));
				willadd.setBauthor(rs.getString("bauthor"));
				willadd.setBisdn(rs.getString("bisbn"));
				willadd.setBprice(rs.getInt("bprice"));
				result.add(willadd);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}
	
	public static ArrayList<BookEntity> select2(String[] list){
		ArrayList<BookEntity> result = new ArrayList<BookEntity>();
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로딩
			String id = "zakelstorm"; // Database의 id
			String pw = "rnrn0808"; // 해당 id에 대한 pw
			String url = "jdbc:mysql://localhost:3306/library"; //Database 접속 URL
			//2 . 접속
			Connection con = DriverManager.getConnection(url,id,pw);
			
			String sql = "select * from books where bisbn = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			for(int i=0;i<list.length;i++){
				pstmt.setString(1, list[i]);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				BookEntity entity = new BookEntity();
				entity.setBimgurl(rs.getString("bimgurl"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				entity.setBprice(rs.getInt("bprice"));
				entity.setBisdn(rs.getString("bisbn"));
				result.add(entity);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
