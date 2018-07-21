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
		for (int i = 0; i < b.length; i++) {
			if (b[i] == b[i + 1]) {
				b[j++] = b[i];
			}

		}
		System.out.println(b);
		return b;
	}

	/* 快排算法 */
	private static void quickSort(int[] a) {
		if (a.length > 0) {
			quickSort(a, 0, a.length - 1);
		}
		System.out.println(a);
	}

	/*
	 * 递归实现
	 */
	private static void quickSort(int[] a, int low, int high) {
		if (low > high) {
			return;
		}
		int i = low;
		int j = high;
		int key = a[low];
		while (i < j) {
			// 4.1 ，从右往左找到第一个小于key的数
			while (i < j && a[j] <= key) {
				j--;
			}
			// 4.2 从左往右找到第一个大于key的数
			while (i < j && a[i] <= key) {
				i++;
			}
			// 4.3 交换
			if (i < j) {
				int p = a[i];
				a[i] = a[j];
				a[j] = p;
			}
		}
		  // 4.4，调整key的位置  
        int p = a[i];  
        a[i] = a[low];  
        a[low] = p;  
        //5, 对key左边的数快排  
        quickSort(a, low, i-1 );  
        //6, 对key右边的数快排  
        quickSort(a, i+1, high);  
	}

	public static void main(String[] args) {
		// 首先给数组排序，我们用快排好吧
		int[] b = { 7, 1, 5, 1, 9};
		quickSort(b,0,b.length-1);
		System.
		//System.out.println(deletRepeat(b));

	}
}
