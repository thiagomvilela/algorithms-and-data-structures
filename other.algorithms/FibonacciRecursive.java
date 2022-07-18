
public class FibonacciRecursive {

	public static int fib(int n) {
		if (n < 2) {
			return n; 
		}
		
		return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fib(50));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
}
