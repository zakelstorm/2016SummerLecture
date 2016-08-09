package Javathread.conpro;

public class Consumer implements Runnable{
	private Queue queue;
	private String name;
	
	public Consumer(Queue queue,String name){
		this.queue = queue;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name  +" : " +"consumer 실행");
		try {
			while(!Thread.currentThread().isInterrupted()){
				System.out.println(name +" : " +queue.get());
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			System.out.println(name  +" : " +"consumer 종료");
		}
	}
}
