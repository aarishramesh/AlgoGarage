package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 * 
 * @author polymath
 *
 */
public class InfixExprToPostFixConversion {
	public static void main(String[] args) {
		String expr = "A + B * C";
		char[] exprChar = expr.toCharArray();
		Stack<Character> opsStack = new Stack<Character>();
		List<Character> postFixExprList = new ArrayList<Character>();
		for (Character operand : exprChar) {
			if (operand.equals(' '))
				continue;
			if (operand.equals('(')) {
				opsStack.add(operand);
				continue;
			}
			if (operand.equals('A') || operand.equals('B') || operand.equals('C')) {
				postFixExprList.add(operand);
				continue;
			}
			if (operand.equals('+') || operand.equals('-') || operand.equals('*')
					|| operand.equals('/')) {
				if (opsStack.isEmpty()) {
					opsStack.add(operand);
				} else {
					while (!opsStack.isEmpty() && isOperand(opsStack.get(0)) && (OperandWeight.getWeight(opsStack.get(0)) >= OperandWeight.getWeight(operand))) {
						postFixExprList.add(opsStack.pop());
					}
					opsStack.add(operand);
				}
				continue;
			}
			if (operand.equals(')')) {
				while (opsStack.get(0) != '(') {
					postFixExprList.add(opsStack.pop());
				}
				opsStack.pop();
			}
		}
		
		while (!opsStack.isEmpty()) {
			postFixExprList.add(opsStack.pop());
		}
		
		System.out.println(postFixExprList.toString());
	}

	private static boolean isOperand(char ch) {
		if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return true;
		return false;
	}

	public static enum OperandWeight {
		Plus('+', 1), Minus('-', 1), Multiply('*', 2), Divide('/', 2);

		char operand;
		int weight;

		private OperandWeight(char operand, int weight) {
			this.operand = operand;
			this.weight = weight;
		}

		static int getWeight(char ch) {
			if (ch == '+' || ch == '-')
				return 1;
			if (ch == '*' || ch == '/')
				return 2;
			return 0;
		}
	}
}
