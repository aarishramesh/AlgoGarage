package general;

import java.util.ArrayList;
import java.util.List;

public class SublistProblem {
	public static void main(String[] args) {
		List<String> A = new ArrayList<String>();
		A.add("A"); A.add("B"); A.add("C");
		List<String> B = new ArrayList<String>();
		B.add("A"); B.add("B"); B.add("C"); B.add("D");
		System.out.println(B.containsAll(A));
	}
}
