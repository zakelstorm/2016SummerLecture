package chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3333); // 하나의 소켓은 하나의 클라이언트와의 연결고리
			SharedInterface shared = SharedObject.getInstance();
			while(true){
				Socket socket = server.accept();
				//동시에 여러명의 client를 서비스해주기 위해서 Thread가 나와야한다.
				Thread t = new Thread(new ChatThread(socket,shared));
				System.out.println("클라이언트 접속. 현재 사용자 " +shared.size() +"명");
				t.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
