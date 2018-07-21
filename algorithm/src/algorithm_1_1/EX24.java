/**
 * 
 */
package algorithm_1_1;

import javax.print.attribute.ResolutionSyntax;

import edu.princeton.cs.algs4.StaticSETofInts;

/**
 * @author Administrator 计算两个数的最大公约数
 */
public class EX24 {

	public static int euclid(int p, int q) {
		System.out.println("p = " + p + ", q = " + q);
		if (p == 0 || q == 0) {
			return 1;
		}
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (p % q == 0) {
			return q;
		} else {
			return euclid(q, p % q);
		}
	}
	public static void main(String[] args) {
		System.out.println("result: " + euclid(105, 24));
		System.out.println("result: " + euclid(1111111, 1234567));
	}
}
