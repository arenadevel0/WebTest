package resear.logger.prac.timed;


public class LogProp {

	//from user
	private int timeLimit;

	//System.env
	private int fileSize;
	
	private static LogProp logPropObj;
	
	private LogProp(){
		
	}
	
	public static LogProp getLogPropObj(){
		if(logPropObj==null){
			synchronized (LogProp.class) {
				if(logPropObj==null){
					logPropObj = new LogProp();
				}
			}
		}
		return logPropObj;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getFileSize() {
		return fileSize;
	}

	//random time limit makes the fileSize
	public void setFileSize(int fileSize) {
		if(!(timeLimit>=5 && timeLimit<=20))
			timeLimit=5;
		this.fileSize=fileSize-(timeLimit*1024);
	}
	
	//file size is reduced by fix of 5kb
	public void setFileSize(int fileSize, boolean last5Mins) {
		if(!last5Mins)
			setFileSize(fileSize);
		else
			this.fileSize=fileSize-(5*1024);
	}
	
	//file size is reduced by fix of 10 kb
	public void setFileSizeConst(int fileSize){
		this.fileSize = fileSize - ((fileSize*10)/100);
	}
}
