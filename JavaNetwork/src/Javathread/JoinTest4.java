package Javathread;

public class JoinTest4 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyJoin());
		t.start();
		try {
			t.join(); // main thread가 일시 대기. 수행순서를 조절할 수 있다.	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("main thread 종료!!");
	}
}
//Java 는 한 파일내에 두개의 public class를 가질 수 없다.
class MyJoin implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(5000);//sleep은 exception을 강제한다.
			System.out.println("5초간 잠을 잤고 일어났다!!");
		} catch (Exception e) {
			
		}
		
	}
}