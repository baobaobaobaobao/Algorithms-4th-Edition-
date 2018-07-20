package algorithm_1_1;


/*給出一個整數，请給出不大于lg2N的最大整数*/
public class Ex14 {

	public static void main(String[] args) {
	   int N=23;
	   int k=0;
	   while(N/2>=1) {
		   k++;
		   N=N/2;   
	   }
	   System.out.print(k);
	}
}
