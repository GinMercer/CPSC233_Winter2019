public class Vowels {
	public static int numOfVowels(String s){
		if (s.length() == 0 || s == null) {
			return 0;
		} else if (s.charAt(0) == 'a' || s.charAt(0) == 'i' || s.charAt(0) == 'e' || s.charAt(0) == 'o' || s.charAt(0) == 'u') {
			return 1 + numOfVowels(s.substring(1));
		} else {
			return numOfVowels(s.substring(1));
		}
	}
}

