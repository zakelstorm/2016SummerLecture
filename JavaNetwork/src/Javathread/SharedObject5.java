package Javathread;


public class SharedObject5 {
	
	private String name;
	private Object monitor = new Object(); //�̰��� ȹ���ϴ� thread���� ����� �� �ִ�.
	private static SharedObject5 sharedObject= new SharedObject5();
	
	// �̱������� ��������ؼ� �����ڸ� private�� ���� Ŭ�����κ��� instance�� �� �ϳ��� ����� �ֵ��� private��
	private SharedObject5() {
		
	}
	
	// �ش� Ŭ������ instance�� ���Ͻ����ִ� method
	public static SharedObject5 getInstance(){
		return sharedObject;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		synchronized(monitor){ // ����ȭ �ϰڴٴ� �ǹ� (�ΰ��� thread�� ���ÿ� �����Ű�µ� �ϳ��� �����Ű�°��̴�)			
										 // monitor�� �����ϴ� thread�� ����ǰ� �׷��� ���� thread�� block��(����ó��)
			this.name = name;
			try {
				monitor.wait(); //monitor�� ���´�. (���� ������ �ڵ������� ���µ� �� �ڵ带 ���� �ǵ������� ����)
				monitor.notify(); // wait�� ���� monitor�� ���ٴ°��� �˾������� �ֵ��� �˷��ִ� ����
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		} // ������� ����Ǹ� monitor�� �ڵ������� �����Ѵ�.
		
	}
	public Object getMonitor() {
		return monitor;
	}
	public void setMonitor(Object monitor) {
		this.monitor = monitor;
	}
	
	
}
