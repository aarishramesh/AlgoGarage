package backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesis {

	static ArrayList<String> parenthesis = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println(generateParenthesis(4).toString());
	}

	public static ArrayList<String> generateParenthesis(int A) {
		generateParenthesisInternal(A - 1, A	, new StringBuilder("("));
		return parenthesis;
	}

	static void generateParenthesisInternal(int openBraces, int closedBraces, StringBuilder parenthesisStr) {
		
		if (openBraces < 0 || closedBraces < 0)
			return;
		
		if (openBraces == 0 && closedBraces == 0 && parenthesisStr.charAt(parenthesisStr.length() - 1) == ')') {
			parenthesis.add(parenthesisStr.toString());
			return;
		} 

		generateParenthesisInternal(openBraces - 1, closedBraces, parenthesisStr.append("("));
		parenthesisStr.deleteCharAt(parenthesisStr.length() - 1);
		if (openBraces < closedBraces) {
			generateParenthesisInternal(openBraces, closedBraces - 1, parenthesisStr.append(")"));
			parenthesisStr.deleteCharAt(parenthesisStr.length() - 1);
		}
	}
}
