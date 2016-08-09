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
		// 1. �Է��� �޾ƿ�.
		// 2. ���� ó���� �ϱ����ؼ� Service��ü -> ����ó��
		// 3. ����ó���� ����� �޾ƿ���.
		// 4. ����� ���
		// ����� ����Ҷ��� JSP�� �̿�
		//JSP�� Servlet�̿���
		//Servlet�� �ٸ� Servlet�� ȣ���ϴ� ����
		/*RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);*/
		String result =  "�̰��� ������̴�";
		//JSP�� ���ؼ� ����� ����ؾߵǴµ�.. �� ó��������� JSP����
		//�Ѱ������..JSP�� �� ������� Ŭ���̾�Ʈ���� ����Ұſ���
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		//��������͸� ��򰡿� �ٿ����.
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
