public class RecursionChallenge {
	public static int numOfDigits(int num){
		if (num / 10 == 0) 
			return 1; 
		return 1+numOfDigits(num / 10); 
	} 
	public static int countChar(String a, char b) {
		if(a.indexOf(b) != -1){          
			return  countChar(a.substring(0, a.indexOf(b)), b)+ countChar(a.substring(a.indexOf(b)+1),b) + 1;
		}else {
			return 0;
		}
	}
	public static int addDigits(int num){
		if (num == 0) 
			return 0; 
		return (num % 10 + addDigits(num / 10));
	}
}