package service;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.UserDAO;

public class UserService {
	
	//transaction은 논리적인 작업의 단위를 지칭
	//service안의 method하나의 단위 작업을 수행
	//->사용자 로그인,사용자 등록, 사용자 삭제
	// 일반적으로 이런 하나의 단위작업은 여러개의 SQL문장을 수행해요.
	// transaction처리는 java에서 connection단위로 처리
	public boolean login(String id,String pw){
		boolean result = false;
		Connection con = common.DBTemplate.getConnection(); //이게 가장 오래걸리는 작업이니까
		
		UserDAO dao = new UserDAO(con);
		result = dao.select(id, pw);
		//여기는 1개만 호출하지만 실제로 여러개의 dao method가 호출되요
		try {
			if(result){
				//정상처리 됐으면 해당 작업을 확정.
				con.commit();
			}else{
				con.rollback();
			}
			//connection pool한테 connection을 돌려줘요
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
}
