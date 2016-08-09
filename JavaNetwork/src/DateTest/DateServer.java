package DateTest;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//날짜를 제공해주는 서버
public class DateServer {
	
	public static void main(String[] args) {
		
		// 1.  서버소켓객체를 생성 (클라이언트의 접속을 기다리는것이 서버소켓)
		ServerSocket server = null;
		Socket socket = null;
		PrintWriter pw  = null;
		try {
			server = new ServerSocket(5000);
			socket = server.accept(); // 일시 대기 접속이 들어올때 까지(서버프로그램이 멈춘다는 얘기) 
			                                              //접속이 이루어지면 서버내에클라이언트 소켓을 생성
			pw = new PrintWriter(socket.getOutputStream());
			// 현재시간을 구해요
			String result = (new Date()).toLocaleString();
			
			pw.println(result);
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				pw.close();
				socket.close();
				server.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
