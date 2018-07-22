/**
 * 
 */
package algorithm_1_3;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author Administrator
 *
 */
public class EX10 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			switch (s) {
			case "+":
			case "-":
			case "*":
			case "/":
				stack.push(s);
				break;
			case "(":
				break;
			case ")":
				System.out.print(stack.pop() + " ");
				break;
			default:
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
}
