package Service;

import dao.UserDAO;
import entity.UserEntity;

public class UserService {
	//로직처리를 하기위한 business method
	public void registerUser(UserEntity Entity){
		//entity안에 데이터가 들어있어요
		// 로직처리하는 객체이기때문에 로직처리만 나와요!
		// 사용자 등록 로직처리를 해야해요!
		// Database에 해당 사용자의 정보를 입력하는게 끝이야.
		// 그러니까 별다른 로직처리를 할게 없어요.
		// Database 처리만 하면 되요!
		UserDAO dao = new UserDAO();
		dao.insert(Entity);
	}
	public void deleteUser(UserEntity Entity){
		UserDAO dao = new UserDAO();
		dao.Delete(Entity);
	}
}
