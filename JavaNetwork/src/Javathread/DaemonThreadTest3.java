package Javathread;

public class DaemonThreadTest3 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyDaemonThread());
		
		t.setDaemon(true); //t�� daemon Thread�� ����
		
		t.start();
		
		System.out.println("main ����!!");
		//main�� ����Ǹ� �ڱⰡ ���� �ڽ� thread�� ���� ���� �θ� ������ �ڽĵ� ����-> ���� �������� Ż��
	}
}

class MyDaemonThread implements Runnable{
	@Override
	public void run() {
		
		while(true){
			System.out.println("Thread ������!! ");
		}
		
	}
}