package challenges.arraysAndStrings;

public class IsPermutation {

	public IsPermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void test() {
		String isPerm1 = "abc";
		String isPerm2 = "bcd";
		boolean result = isPermutation(isPerm1, isPerm2);
		System.out.println("2. isPermutation(" + isPerm1 + ", " + isPerm2 + "): " + result);
	}

	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		int bucket1[] = new int[95];
		int bucket2[] = new int[95];
		int index;
		for (char c: s1.toCharArray()) {
			index = c - ' ' - 1;
			if (index < 0 || index >= 95) {
				return false;
			}
			++bucket1[index];
		}
		
		for (char c: s2.toCharArray()) {
			index = c - ' ' - 1;
			if (index < 0 || index >= 95) {
				return false;
			}
			if (++bucket2[index] > bucket1[index]) {
				return false;
			}
		}
		
		for (int i=0; i<bucket1.length; ++i) {
			if (bucket1[i] != bucket2[i]) {
				return false;
			}
		}

		return true;
	}
}
