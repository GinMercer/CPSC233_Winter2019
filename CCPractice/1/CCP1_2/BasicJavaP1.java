class BasicJavaP1 {
	public static long floor(double num) {
		return (int) num;
	}
	public static double conversion(double fahr){
		return (fahr-32)/9*5;
	}
	public static boolean willRoundUp(double num){
		int num1= (int)num;
		return (num-num1)>=0.5;
	}
	public static int sumRange(int start, int end){
		int sum=0;
		if (start<end) {
			for(int a=start; a<end;a++){
				sum=a+sum;
			}
		}else{
			for(int a=start; a>end;a--){
				sum=a+sum;
			}
		}
		return sum;
	}
	public static int countChar(String str, char c){
		int count=0;
		for (int i = 0; i < str.length(); i++){
			if(str.charAt(i)==c)
				count++;
		}
		return count;
	}
	public static int addDigits(int num){
		int sum=0;
		int num1=num;
		while(num1>0){
			sum=num1%10+sum;
			num1=num1/10;
		}
		return sum;
	}
}