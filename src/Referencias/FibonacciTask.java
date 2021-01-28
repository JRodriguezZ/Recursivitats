package Referencias;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {

	private final int LLINDAR = 10;
	private int Num;
	public FibonacciTask(int n) {
		Num = n;
	}

	public Long fibonacciRecusion(int n){
		//System.out.println("rec" + n);
		if (n <= 1)  return (long) n;
		FibonacciTask f1 = new FibonacciTask(n - 1);
	    f1.fork();
	    FibonacciTask f2 = new FibonacciTask(n - 2);
	    f2.fork();
	    return f2.join() + f1.join();
    }
	
	public Long FibonacciIterative(int n) {
		//System.out.println("ite" + n);
		long prev1=0, prev2=1;
	    for(int i=0; i<n; i++) {
	    	long savePrev1 = prev1;
	        prev1 = prev2;
	        prev2 = savePrev1 + prev2;
	    }
	    return prev1;
}
	
	@Override
	protected Long compute() {
		if(Num < LLINDAR){
			return FibonacciIterative(Num);
		} else {
			return fibonacciRecusion(Num);
		}
	}

}
