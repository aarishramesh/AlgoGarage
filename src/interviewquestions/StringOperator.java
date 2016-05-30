public class StringOperator {
	public static void main(String[] args) {
		System.out.println("Enter any of the following Option" 
			+ "\n 1 - Replace space with %20 in input string"
			+ "\n 2 - String compression with character count");
		String option = args[0];
		if (option != null && !option.isEmpty()) { 
			String input = "aaaqbbbb";
			int spaceCount = 0;

			if (input != null && !input.isEmpty()) {

				int opt = Integer.parseInt(option);
				if (opt == 1) {
					
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) == ' ') {
						spaceCount++;
					}
					if (input.length() <= (input.length() - spaceCount + (spaceCount * 3))) {
						System.out.println("Not enough characters in the string so exiting");
						return;
					}
				}
					replaceSpacesInString(convertStringToCharArray(input));
				} else {
					compressString(convertStringToCharArray(input));
				}
			}
		}
	}
	
	static void replaceSpacesInString(char[] input) {
		int charIndex = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] != ' ') {
				charIndex = i;
				break;
			}
		}
		if (charIndex == input.length) {
			System.out.println("No extra spaces in the string to accomodate space characters!!");
			return;
		}
		int i = charIndex; int j = input.length - 1;
		for (; i >= 0; i--) {
			if (input[i] != ' ') {
				input[j] = input[i];
				j--;
			} else {
				input[j] = '0';
				input[j-1] = '2';
				input[j-2] = '%';
				j-=3;
			}
		}
		System.out.println("Resultant String with spaces replaced :: " + convertCharArrayToString(input));
	}

	static char[] convertStringToCharArray(String input) {
		char[] resultArr = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			resultArr[i] = input.charAt(i);
		}
		return resultArr;
	}

	static String convertCharArrayToString(char[] input) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			buff.append(input[i]);
		}
		return buff.toString();
	}

	static void compressString(char[] input) {
		char newChar = input[0];
		int currCharCount = 1; int j = 0;
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			if (i +1 < input.length && input[i+1] == newChar) {
				currCharCount++;
			} else {
				buff.append(newChar); 
				buff.append(currCharCount);
				if (i + 1 < input.length) {
					newChar = input[i+1];
				}
				currCharCount = 1;
			}
		}
		System.out.println("Compressed string :: " + buff.toString());
	}
}
