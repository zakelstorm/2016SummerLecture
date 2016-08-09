package Javathread;

public class SynchroMain5 {
	public static void main(String[] args) {
		SharedObject5 object = SharedObject5.getInstance(); // ������ü
		
		Thread t1 = new Thread(new MySynchro(object));
		Thread t2 = new Thread(new MySynchro(object));
		
		t1.start();
		t2.start(); // �ð������� ���� ���ÿ� run method�� ����ǰ� �ȴ�.
		
	}
}


class MySynchro implements Runnable{
	SharedObject5 object;
	public MySynchro(SharedObject5 object) {
		this.object = object;
	}

	@Override
	public void run() {
		object.setName("�ֱ浿"); //2���� thread�� object�� name�� �ֱ浿���� �ٲٷ��Ѵ�.
		
	}
}