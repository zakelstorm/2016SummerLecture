package chat;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3333); // �ϳ��� ������ �ϳ��� Ŭ���̾�Ʈ���� �����
			SharedInterface shared = SharedObject.getInstance();
			while(true){
				Socket socket = server.accept();
				//���ÿ� �������� client�� �������ֱ� ���ؼ� Thread�� ���;��Ѵ�.
				Thread t = new Thread(new ChatThread(socket,shared));
				System.out.println("Ŭ���̾�Ʈ ����. ���� ����� " +shared.size() +"��");
				t.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
