package Javathread.conpro;

public class Main {
	public static void main(String[] args) {
		Queue queue = QueueImpl.getInstance();
		Thread pro = new Thread(new Producer(queue));
		Thread con1 = new Thread(new Consumer(queue,"con1"));
		Thread con2= new Thread(new Consumer(queue,"con2"));
		Thread con3 = new Thread(new Consumer(queue,"con3"));
		
	
		con1.start();
		con2.start();
		con3.start();
		
		pro.start();
		/*�������� ������� Ȯ�� �� �� ����.*/
		
		try {
			Thread.sleep(10); // main�� ����
			pro.interrupt();
			Thread.sleep(10);
			con1.interrupt();
			con2.interrupt();
			con3.interrupt();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
