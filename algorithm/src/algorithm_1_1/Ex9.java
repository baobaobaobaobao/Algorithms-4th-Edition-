package algorithm_1_1;

/*1.1.9����һ���������ö����Ʊ�ʾ��Ȼ��ת��ΪString����ֵ*/
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
