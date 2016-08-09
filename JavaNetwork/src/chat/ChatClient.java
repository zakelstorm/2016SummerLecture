package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		//Ű����κ��� �����͸� �޾Ƽ� ������ ����
		//������ ���� �õ����� ���� �����Ͱ� Ŭ���̾�Ʈ���� ����
		//�����κ��� ���� �����͸� ó���ϴ� Thread�� �ϳ� �����ؾ��Ѵ�.
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
