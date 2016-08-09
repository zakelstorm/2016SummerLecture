package multiechotest;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(7777);// 한프로그램내에 같은 포트번호 불가
			while(true){
				System.out.println("새로운클라이언트를 기다립니다.");
				Socket s = server.accept();
				Thread t = new Thread(new MyRunnable(s));//각각의 스레드가 일을 하도록 한다.
				t.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
