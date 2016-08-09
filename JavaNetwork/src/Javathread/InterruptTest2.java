package Javathread;

//interrupt는 flag와 같은것 interrupt되었다고 곧바로 죽는것이 아니다.

public class InterruptTest2 {
	public static void main(String[] args) {
		Thread t = new Thread(new MyInterruptThread());
		t.start();
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			
		}// t가 실행되는 중에 5초를 잠을 잔다. 그리고 깨면 interrupt를 실행
		t.interrupt(); // Thread의 실행을 중지. 
		//만약 sleep 기간동안 interrupt가 발생되면 exception발생. 따라서 sleep과 interrupt는 같이 쓰는것은 좋지않다.
	}
}

//Thread를 만들기 위한 Runnable interface를 구현한 클래스
class MyInterruptThread implements Runnable{

	@Override
	public void run() {
		try{
			while(!Thread.currentThread().isInterrupted()){ // Thread.currentThread(): 현재 동작하고 있는 Thread를 찾는다.
																			  //Thread.currentThread().isInterrupted() 현재 동작하고 있는 Thread가 interrupt가 되어있니?
				System.out.println("해당 thread는 계속 수행중이에요!!");
				//Thread.sleep(2000); // 찍고 2초 자고 찍고 2초 자고
			}
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}