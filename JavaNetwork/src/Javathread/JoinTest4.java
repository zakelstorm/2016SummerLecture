package Javathread;

public class JoinTest4 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyJoin());
		t.start();
		try {
			t.join(); // main thread�� �Ͻ� ���. ��������� ������ �� �ִ�.	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("main thread ����!!");
	}
}
//Java �� �� ���ϳ��� �ΰ��� public class�� ���� �� ����.
class MyJoin implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(5000);//sleep�� exception�� �����Ѵ�.
			System.out.println("5�ʰ� ���� ��� �Ͼ��!!");
		} catch (Exception e) {
			
		}
		
	}
}