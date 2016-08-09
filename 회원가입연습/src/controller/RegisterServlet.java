package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import entity.UserEntity;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ������ ����� ������ ���� �� �־��
		//���� ����ڷκ��� �ѱ۵����Ͱ� ������ �ѱ�ó���� ����ߵſ�
		//post����� ��� method�ϳ��� �̿��ϸ� �ѱ�ó���� ���� ������ �� �־��.
		request.setCharacterEncoding("UTF8");
		//������� �Է��� �޾ƿ�
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		//�Է¹��� �����͸� ������ ����ó���� �ؿ�
		//����ó���� ���� ��ü�� ���� �ش� ��ü�� method�� �̿��ؼ� ����ó���� �ؿ�
		// ��������� ����ó����ü(Service)�� ���� ���.
		UserService service = new UserService();
		UserEntity entity = new UserEntity(id,pw,name,email);
		service.registerUser(entity);
		
		
	}

}
