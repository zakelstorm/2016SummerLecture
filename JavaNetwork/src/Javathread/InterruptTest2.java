package Javathread;

//interrupt�� flag�� ������ interrupt�Ǿ��ٰ� ��ٷ� �״°��� �ƴϴ�.

public class InterruptTest2 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyInterruptThread());
		t.start();
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			
		}// t�� ����Ǵ� �߿� 5�ʸ� ���� �ܴ�. �׸��� ���� interrupt�� ����
		t.interrupt(); // Thread�� ������ ����. 
		//���� sleep �Ⱓ���� interrupt�� �߻��Ǹ� exception�߻�. ���� sleep�� interrupt�� ���� ���°��� �����ʴ�.
	}
}

//Thread�� ����� ���� Runnable interface�� ������ Ŭ����
class MyInterruptThread implements Runnable{

	@Override
	public void run() {
		try{
			while(!Thread.currentThread().isInterrupted()){ // Thread.currentThread(): ���� �����ϰ� �ִ� Thread�� ã�´�.
																			  //Thread.currentThread().isInterrupted() ���� �����ϰ� �ִ� Thread�� interrupt�� �Ǿ��ִ�?
				System.out.println("�ش� thread�� ��� �������̿���!!");
				//Thread.sleep(2000); // ��� 2�� �ڰ� ��� 2�� �ڰ�
			}
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}