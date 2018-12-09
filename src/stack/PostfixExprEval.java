package stack;

import java.util.Stack;

/**
 * Post fix expression evaluation using stack
 * 
 * Assumes the given post fix expression is valid
 * 
 * Runtime complexity - O(N)
 * 
 * Spacetime complexity - O(N) for additional stack
 * 
 * @author polymath
 *
 */
public class PostfixExprEval {
	public static void main(String[] args) {
		//String[] exprArr = {"9", "20", "20", "/", "*"};
		
	}

	public static float evaluate(String expr) {
		String[] exprArr = expr.split(" ");
		Stack<String> operStack = new Stack<String>();
		for (String val : exprArr) {			
			if (isFloat(val)) {
				operStack.add(val + "");
			} else {
				float num2 = Float.parseFloat(operStack.pop());
				float num1 = Float.parseFloat(operStack.pop());
				operStack.add((eval(num1, num2, val.charAt(0))) + "");
			}
		}
		return Float.parseFloat(operStack.get(0));
	}
	
	private static float eval(float num1, float num2, char operator) {
		if (operator == '+')
			return num1 + num2;
		if (operator == '-')
			return num1 - num2;
		if (operator == '*')
			return num1 * num2;
		if (operator == '/')
			return num1 / num2;
		return 0;
	}

	private static boolean isFloat(String val) {
		try {
			Float.parseFloat(val);
			return true;
		} catch (Exception ex) {

		}
		return false;
	}
}
