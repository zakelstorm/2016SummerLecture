package multiechotest;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(7777);// �����α׷����� ���� ��Ʈ��ȣ �Ұ�
			while(true){
				System.out.println("���ο�Ŭ���̾�Ʈ�� ��ٸ��ϴ�.");
				Socket s = server.accept();
				Thread t = new Thread(new MyRunnable(s));//������ �����尡 ���� �ϵ��� �Ѵ�.
				t.start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
