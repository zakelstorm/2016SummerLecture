package multiechotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyRunnable implements Runnable{
	
	private Socket socket = null;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	
	public MyRunnable(Socket s) {
		socket = s;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void run() {
		try {
			String str = null;
			while(!(str = br.readLine()).equals("/exit")){
				System.out.println("¹ÞÀº msg : " +str);
				pw.println(str);
				pw.flush();
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
