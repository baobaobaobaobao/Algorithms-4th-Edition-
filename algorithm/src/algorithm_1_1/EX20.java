package algorithm_1_1;

import edu.princeton.cs.algs4.GaussianElimination;

public class EX20 {

	/* 本函数是为了获取n！ */
	public static int getN(int n) {

		if (n == 0)
			return 1;
		if (n == 1) {
			return n;
		} else {
			return n * getN(n - 1);
		}

	}

	/* 本函数是为了获取n！的幂为10的数。 */
	public static int getln(int n) {
		int count = 0;
		while (n != 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int N = getN(10);
		System.out.println(N);
		System.out.print(getln(N));
	}
}
