package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


// Thread들이 공유해서 사용하는 공용객체
//Singleton으로 작성해 주는게 좋다
public class SharedObject implements SharedInterface{
		private static SharedObject object= new SharedObject();
		private ArrayList<Socket> list = new ArrayList<Socket>();
		
		private SharedObject() {
			// TODO Auto-generated constructor stub
		}
		
		public static SharedInterface getInstance(){
			return object;
		}

		@Override
		public void addClient(Socket s) {
			list.add(s);
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeClient(Socket s) {
			// TODO Auto-generated method stub
			list.remove(s);
			
		}

		@Override
		public void broadcast(String msg) {
			// list 안에 들어있는 모든 client에 대한 socket을 이용해서 client에 대한 연결통로를 생성해서 message를 반복해서 출력해준다.
			
				try {
					for(Socket s : list){ // arraylist에 있는것 하나씩 꺼내라
						PrintWriter pw;
						pw = new PrintWriter(s.getOutputStream());
						pw.println(msg);
						pw.flush();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return list.size();
		}
}
