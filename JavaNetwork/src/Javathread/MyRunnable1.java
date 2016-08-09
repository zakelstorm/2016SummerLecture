package Javathread;

//thread 클래스로부터 상속을 받지않는다.
//runnable interface를 구현한 클래스일 뿐이다.(thread x)

public class MyRunnable1 implements Runnable{

	@Override
	public void run() {
		System.out.println("2번째");
		System.out.println("출력출력!! : ");
	}
	
}
