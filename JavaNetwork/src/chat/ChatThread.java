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
		//Ŭ���̾�Ʈ�κ��� message�� �޴´�.(/exit)�� ������ ������
		//��� Ŭ���̾�Ʈ�鿡�� ����
		String msg = null;
		try {
			while(!(msg = br.readLine()).equals("/exit")){
				System.out.println(msg);
				shared.broadcast(msg);
			}
			//����� �Դٴ� ���� Ŭ���̾�Ʈ�� "/exit"�� �Է�
			//Ŭ���̾�Ʈ�� ����Ǿ��ٴ� �ǹ�
			shared.removeClient(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
