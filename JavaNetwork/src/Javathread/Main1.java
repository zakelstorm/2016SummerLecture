package Javathread;

public class Main1 {
	
	public static void main(String[] args) {
/* ��ӹ��*/		
		//�� �ٸ� ���� �帧�� thread�� �����ؼ� ���. (main�� �ٸ�)
		//thread�� ��ü -> class�� ����
		//thread instance ����.
//		Thread t1 = new MyThread();
		//thread�� �����Ű�� ���ؼ��� start() method�� �̿�.
//		t1.start(); // blocking(�Ϲ� method ���ٸ� �� �۾��� ���������� return���� �ޱ���� ��ٷ����Ѵ�) �߻� X
		//jVM�� ����� �Ѵ�..2���� thread�� �����ϳ�??
		//��������� ��å�� ������ ����.(���α׷��Ӱ� ��� ���� ������ �� �� ����) �ú��ҹ������ ���ÿ� ����Ǵ°�ó�� ����
//		System.out.println("main thread ����!");
		//sub program�� 2���ִٰ� ����
//------------------------------------------------------------------------------------------------------------------------------//		
/*		object injection ���	*/
		MyRunnable1 runnable = new MyRunnable1(); //���� thread�� �ƴ϶�� �ߴ�.
		Thread t1 = new Thread(runnable);
		//��ü����鿡�� �ξ� ����.
		t1.start();
		while(true);
	}
	
}
