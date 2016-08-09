package Javathread;

public class SynchroMain5 {
	public static void main(String[] args) {
		SharedObject5 object = SharedObject5.getInstance(); // 공유객체
		
		Thread t1 = new Thread(new MySynchro(object));
		Thread t2 = new Thread(new MySynchro(object));
		
		t1.start();
		t2.start(); // 시간적으로 거의 동시에 run method가 실행되게 된다.
		
	}
}


class MySynchro implements Runnable{
	SharedObject5 object;
	public MySynchro(SharedObject5 object) {
		this.object = object;
	}

	@Override
	public void run() {
		object.setName("최길동"); //2개의 thread가 object의 name을 최길동으로 바꾸려한다.
		
	}
}