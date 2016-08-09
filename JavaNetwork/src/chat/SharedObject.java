package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


// Thread���� �����ؼ� ����ϴ� ���밴ü
//Singleton���� �ۼ��� �ִ°� ����
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
			// list �ȿ� ����ִ� ��� client�� ���� socket�� �̿��ؼ� client�� ���� ������θ� �����ؼ� message�� �ݺ��ؼ� ������ش�.
			
				try {
					for(Socket s : list){ // arraylist�� �ִ°� �ϳ��� ������
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
