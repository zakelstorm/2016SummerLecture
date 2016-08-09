package controll.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.book.BookEntity;
import service.book.BookService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. �Է��� �޾ƿ�!
		//2.���ǿ��� å������ ���;� �ؿ�
		HttpSession session = request.getSession();
		String[] list = (String[])session.getAttribute("Cart");
		//�� ������ ������ DBó���� �ؼ�(���� ISBN�ۿ� �����ϱ�) ��ٱ��� ȭ���� ���� ���!
		BookService service = new BookService();
		 ArrayList<BookEntity> result = service.listCart(list);
		RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
		request.setAttribute("MYKEY", result);
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
