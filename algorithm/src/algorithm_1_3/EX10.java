/**
 * 
 */
package algorithm_1_3;

import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author Administrator
 *����ת������ʽ
 */
public class EX10 {
	private static Scanner sc;
	// �����ջ��Ԫ��
	private static Operator topOperator = new Operator();
 
	public static void main(String[] args) {
		System.out.println("��������ʽ(�Կո�ָ�������1 + 2 * 3 + ( 4 * 5 + 6 ) * 7");
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		// ת��Ϊ��׺���ʽ
		Scalculation1(input);
	}
 
	/**
	 * ��׺���ʽת��Ϊ��׺���ʽ
	 * 
	 * @param input
	 */
	private static void Scalculation1(String input) {
		// �õ�����ı��ʽ��������������
		String[] expression = input.split(" ");
 
		@SuppressWarnings("rawtypes")
		MyStack<?> outputStack = new MyStack(); // ���ջ
 
		@SuppressWarnings("rawtypes")
		MyStack<?> operatorStack = new MyStack(); // �����ջ
 
		// ���棨��λ��
		int leftBracketsPosition = -1;
		// �����ջԪ��λ�ã��ӵ���������Ϊ0,1,2...��
		int osCount = -1;
		// ����ջ�����µ�һ��Ԫ��
 
		System.out.println("����ı��ʽ����" + expression.length);
 
		// ��׺ת��Ϊ��׺
		for (int i = 0; i < expression.length; i++) {
 
			// ���������ֻ��������
			// ���������
			try {
				Integer t = Integer.valueOf(expression[i]);
				outputStack.push(t); // ������������������ջ
 
				// ����������
			} catch (Exception e) {
 
				// �����������Operator
				Operator storageOperator = new Operator();
				// ������������������������ȼ�Ȼ�����������ջ
				switch (expression[i]) {
				case "*":
					storageOperator.setValue("*");
					break;
				case "/":
					storageOperator.setValue("/");
					break;
				case "+":
					storageOperator.setValue("+");
					break;
				case "-":
					storageOperator.setValue("-");
					break;
				case "(":
					storageOperator.setValue("(");
					// ��¼����λ��
					break;
				case ")":
					storageOperator.setValue(")");
					break;
				case "=":
					storageOperator.setValue("=");
				}
 
				// ����ڶ���Ԫ�ز�Ϊ��
				if (osCount != -1) {
					if (storageOperator.value.endsWith("=")) {
						while (osCount != -1) {
							outputStack.push(operatorStack.pop());
							osCount--;
						}
					} else if (storageOperator.value.endsWith("(")) {
						// ���������ջ
						operatorStack.push(storageOperator);
						osCount++;
						leftBracketsPosition = osCount;
						topOperator = (Operator) operatorStack.top();
 
					} else if (storageOperator.value.endsWith(")")) {
						//System.out.println("qqqqqqqqqqqqq: " + osCount);
						while ((osCount != leftBracketsPosition) && (osCount >= 1)) {
							outputStack.push(operatorStack.pop());
							osCount--;
						}
						// �ٰ�(���߳�ȥ
						operatorStack.pop();
						osCount--;
						if (osCount != -1) {
							topOperator = (Operator) operatorStack.top();
						}
 
					} else if ((topOperator.priority >= storageOperator.priority)) {
 
 
						while (((topOperator.priority >= storageOperator.priority))) {
 
							if (topOperator.value.equals("(")) {
								// ���������ջ
								operatorStack.push(storageOperator);
								osCount++;
								topOperator = (Operator) operatorStack.top();
								break;
							} else {
								if (osCount == -1) { // ����Ѿ�û��Ԫ��
									// ���������ջ
									operatorStack.push(storageOperator);
									osCount++;
									topOperator = (Operator) operatorStack.top();
									break;
								} else {
									// ��ջ��Ԫ���������ջ
									outputStack.push(topOperator);
									// ��operator���߳��Ѿ��������ջ��ջ���������µ�ջ��
									operatorStack.pop();
									osCount--;
									if (osCount!=-1) {
										topOperator = (Operator) operatorStack.top();
									} else {
										// ���������ջ
										operatorStack.push(storageOperator);
										osCount++;
										topOperator = (Operator) operatorStack.top();
										break;
									}
								}
							}
						}
					 
 
					} else if ((topOperator.priority <= storageOperator.priority)) {
						// ���������ջ
						operatorStack.push(storageOperator);
						osCount++;
						topOperator = (Operator) operatorStack.top();
 
					}
				} else {
					// ��һ�����������ջ
					operatorStack.push(storageOperator);
					osCount++;
					topOperator = (Operator) operatorStack.top();
 
				}
 
			}
		}
 
		System.out.println("******************���*********************");
		System.out.println("��ӡ���ջ������Ԫ�أ�");
		outputStack.show();
		System.out.println();
		System.out.println("���ջ���ȣ�" + outputStack.count);
 
	}
 
