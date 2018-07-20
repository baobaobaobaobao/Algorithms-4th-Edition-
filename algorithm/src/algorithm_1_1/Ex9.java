package algorithm_1_1;

/*1.1.9输入一个正整数用二进制表示，然后转换为String类型值*/
public class Ex9 {

	public static void main(String[] args) {
		int N = 21;
		String s = "";
		for (int n = N; n > 0; n /= 2) {
			s = (n % 2) + s;
		}
		System.out.print(s);
	}
}
