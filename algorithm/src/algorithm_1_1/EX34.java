/**
 * 
 */
package algorithm_1_1;

/**
 * @author Administrator
 *
 */
public class EX34 {
	/* 打印最大的那个数 */
	public int getMax(int[] a) {
		int max = a[0];
		for (int i = 0; i <= a.length - 1; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	/* 打印最小的那个数 */

	public int getMin(int[] a) {
		int min = a[0];
		for (int i = 0; i <= a.length - 1; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	/* 打印最小的中位数*/
	public int getmiddle(int[] a){
		int middle=a[0];
		for(int i=0;i<=a.length-1;i++){
			
		}
		return 0;
	}
	
	/*快排进行排序*/
	
	public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }
    
    /*找出第k小的数，k小于100*/
    
	
}
