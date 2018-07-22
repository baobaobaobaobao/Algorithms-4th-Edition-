/**
 * 
 */
package algorithm_1_1;

/**
 * @author Administrator 删除一个数组中重复元素
 */
public class EX28 {
	/* 给一个顺序的数组去重 */
	public static int[] deletRepeat(int[] b) {

		int j = 0;
		int[] a = new int[10];
		for (int i = 0; i < b.length - 1; i++) {
			for (int k = i + 1; k < b.length - 1; k++) {

				if (b[i] != b[k]) {
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 6, 6, 7 };
		// System.out.println(b);
		int[] b = deletRepeat(a);

		for (int i = 0; i <= b.length - 1; i++) {
			System.out.println(b[i]);
		}
	}
}
