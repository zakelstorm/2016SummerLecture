package service.user;

import DAO.user.UserDAO;
import entity.user.UserEntity;

public class UserService {
	public boolean login(UserEntity entity){
		boolean result = false;
		//�α��ο� ���� ����ó���� �ؿ�!
		//Database ó���� ����
		UserDAO dao = new UserDAO();
		result = dao.select(entity);
		return result;
	}
}
