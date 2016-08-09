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
		System.out.println("Producer 시작!!");
		try {
			//thread의 종료를 위해서 처리
			while(!Thread.currentThread().isInterrupted()){
				queue.put((new Integer(i)).toString());
				++i;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally{
			System.out.println("Producer 종료!");
		}
		
		
	}
}
