package Service;

import dao.UserDAO;
import entity.UserEntity;

public class UserService {
	//����ó���� �ϱ����� business method
	public void registerUser(UserEntity Entity){
		//entity�ȿ� �����Ͱ� ����־��
		// ����ó���ϴ� ��ü�̱⶧���� ����ó���� ���Ϳ�!
		// ����� ��� ����ó���� �ؾ��ؿ�!
		// Database�� �ش� ������� ������ �Է��ϴ°� ���̾�.
		// �׷��ϱ� ���ٸ� ����ó���� �Ұ� �����.
		// Database ó���� �ϸ� �ǿ�!
		UserDAO dao = new UserDAO();
		dao.insert(Entity);
	}
	public void deleteUser(UserEntity Entity){
		UserDAO dao = new UserDAO();
		dao.Delete(Entity);
	}
}
