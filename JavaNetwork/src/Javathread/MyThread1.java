package Javathread;

//�� Ŭ������ instance�� thread�� ���鿹��.
//���� ���� ����� inheritance(���)�� �̿�
public class MyThread1 extends Thread{
	//�������� �����帧�� �ۼ�
	//overriding�� �� method�� ������ �ִ�.
	@Override
	public void run(){
		System.out.println("1��°");
		for(int i=0;i<10;i++){
			System.out.println("thread�� ���!! : " + i);
		}
	}
	
	
	
}
