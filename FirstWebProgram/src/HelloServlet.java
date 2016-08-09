

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//GET����� ��û�� ������ ���Ⱑ ����ǿ�!!
		//1.������� �Է��� �޾Ƶ鿩��
		//2.����ó���ؿ�(DBó�� ������)
		//3.����� Ŭ���̾�Ʈ���� ���
		//3.1 ���������� ����� ������.(HTML����,�Ϲ�text,�׸�,������,...)
		//     �̷� ����� Ŭ���̾�Ʈ���� �����ִ� �ſ���
		//     ���� ����� Ŭ���̾�Ʈ���� �����ֱ� ������ ����� ���� ������ �˷���� �ؿ�
		
		response.setContentType("text/plain; charset=utf8");//���信���ؼ� ��������� Ÿ���� ����. ���� �Ϲݹ��� ��Ī �����ڵ�� �����ٰ�
		//response.setContentType("text/html");//���ݳ��� �����°� htmlŸ�Թ�����
		//response.setContentType("img/jpg");//���ݳ��� �����°� image jpgŸ�� �׸��̾�
		
		//����� Ŭ���̾�Ʈ���� ����
		PrintWriter pw = response.getWriter(); //response�� �̹� ���信 ���� ��ü Ŭ���̾�Ʈ������ ���� ������
		pw.println("�̰��� �Ҹ����� �ƿ켺!!");
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
