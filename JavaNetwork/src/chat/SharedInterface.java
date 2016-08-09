package chat;

import java.net.Socket;

public interface SharedInterface {
	public void addClient(Socket s);
	public void removeClient(Socket s);
	void broadcast(String msg); // �޼��� �ϳ��� ��� Ŭ���̾�Ʈ�鿡��
	int size(); //���� ����� Ŭ���̾�Ʈ�� �ִ���
}