	/**
	 * ����ʵ�ֵļ�ջ
	 * 
	 * @author nangua
	 */
	static class MyStack<T> {
		MyStack() {
		}
 
		Object[] array = new Object[1];;
		// ����Ԫ�ظ���
		int count = 0;
		// ջ��Ԫ��
		Object topOfStack = "-1";
 
		private void show() {
			Object o = new Object();
			for (int i = 0; i < array.length; i++) {
				o = array[i];
				if (o instanceof Operator) {
					Operator ceshi = (Operator) o;
					if ((!ceshi.value.equals("(")) && (!ceshi.value.equals(")"))) {
						System.out.print(" " + ceshi.value);
					}
 
				} else {
					System.out.print(" " + o);
				}
			}
		}
 
		/**
		 * push��ջ
		 * 
		 * @param num
		 */
		private void push(Object num) {
			// �������Ϊ��
			if (count == 0) {
				array[count] = num;
			} else {
				// ������鲻Ϊ�գ���������
				Object[] newarray = new Object[count + 1];
				// ��������
				for (int i = 0; i < array.length; i++) {
					newarray[i] = array[i];
				}
				array = newarray;
				array[count] = num;
			}
			count++;
			topOfStack = num;
		}
 
		/**
		 * �ҳ�ջ������һ��Ԫ��
		 */
		private Object next() {
			// �����Ԫ�ش��ڻ����2��
			if (count - 1 >= 0) {
				return array[count - 1];
			}
			return "��Ԫ�ؿ�next";
		}
 
		/**
		 * ��ջ
		 * 
		 * @return
		 */
		private Object pop() {
			// �������Ϊ��
			if (count == 0) {
				try {
					throw new Exception("ջΪ��ʱ����pop");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "��Ԫ�ؿ�pop";
			} else {
				if (count == 1) {
					topOfStack = array[0];
					count = 0;
				} else {
					topOfStack = array[count - 1];
					// ��С����
					Object[] newarray = new Object[count - 1];
					for (int j = 0; j < newarray.length; j++) {
						newarray[j] = array[j];
					}
					array = newarray;
					count--;
				}
				return topOfStack;
			}
		}
 
		/**
		 * ��ʾջ��Ԫ��
		 */
		private Object top() {
			// �������Ϊ��
			if (count == 0) {
				try {
					throw new Exception("ջΪ��ʱ����top");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "��Ԫ�ؿ�top";
			} else {
				if (count == 1) {
					topOfStack = array[0];
				} else {
					topOfStack = array[count - 1];
				}
				return topOfStack;
			}
		}
 
		/**
		 * ���Է�������ӡջ������ ���˵��ˣ�����������
		 */
 
	}
 
	/**
	 * ������࣬�������ȼ��������
	 * 
	 * @author nangua
	 */
	static class Operator {
		String value;
		// ���ȼ�Ĭ��Ϊ-1
		int priority = -1;
 
		public Operator() {
		}
 
		public String getValue() {
			return value;
		}
 
		public void setValue(String value) {
			this.value = value;
			if (value.equals("+") || (value.equals("-"))) {
				this.priority = 1;
			} else if (value.equals("*") || (value.equals("/"))) {
				this.priority = 2;
			} else if (value.equals("(") || (value.equals(")"))) {
				this.priority = 3;
			} else if (value.equals("=")) {
				this.priority = 0;
			}
		}
 
		public int getPriority() {
			return priority;
		}
 
		public void setPriority(int priority) {
			this.priority = priority;
		}
	}

}
