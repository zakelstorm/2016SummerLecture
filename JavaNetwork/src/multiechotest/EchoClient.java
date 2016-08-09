package multiechotest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient {
	public static void main(String[] args) {
		Socket s = null;
		BufferedReader br = null;
		BufferedReader keyboard = null;
		PrintWriter pw = null;
		
		try {
			s = new Socket ("localhost",7777);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			String msg = null;
			while(!(msg=keyboard.readLine()).equals("/exit")){
					pw.println(msg);
					pw.flush();
					System.out.println(br.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				s.close();
				br.close();
				pw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
