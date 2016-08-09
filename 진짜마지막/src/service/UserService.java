package service;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.UserDAO;

public class UserService {
	
	//transaction�� ������ �۾��� ������ ��Ī
	//service���� method�ϳ��� ���� �۾��� ����
	//->����� �α���,����� ���, ����� ����
	// �Ϲ������� �̷� �ϳ��� �����۾��� �������� SQL������ �����ؿ�.
	// transactionó���� java���� connection������ ó��
	public boolean login(String id,String pw){
		boolean result = false;
		Connection con = common.DBTemplate.getConnection(); //�̰� ���� �����ɸ��� �۾��̴ϱ�
		
		UserDAO dao = new UserDAO(con);
		result = dao.select(id, pw);
		//����� 1���� ȣ�������� ������ �������� dao method�� ȣ��ǿ�
		try {
			if(result){
				//����ó�� ������ �ش� �۾��� Ȯ��.
				con.commit();
			}else{
				con.rollback();
			}
			//connection pool���� connection�� �������
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
		
	}
}
