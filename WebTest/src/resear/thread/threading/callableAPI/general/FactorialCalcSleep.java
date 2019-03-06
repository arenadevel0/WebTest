package resear.thread.threading.callableAPI.general;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalcSleep implements Callable<Integer> {

	private Integer digit;
	
	public FactorialCalcSleep() {
		super();
	}

	public FactorialCalcSleep(Integer digit) {
		super();
		this.digit = digit;
	}

	private int doCalculate(int digit) throws InterruptedException {
		int result = 1;
        if ((digit == 0) || (digit == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= digit; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        return result;
	}

	@Override
	public Integer call() throws Exception {
		int res = doCalculate(digit);
		System.out.println("Result of digit:"+digit+" ->"+res);
		return res;
	}

}
