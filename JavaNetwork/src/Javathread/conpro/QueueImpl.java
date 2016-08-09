package Javathread.conpro;

import java.util.LinkedList;
import java.util.ArrayList;

//������ü�� ����� ���� class�� �ۼ�
// ��ü�� 1���� ������ �ȴ�. (Singleton) �ϳ��� ť�� �������� thread�� ����ϱ� ������
public class QueueImpl implements Queue{
	private static QueueImpl queue = new QueueImpl();
	private static final Object monitor = new Object();
	
	//arraylist �� ���� �ְ� ���� �����ϱ� ���� LinkedList�� ���� �ְ� �����ϱ� ����
	private LinkedList<String> list = new LinkedList<String>(); 
	
	private QueueImpl(){ // �ܺο��� ������� �ϱ����� private�� ���� ���ο����� ���� �� �ִ�.
		
	}
	
	public static Queue getInstance(){ //����Ÿ������ �� ������ Ŭ���� �̸� �ȹ����� �Ϸ���
		return queue;
	}
/*singleton ���� ���*/
	@Override
	public void put(String num) {
		// TODO Auto-generated method stub
		synchronized (monitor) {
			list.addLast(num);
			monitor.notify();//���� �־������ ���׸��ϰ� ���� ���� �ض�
		}
	}

	@Override
	public String get() {
		String result = null;
		synchronized (monitor) {
			if(list.isEmpty()){ // list�� ���������
				try {
					monitor.wait(); // �� �� ����ͷ� �Ұ��� ������ �� �������״� ���� �ƹ��� �����
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
