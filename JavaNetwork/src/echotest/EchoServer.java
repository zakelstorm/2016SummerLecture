package echotest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			server = new ServerSocket(5000);
			System.out.println(("서버기동 5000"));
			s= server.accept();
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			
			String str = null;
			while(!(str = br.readLine()).equals("/exit")){
				System.out.println("받은 msg : " +str);
				pw.println(str);
				pw.flush();
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				br.close();
				pw.close();
				s.close();
				server.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		}
		
	}
}
