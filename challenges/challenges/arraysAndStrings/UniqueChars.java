package challenges.arraysAndStrings;

public class UniqueChars {

	public static void test() {
		String unique = "I am fod";
		boolean result = uniqueChars(unique);
		System.out.println("1. uniqueChars(" + unique + "): " + result);
	}
	
	public static boolean uniqueChars(String s) {
		int[] bucket;
		int charIndex;
		
		bucket = new int[25];
		s = s.toLowerCase();
		
		for(int i=0; i<s.length(); i++) {
			charIndex = s.charAt(i) -'a';
			if (charIndex < 0 || charIndex > 26) {
				continue;
			}
			else if (bucket[s.charAt(i)-'a'] != 0) {
				return false;
			}
			++bucket[charIndex];
		}
		
		return true;
	}

}
