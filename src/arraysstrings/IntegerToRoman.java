package arraysstrings;

public class IntegerToRoman {
	
	public static void main(String[] args) {
		System.out.println(intToRoman(3549));
	}
	
	 public static String intToRoman(int num) {
		 StringBuilder builder = new StringBuilder();
		 if (num <= 0)
			 return builder.toString();
		 while (num > 0) {
			 int i = 0, count = 0;
			 if (num >= 1000) {
				 count = num / 1000;
				 i = 0;
				 while (i < count) {
					 builder.append("M");
					 i++;
				 }
				 num = num % 1000;
			 } else if (num >= 500) {
				 if (num < 900) {
					 count = num /500;
					 while (i < count) {
						 builder.append("D");
						 i++;
					 }
					 num = num % 500;
				 } else {
					 builder.append("CM");
					 num = num % 100;
				 }
			 } else if (num >= 100) {
				 if (num < 400) {
					 count = num / 100;
					 while (i < count) {
						 builder.append("C");
						 i++;
					 }
					 num = num % 100;
				 } else {
					 builder.append("CD");
					 num = num % 100;
				 }
			 } else if (num >= 50) {
				 if (num < 90) {
					 count = num / 50;
					 while(i < count) {
						 builder.append("L");
						 i++;
					 }
					 num = num % 50;
				 } else {
					 builder.append("XC");
					 num = num % 10;
				 }
			 } else if (num >= 10) {
				 if (num < 40) {
					 count = num /10;
					 while (i < count) {
						 builder.append("X");
						 i++;
					 }
					 num = num % 10;
				 } else {
					 builder.append("XL");
					 num = num % 10;
				 }
			 }  else if (num >= 5) { 
		         if (num < 9) { 
		             count = num / 5;
		             while (i < count) {
		            	 	builder.append("V");
		            	 	i++;
		             }
		             num = num % 5; 
		         } else { 
		             builder.append("IX"); 
		             num = 0; 
		         } 
		     } else if (num >= 1) { 
		         if (num < 4) {
		        	 	count = num;
		        	 	while (i < count) {
		        	 		builder.append("I");
		        	 		i++;
		        	 	}
		             num = 0; 
		         } else { 
		             builder.append("IV");
		             num = 0; 
		         } 
		     } 
		 }
		 return builder.toString();
	 }
}
