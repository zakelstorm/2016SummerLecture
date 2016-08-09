package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OutputServlet
 */
@WebServlet("/output")
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력을 받아요.
		// 2. 로직 처리를 하기위해서 Service객체 -> 로직처리
		// 3. 로직처리의 결과를 받아오죠.
		// 4. 결과를 출력
		// 결과를 출력할때는 JSP를 이용
		//JSP도 Servlet이에요
		//Servlet이 다른 Servlet을 호출하는 구조
		/*RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);*/
		String result =  "이것은 결과값이다";
		//JSP를 통해서 결과를 출력해야되는데.. 이 처리결과값을 JSP에게
		//넘겨줘야지..JSP가 이 결과값을 클라이언트에게 출력할거에요
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		//결과데이터를 어딘가에 붙여줘요.
		request.setAttribute("MYDATA", result);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
