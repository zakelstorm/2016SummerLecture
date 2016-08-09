package Javathread;


public class SharedObject5 {
	
	private String name;
	private Object monitor = new Object(); //이것을 획득하는 thread만이 실행될 수 있다.
	private static SharedObject5 sharedObject= new SharedObject5();
	
	// 싱글톤으로 만들기위해서 생성자를 private로 잡음 클래스로부터 instance를 딱 하나만 만들수 있도록 private로
	private SharedObject5() {
		
	}
	
	// 해당 클래스의 instance를 리턴시켜주는 method
	public static SharedObject5 getInstance(){
		return sharedObject;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		synchronized(monitor){ // 동기화 하겠다는 의미 (두개의 thread가 동시에 실행시키는데 하나씩 실행시키는것이다)			
										 // monitor를 선점하는 thread가 실행되고 그렇지 못한 thread는 block됨(순차처리)
			this.name = name;
			try {
				monitor.wait(); //monitor을 놓는다. (원래 끝나면 자동적으로 놓는데 이 코드를 통해 의도적으로 놓음)
				monitor.notify(); // wait을 통해 monitor을 놨다는것을 알아차릴수 있도록 알려주는 역할
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		} // 여기까지 수행되면 monitor을 자동적으로 포기한다.
		
	}
	public Object getMonitor() {
		return monitor;
	}
	public void setMonitor(Object monitor) {
		this.monitor = monitor;
	}
	
	
}
