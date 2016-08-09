package Javathread;

//이 클래스의 instance를 thread로 만들예정.
//가장 쉬운 방식은 inheritance(상속)을 이용
public class MyThread1 extends Thread{
	//독립적인 실행흐름을 작성
	//overriding을 할 method가 정해져 있다.
	@Override
	public void run(){
		System.out.println("1번째");
		for(int i=0;i<10;i++){
			System.out.println("thread의 출력!! : " + i);
		}
	}
	
	
	
}
