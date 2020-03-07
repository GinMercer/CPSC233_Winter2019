class Expressions2 {
	public static boolean isLower(char aChar) {
		return aChar>='a' && aChar<='z';
	}
	public static double computePolynomial(double x) {
		double polynomial=2*x*x*x+3*(7-x)*(7-x)-100;
		return polynomial;	
		}
	public static double division(int num1,int num2) {
		double num3= (double) num1/num2;
		return num3;	
		}
	public static String convertToString(int fiveDigitNum) {
		String str="";
		str=fiveDigitNum%10+str;
		str=fiveDigitNum/10%10+str;
		str=fiveDigitNum/10/10%10+str;
		str=fiveDigitNum/10/10/10%10+str;
		str=fiveDigitNum/10/10/10/10%10+str;
		return str;
		}		
}