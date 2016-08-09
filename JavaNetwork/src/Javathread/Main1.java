package Javathread;

public class Main1 {
	
	public static void main(String[] args) {
/* 상속방식*/		
		//또 다른 실행 흐름인 thread를 생성해서 사용. (main과 다른)
		//thread는 객체 -> class가 존재
		//thread instance 생성.
//		Thread t1 = new MyThread();
		//thread를 실행시키기 위해서는 start() method를 이용.
//		t1.start(); // blocking(일반 method 였다면 이 작업이 끝날때까지 return값을 받기까지 기다려야한다) 발생 X
		//jVM이 고민을 한다..2개의 thread가 존재하네??
		//나름대로의 정책을 가지고 결정.(프로그래머가 어떻게 할지 결정을 할 수 없어) 시분할방식으로 동시에 실행되는것처럼 보임
//		System.out.println("main thread 종료!");
		//sub program이 2개있다고 생각
//------------------------------------------------------------------------------------------------------------------------------//		
/*		object injection 방식	*/
		MyRunnable1 runnable = new MyRunnable1(); //아직 thread가 아니라고 했다.
		Thread t1 = new Thread(runnable);
		//객체지향면에서 훨씬 좋다.
		t1.start();
		while(true);
	}
	
}
