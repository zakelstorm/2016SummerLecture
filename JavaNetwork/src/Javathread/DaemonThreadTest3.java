package Javathread;

public class DaemonThreadTest3 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyDaemonThread());
		
		t.setDaemon(true); //t를 daemon Thread로 지정
		
		t.start();
		
		System.out.println("main 종료!!");
		//main이 종료되면 자기가 만든 자식 thread도 같이 종료 부모가 죽으면 자식도 죽음-> 무한 루프에서 탈출
	}
}

class MyDaemonThread implements Runnable{
	@Override
	public void run() {
		
		while(true){
			System.out.println("Thread 동작중!! ");
		}
		
	}
}