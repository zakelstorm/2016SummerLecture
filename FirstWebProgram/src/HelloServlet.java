

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
		//GET방식의 요청이 들어오면 여기가 수행되요!!
		//1.사용자의 입력을 받아들여요
		//2.로직처리해요(DB처리 포함한)
		//3.결과를 클라이언트에게 출력
		//3.1 최종적으로 결과를 만들어내요.(HTML문서,일반text,그림,동영상,...)
		//     이런 결과를 클라이언트에게 보내주는 거에요
		//     먼저 결과를 클라이언트에게 보내주기 이전에 결과에 대한 종류를 알려줘야 해요
		
		response.setContentType("text/plain; charset=utf8");//응답에대해서 결과내용의 타입을 설정. 현재 일반문자 지칭 유니코드로 보내줄게
		//response.setContentType("text/html");//지금내가 보내는게 html타입문서야
		//response.setContentType("img/jpg");//지금내가 보내는게 image jpg타입 그림이야
		
		//결과를 클라이언트에게 전달
		PrintWriter pw = response.getWriter(); //response가 이미 응답에 대한 객체 클라이언트까지의 길이 열린다
		pw.println("이것은 소리없는 아우성!!");
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
