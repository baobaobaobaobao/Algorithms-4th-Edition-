package algorithm_1_1;

/*实现二维数组反转*/
public class EX13 {
	public static void main(String[] args) {

		int[][] arr = { { 22, 15, 32, 20, 18 }, { 12, 21, 25, 19, 33 }, { 14, 58, 34, 24, 66 }, };
		int i = 2;
		int j = 4;
		
		/*转换*/
		for (int k = 0; k < i; k++)
			for (int h = 0; h < j; h++) {
				int temp = arr[k][h];
				arr[k][h] = arr[i - k][j - h];
				arr[i - 1][j - 1] = temp;
			}
		
		for(int t=0;t<3;t++)
			for(int m=0;m<5;m++) {
				System.out.println((arr[t][m]));
			}
		

	}
}
