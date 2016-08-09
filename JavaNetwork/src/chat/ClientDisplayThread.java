package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDisplayThread implements Runnable{
	
	private Socket s;
	private BufferedReader br = null;
	
	public ClientDisplayThread(Socket s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			String msg = null;
			
			while((msg = br.readLine())!= null){
				System.out.println("입력받았으요");
				System.out.println(msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
