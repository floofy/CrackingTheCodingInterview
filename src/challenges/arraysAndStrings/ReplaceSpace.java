/*
 * Replaces all spaces in a string with %20 (except for leading and trailing
 * spaces).
 */
package challenges.arraysAndStrings;

public class ReplaceSpace {

	public static void test() {
		String replaceSpaces = "  the world  is quite beautiful     ";
		System.out.println("3. replaceSpace(\"" 
						   + replaceSpaces
						   + "\")" + ": "
						   + replaceSpace(replaceSpaces) + ".");
	}
	
	/*
	 * Does same thing as String.trim(). This was made for practice.
	 */
	public static String trimString(String s) {
		int leftIndex = 0;
		int rightIndex = 0;
		char[] sArray = s.toCharArray();
		StringBuilder builderString = new StringBuilder();
		
		for (int i=0; i<s.length(); ++i) {
			if (sArray[i] != ' ') {
				leftIndex = i;
				break;
			} else if (i == s.length()-1) {
				leftIndex = s.length();	// String is all spaces, don't add any
			}
		}
		
		for (int i=leftIndex; i<s.length(); ++i)
			builderString.append(sArray[i]);
	
		for (int i=builderString.length()-1; i>=0; --i) {
			if (builderString.charAt(i) != ' ') {
				rightIndex = i;
				break;
			}
		}
		
		if (rightIndex != 0) {
			builderString.delete(rightIndex+1, builderString.length()-1);
		}
		return new String(builderString);
	}
	
	/*
	 * Using my own implementation of .trim() and .replace() methods.
	 */
	public static String replaceSpace(String s) {
		char[] sArray = trimString(s).toCharArray();
		char[] newString;
		int newStringIndex;
		int spaces;

		spaces = 0;
		for (int i=0; i<sArray.length; ++i) {
			if (sArray[i] == ' ') {
				++spaces;
			}
		}

		if (spaces > 0 ) {
			newStringIndex = 0;
			newString = new char[sArray.length + (spaces*3)];
			for (int i=0; i<sArray.length; ++i) {
				if (sArray[i] == ' ') {
					newString[newStringIndex] = '%';
					newString[++newStringIndex] = '2';
					newString[++newStringIndex] = '0';
				} else {
					newString[newStringIndex] = sArray[i];
				}
				++newStringIndex;
			}
		} else {
			newString = sArray;
		}

		return new String(newString);
	}
	
	/*
	 * Easy version.
	 */
	public static String replaceSpace2(String s) {
		s = s.trim();
		s = s.replace(" ", "%20");
		return s;
	}
	
}
