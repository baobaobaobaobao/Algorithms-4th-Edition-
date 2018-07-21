/**
 * 
 */
package algorithm_1_1;

/**
 * @author Administrator
 *找出三个数，并排序
 */
public class EX26 {
	public static void compare(int a, int b, int c) {
		
		
		int t;
		if (a > b) {
			t = a;
			a = b;
			b = t;
		}

		if (a > c) {
			t = a;
			a = c;
			c = t;
		}
		if (b > c) {
			t = b;
			b = c;
			c = t;
		}
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	}
	
	
	public static void main(String[] args) {
		int number1 = 100, number2 = 99, number3 = 45;
		compare(number1, number2, number3);
	}
}
