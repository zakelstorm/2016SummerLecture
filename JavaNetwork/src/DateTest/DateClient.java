package DateTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) {
		
		//1. 서버에 접속(서버소켓에 접속시도)
		//만약 접속이 성공하면 그 결과로 Socket 객체를 리턴.
		Socket s = null;
		BufferedReader br = null;
		try {
			s = new Socket("localhost",5000);//local host는 현재 내 컴퓨터 지칭
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); // socket에 대해 inputstream을 얻어낼 수 있다.
			                                                                                                                             // 전에는 system.in으로 도스창에서 받았는데 이젠 socket을 통해서
			// readLine은 blocking method이기 때문에 읽을게 있을때까지 여기서 대기
			String date = br.readLine();
			System.out.println(date);
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			try {
				br.close();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
/*연결된 소켓하나를 서로 갖게 된다*/