package javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleStreamTest {
	public static void main(String[] args) {
		
		//키보드로부터 한줄을 읽어들일것이다.
		//Stream을 이용해야 처리를 할 수 있다.
		//System.in => InputStream class의 instance
		InputStreamReader isr = new InputStreamReader(System.in);//그냥 InputStream은 low level을 받기 좋다(ex 바이트 정수 ,문자열은 안좋아) 문자열 관련은 InputStreamReader
		BufferedReader br = new BufferedReader(isr); //문자열 입력에서 가장 효율이 좋음
		try {
			String input = br.readLine();
			System.out.println(input);
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			try {
				isr.close();
				br.close();;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
