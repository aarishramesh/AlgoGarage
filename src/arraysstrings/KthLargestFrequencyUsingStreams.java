package arraysstrings;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthLargestFrequencyUsingStreams {
	 public static void main(String[] args) {
	      //prints b
	      System.out.println(kthMostFrequentChar("aaabbbcccd",10));
	      //prints b
	      System.out.println(kthMostFrequentChar("aaabbacccbbbd",1));
	      //prints e
	      System.out.println(kthMostFrequentChar("aaabbbcccdddeee",5));

	    }

	    private static Character kthMostFrequentChar(final String string, final int kth) {
	      Map<Integer, Long> counts = string.chars()
	          .boxed()
	          .collect(Collectors.groupingBy(
	              Function.identity(),
	              Collectors.counting()
	          ));
	      return counts.entrySet()
	          .stream()
	          .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	          .map(e->(char)e.getKey().intValue())
	          .limit(kth)
	          .reduce((l,r)->r)
	          .orElseThrow(IllegalArgumentException::new);
	    }
}
