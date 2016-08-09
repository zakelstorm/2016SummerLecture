package Javathread.conpro;

import java.util.LinkedList;
import java.util.ArrayList;

//공유객체를 만들기 위한 class를 작성
// 객체가 1개만 있으면 된다. (Singleton) 하나의 큐를 여러개의 thread가 사용하기 때문에
public class QueueImpl implements Queue{
	private static QueueImpl queue = new QueueImpl();
	private static final Object monitor = new Object();
	
	//arraylist 는 값을 넣고 값을 참조하기 좋고 LinkedList는 값을 넣고 삭제하기 좋음
	private LinkedList<String> list = new LinkedList<String>(); 
	
	private QueueImpl(){ // 외부에서 못만들게 하기위해 private로 지정 내부에서만 만들 수 있다.
		
	}
	
	public static Queue getInstance(){ //상위타입으로 한 이유는 클래스 이름 안박히게 하려고
		return queue;
	}
/*singleton 설정 방법*/
	@Override
	public void put(String num) {
		// TODO Auto-generated method stub
		synchronized (monitor) {
			list.addLast(num);
			monitor.notify();//값을 넣어놨으니 대기그만하고 누가 일좀 해라
		}
	}

	@Override
	public String get() {
		String result = null;
		synchronized (monitor) {
			if(list.isEmpty()){ // list가 비어있으면
				try {
					monitor.wait(); // 난 이 모니터로 할것이 없으니 난 물러날테니 누가 아무나 들고가라
				} catch (Exception e) {
					// TODO: handle exception
				}
			}else{
				result = list.removeFirst();
				
			}
		}
		
		return result;
	}
	

	
	
}
