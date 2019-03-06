package resear.thread.threading.threadAPI.WaitNotifyInterThreadCommunication.ConsumerProducerProblemByWaitNotifyIncomplete;

public class QueueWorker {

	private static final int LIMIT = 2;
	private static QueueWorker queueWorker=null;
	public static final String FULLQUEUEMESSAGE = "Queue is full.";
	public static final String EMPTYQUEUEMESSAGE = "Queue is empty.";
	private String eol = System.lineSeparator();
	
	static String[] queueArr = new String[LIMIT];
	
	private QueueWorker(){
		
	}
	
	public static final QueueWorker getQueueWorkerSingletonObj(){
		if (queueWorker==null) {
			synchronized (QueueWorker.class) {
				queueWorker = new QueueWorker();
			}
		}
		return queueWorker;
	}
	
	public String showQueue(){
		StringBuffer showQueueString = new StringBuffer();
		showQueueString.append(eol+ "Current state of queue:");
		String queueStr = "";
		for(String str: queueArr)
			queueStr+=str+", ";
		queueStr=queueStr.substring(0,queueStr.length()-2);
		showQueueString.append(eol+queueStr);
		queueStr=null;
		return showQueueString.toString();
	}
	
	public void shuffleQueue(){
		for(int i=0; i<LIMIT; i++){
			if(i<LIMIT-1){
				if(queueArr[i]==null){
					queueArr[i]=queueArr[i+1];
					queueArr[i+1]=null;
				}
			}
		}
	}
	
	public String queueRemove(){
		String itemRemoved=null;
		shuffleQueue();
		itemRemoved = queueArr[0];
		queueArr[0]=null;
		shuffleQueue();
		return itemRemoved;
	}
	
	public void queueInsert(String itemInserted){
		shuffleQueue();
		queueArr[indexToInsert()]=itemInserted;
		shuffleQueue();
	}
	
	public int indexToInsert(){
		shuffleQueue();
		for(int i=0; i<LIMIT; i++){
			if(queueArr[i]==null)
				return i;
		}
		return 0;
	}
	
	public boolean isQueueFull(){
		return !(queueArr[LIMIT-1]==(null));
	}
	
	public boolean isQueueEmpty(){
		return queueArr[0]==(null);
	}
	
	public String queueStatus(){
		StringBuffer queueStatus = new StringBuffer();
		queueStatus.append(eol+"size of queue :"+LIMIT);
		queueStatus.append(eol+((isQueueFull())?FULLQUEUEMESSAGE:("empty cells in queue:"+queueEmptyCells())));
		queueStatus.append(eol+(isQueueEmpty()?EMPTYQUEUEMESSAGE:("Filled cells in queue:"+(LIMIT - queueEmptyCells()))));
		return queueStatus.toString();
	}
	
	public int queueEmptyCells(){
		int emptyCells = 0;
		for(int i=0; i<LIMIT; i++){
			if(queueArr[i]==null)
				emptyCells++;
		}
		return emptyCells;
	}
}
