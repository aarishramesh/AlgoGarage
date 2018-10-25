package backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesis {

	static ArrayList<String> parenthesis = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3).toString());
	}

	public static ArrayList<String> generateParenthesis(int A) {
		generateParenthesisInternal(A - 1, A	, "(");
		return parenthesis;
	}

	static void generateParenthesisInternal(int openBraces, int closedBraces, String parenthesisStr) {
		
		if (openBraces < 0 || closedBraces < 0)
			return;
		
		if (openBraces == 0 && closedBraces == 0 && parenthesisStr.charAt(parenthesisStr.length() - 1) == ')') {
			parenthesis.add(parenthesisStr);
			return;
		} 

		generateParenthesisInternal(openBraces - 1, closedBraces, parenthesisStr + "(");
		if (openBraces < closedBraces)
			generateParenthesisInternal(openBraces, closedBraces - 1, parenthesisStr + ")");
	}
}
