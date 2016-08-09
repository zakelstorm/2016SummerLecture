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
		//1.한글처리
		response.setCharacterEncoding("UTF8");
		//2. 입력을 받아요!
		String[] list = request.getParameterValues("checkBook");//이름에대해서 여러개를 받을 수 있다. 즉 checkbox같은 경우에는 이거를 이용
		// 이 배열안에 현재 선택한 책의 ISBN번호가 들어가 있어요.
		//3. 서비스를 만들어서 로직처리를 해요;.
		// session을 이용해서 이 안에 사용자가 선택한 책의 정보를 저장
		// session은 servlet에서만 사용할 수 있어요!!
		// 그래서 결국 이 안에서 session처리를 할 거에요
		HttpSession session = request.getSession(true);
		if(session.getAttribute("Cart")==null){
			System.out.println("널");
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
