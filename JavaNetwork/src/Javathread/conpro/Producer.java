package Javathread.conpro;

public class Producer implements Runnable{

	private Queue queue;
	
	public Producer(Queue queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		System.out.println("Producer ����!!");
		try {
			//thread�� ���Ḧ ���ؼ� ó��
			while(!Thread.currentThread().isInterrupted()){
				queue.put((new Integer(i)).toString());
				++i;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally{
			System.out.println("Producer ����!");
		}
		
		
	}
}
