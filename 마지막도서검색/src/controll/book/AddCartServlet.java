package controll.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		//1.�ѱ�ó��
		response.setCharacterEncoding("UTF8");
		//2. �Է��� �޾ƿ�!
		String[] list = request.getParameterValues("checkBook");//�̸������ؼ� �������� ���� �� �ִ�. �� checkbox���� ��쿡�� �̰Ÿ� �̿�
		// �� �迭�ȿ� ���� ������ å�� ISBN��ȣ�� �� �־��.
		//3. ���񽺸� ���� ����ó���� �ؿ�;.
		// session�� �̿��ؼ� �� �ȿ� ����ڰ� ������ å�� ������ ����
		// session�� servlet������ ����� �� �־��!!
		// �׷��� �ᱹ �� �ȿ��� sessionó���� �� �ſ���
		HttpSession session = request.getSession(true);
		if(session.getAttribute("Cart")==null){
			System.out.println("��");
			session.setAttribute("Cart", list);
		}else{
			String[] result;
			
			String[] tmp = (String[])session.getAttribute("Cart");
			
			ArrayList<String> arrlist = new ArrayList<String>();
			for(int i=0;i<tmp.length;i++){
				arrlist.add(tmp[i]);
			}
			for(int i=0;i<list.length;i++){
				arrlist.add(list[i]);
			}
			String[] resultArr = new String[arrlist.size()];
			for(int i=0;i<arrlist.size();i++){
				resultArr[i] = arrlist.get(i);
			}
			session.setAttribute("Cart", resultArr);
		}
		
		response.sendRedirect("CartOK.html");
	}

}
