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
public class EX11 {
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			double result;
			switch (s) {
			case "+":
				result = stack.pop() + stack.pop();
				stack.push(result);
				break;
			case "-":
				result = -stack.pop() + stack.pop();
				stack.push(result);
				break;
			case "*":
				result = stack.pop() * stack.pop();
				stack.push(result);
				break;
			case "/":
				result = 1 / stack.pop() * stack.pop();
				stack.push(result);
				break;
			default:
				stack.push(Double.parseDouble(s));
			}
		}
		System.out.println(stack.pop());
	}
}
