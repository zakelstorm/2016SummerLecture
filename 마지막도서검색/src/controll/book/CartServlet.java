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
		//1. 입력을 받아요!
		//2.세션에서 책정보를 얻어와야 해요
		HttpSession session = request.getSession();
		String[] list = (String[])session.getAttribute("Cart");
		//이 정보를 가지고 DB처리를 해서(현재 ISBN밖에 없으니까) 장바구니 화면을 만들어서 출력!
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
