

import java.util.HashMap;
import java.util.Map;

public class FibonacciDynamicProgramming{

	static Map<Long,Long> dados = new HashMap<Long,Long>();
	
	public static long fibDP(long n) {
		if (n < 2) {
			dados.put(n, n);
//			System.out.print(n + ", ");
			return n;
		} else {
			long n1 = 0;
			if (dados.get(n - 1) == null) {
				n1 = fibDP(n - 1);
			} else {
				n1 = dados.get(n - 1);
			}
			
			long n2 = 0;
			if (dados.get(n - 2) == null) {
				n2 = fibDP(n - 2);
			} else {
				n2 = dados.get(n - 2);
			}
			
			long fibN = n1 + n2;
//			System.out.print(fibN + ", ");
			dados.put(n, fibN);
			return fibN;
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		fibDP(50);
		System.out.println(System.currentTimeMillis() - start);
	}
	
}
