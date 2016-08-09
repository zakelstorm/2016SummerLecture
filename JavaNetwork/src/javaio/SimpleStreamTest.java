package javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleStreamTest {
	public static void main(String[] args) {
		
		//Ű����κ��� ������ �о���ϰ��̴�.
		//Stream�� �̿��ؾ� ó���� �� �� �ִ�.
		//System.in => InputStream class�� instance
		InputStreamReader isr = new InputStreamReader(System.in);//�׳� InputStream�� low level�� �ޱ� ����(ex ����Ʈ ���� ,���ڿ��� ������) ���ڿ� ������ InputStreamReader
		BufferedReader br = new BufferedReader(isr); //���ڿ� �Է¿��� ���� ȿ���� ����
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
