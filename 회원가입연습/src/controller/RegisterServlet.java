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
		//클라이언트가 보내준 사용자 정보를 받을 수 있어요
		//만약 사용자로부터 한글데이터가 들어오면 한글처리를 해줘야돼요
		//post방식일 경우 method하나를 이용하면 한글처리를 쉽게 가져갈 수 있어요.
		request.setCharacterEncoding("UTF8");
		//사용자의 입력을 받아요
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		//입력받은 데이터를 가지고 로직처리를 해요
		//로직처리를 위한 객체를 만들어서 해당 객체의 method를 이용해서 로직처리를 해요
		// 결론적으로 로직처리객체(Service)를 만들어서 사용.
		UserService service = new UserService();
		UserEntity entity = new UserEntity(id,pw,name,email);
		service.registerUser(entity);
		
		
	}

}
