package DateTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {
	public static void main(String[] args) {
		
		//1. ������ ����(�������Ͽ� ���ӽõ�)
		//���� ������ �����ϸ� �� ����� Socket ��ü�� ����.
		Socket s = null;
		BufferedReader br = null;
		try {
			s = new Socket("localhost",5000);//local host�� ���� �� ��ǻ�� ��Ī
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); // socket�� ���� inputstream�� �� �� �ִ�.
			                                                                                                                             // ������ system.in���� ����â���� �޾Ҵµ� ���� socket�� ���ؼ�
			// readLine�� blocking method�̱� ������ ������ ���������� ���⼭ ���
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
/*����� �����ϳ��� ���� ���� �ȴ�*/