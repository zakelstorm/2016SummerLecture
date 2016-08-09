package DateTest;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//��¥�� �������ִ� ����
public class DateServer {
	
	public static void main(String[] args) {
		
		// 1.  �������ϰ�ü�� ���� (Ŭ���̾�Ʈ�� ������ ��ٸ��°��� ��������)
		ServerSocket server = null;
		Socket socket = null;
		PrintWriter pw  = null;
		try {
			server = new ServerSocket(5000);
			socket = server.accept(); // �Ͻ� ��� ������ ���ö� ����(�������α׷��� ����ٴ� ���) 
			                                              //������ �̷������ ��������Ŭ���̾�Ʈ ������ ����
			pw = new PrintWriter(socket.getOutputStream());
			// ����ð��� ���ؿ�
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
