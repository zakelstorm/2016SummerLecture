package controll.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.user.UserEntity;
import service.user.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.�ѱ� ó��??
		// get����� ��쿡�� ���α׷� ó�����ٴ� tomcat ȯ�濡�� ó�����ִ°� ���ƿ�
		// tomcat������ server.xml ������ ����
		// URIEncoding = "UTF8" �� connector�κп� �߰�
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.�ѱ�ó��
		//post ����� ��쿡�� ����� �� �־��. (GET����� �ٸ� ������� �ؾ��Ѵ�)
		request.setCharacterEncoding("UTF8");
		//2.����ڷκ��� �Ѿ�� �����͸� �޾ƿ�!(�Է¹޾ƿ�)
		String id = request.getParameter("inputId");
		String pw=request.getParameter("inputPassword");
		//3. ����ó��
		// service ��ü�� �̿��ؼ� ����ó���� ���ѿ�!
		UserService service = new UserService();
		//user�� ���� entity�� ���� ���ڷ� �̿�
		UserEntity entity = new UserEntity();
		entity.setUid(id);
		entity.setUpw(pw);
		boolean result = service.login(entity);
		RequestDispatcher rd = request.getRequestDispatcher("loginResult.jsp");
		if(result){
			// �α��ο� ���������ϱ� �ش� Ŭ���̾�Ʈ���� session��ü�� �Ҵ��ؿ�.
			HttpSession session = request.getSession(true);
			//���� ������ ����ϴ� ���� ��ü�� �����ϸ� ������ ���� �װ� ����.
			session.setAttribute("USERID", id);
			request.setAttribute("MSG", id + "�� ȯ���մϴ�.!!");
			request.setAttribute("flag", true);
			rd.forward(request, response);
			
		}else{
			
			request.setAttribute("MSG", "�α��ο� �����߽��ϴ�. �ٽ� �α��� �Ͻʽÿ�.!!");
			request.setAttribute("flag", false);
			rd.forward(request, response);
		}
		
		
}

}
