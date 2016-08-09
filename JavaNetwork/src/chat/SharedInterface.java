package chat;

import java.net.Socket;

public interface SharedInterface {
	public void addClient(Socket s);
	public void removeClient(Socket s);
	void broadcast(String msg); // 메세지 하나를 모든 클라이언트들에게
	int size(); //현재 몇명의 클라이언트가 있는지
}
