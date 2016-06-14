package arraysstrings;

/**
 * Check for character duplication in a string using bit- vector 
 * 
 * Time complexity -  O(n) | Space complexity - O(1)
 * 
 * In case of string containing all the characters, larger bit vectors need to be used
 * 
 * @author aarish-1867
 *
 */
public class CharacterDuplicateChecker {
	public static void main(String[] args) {
		String input = args[0];
		String type = args[1];
		int vector = 0;	
		boolean dupNotPresent = true;
		if (input != null && !input.isEmpty() && type != null && !type.isEmpty() && type.equals("ascii")) {
		    input = input.toLowerCase();
			for (int i=0; i< input.length(); i++) {
				char character = input.charAt(i);
				int val = character - 'a';
				if ((vector & (1 << val)) > 0) {
					System.out.println("Character '" + character + "' is duplicated!!");			
					dupNotPresent = false;
					break;
				}
				vector |= (1 << val);
			}
		if (dupNotPresent) {
			System.out.println("" + input + " does not contain any duplicate characters!!");
		}
		}
	}
}
