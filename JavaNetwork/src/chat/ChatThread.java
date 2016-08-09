package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatThread implements Runnable{
	private Socket socket = null;
	private SharedInterface shared = null;
	private BufferedReader br;
	
	public ChatThread(Socket socket,SharedInterface shared) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.shared = shared;
		this.shared.addClient(socket);
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		//클라이언트로부터 message를 받는다.(/exit)가 들어오기 전까지
		//모든 클라이언트들에게 전달
		String msg = null;
		try {
			while(!(msg = br.readLine()).equals("/exit")){
				System.out.println(msg);
				shared.broadcast(msg);
			}
			//여기로 왔다는 말은 클라이언트가 "/exit"를 입력
			//클라이언트가 종료되었다는 의미
			shared.removeClient(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
