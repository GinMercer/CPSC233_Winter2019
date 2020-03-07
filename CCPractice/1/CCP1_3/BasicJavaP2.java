class BasicJavaP2 {
	public static boolean isUpper(char aChar) {
		return aChar>='A'&& aChar<='Z';
	}
	
	public static double computePolynomial(double x){
		return (3-x)*(3-x)+4*(7+x)-9;
	}
	
	public static long floorAfterMult(int num1, double num2){
		return (int)(num1*num2);
	}
	//Return true if str contains all the characters in the string chars and false otherwise. For example, if str is ‘Hello’ and chars is ‘eo’ then containsAllChars should return true but if str is ‘Hello ‘and chars is ‘eoa’ then containsAllChars should return false.
	public static boolean containsAllChars(String str, String chars){
		if(str==null) {
			return false;
		}
		if(chars==null) {
			return false;
		}
		char[] charsChars=chars.toCharArray();
		boolean flag=true;
		for(char c:charsChars) {
			if(!str.contains(c+"")) {
				flag=false;
			break;
			}
		}
		return flag;
	}
}