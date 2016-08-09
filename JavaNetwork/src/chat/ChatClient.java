package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		//키보드로부터 데이터를 받아서 서버에 전달
		//서버로 부터 시도때도 없이 데이터가 클라이언트에게 전달
		//서버로부터 오는 데이터를 처리하는 Thread가 하나 존재해야한다.
		try {
			Socket s = new Socket("localhost",3333);
			Thread t = new Thread(new ClientDisplayThread(s));
			t.start();	
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			String msg = null;
			while(!((msg = keyboard.readLine()).equals("/exit"))){
				pw.println(msg);
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
