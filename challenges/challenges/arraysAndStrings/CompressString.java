package challenges.arraysAndStrings;

public class CompressString {

	public static void test() {
		String compress = "abcdefghijkkkkkkkkkkkkkkkkkl";
		String tmp;
		
		tmp = compressString(compress);
		System.out.println("4. compressString(\"" + compress + "\")" + ": " + tmp);
	}

	public static String compressString(String s) {
		if (s.length() < 1) {
			return s;
		}
		int orig_length = s.length();
		StringBuilder comp_string = new StringBuilder();
		int count = 1;
		for (int i=1; i<orig_length-1; ++i) {
			if (s.charAt(i) == s.charAt(i+1)) {
				++count;
			} else {
				comp_string.append(s.charAt(i));
				comp_string.append((char)count+0);
				count = 1;
			}
		}
		comp_string.append(s.charAt(orig_length-1));		
		comp_string.append((char)count+0);

		if (comp_string.length() < orig_length) {
			return comp_string.toString();
		}

		return s;

	}
}
