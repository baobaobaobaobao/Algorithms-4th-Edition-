/**
 * 
 */
package algorithm_1_2;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author Administrator
 *
 */
public class EX6 {
	
	/*就是将123再加一次变成123
	 * 然后判断231是不是123123的子串就行。*/
	public static void main(String[] args) {
		String s="123";
		String t="231";
		if(s.length()==t.length()&&s.concat(s).contains(t)==true){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}
