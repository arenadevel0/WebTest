package resear.thread.threading.callableAPI.general;

import java.util.concurrent.Callable;

public class FactorialCalcNoSleep implements Callable<Integer> {

	private Integer digit;
	
	
	public FactorialCalcNoSleep() {
		super();
	}

	public FactorialCalcNoSleep(Integer digit) {
		super();
		this.digit = digit;
	}

	private int doCalculate(int digit) {
		return (digit==1)?1:(digit*(doCalculate(digit-1)));
	}

	@Override
	public Integer call() throws Exception {
		int res = doCalculate(digit);
		System.out.println("Result of digit:"+digit+" ->"+res);
		return res;
	}

}
