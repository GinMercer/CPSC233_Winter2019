public class BasicJava8 {
	public static String formatDate(String date) {
		String data=new String();
		date=date.replace(" ", "");
		date=date.replace("/", ".");
		char[] c = new char[date.length()];
		date.getChars(3,6, c, 0);
		date.getChars(0,3, c, 3);
		date.getChars(6,8, c, 6);
		date = String.valueOf(c);
		
		
		return date;
	}
	
	public static boolean isPrime(int a){
		boolean result=false;
		if(a==2||a==1){
			result=true;
		}
		if(a>2){
			for (int i=2;i<a;i++){
				if(a%i==0){
					result=false;
					break;
				}else{
					result=true;
				}
			}
		}
		return result;
	}
	
	public static double power(float x, int n){
		double pow=x;
		if(n==0){
			pow=1;
		}else if(n>0){
			for(int i=1;i<n;i++){
				pow=pow*x;
			}
		}else{
			for(int i=-1;i>n;i--){
				pow=pow*x;
			}
			pow=1/pow;
		}
		return pow;
	}
	
	public static int round(double num){
		int num1= (int)num;
		if((num-num1)>=0.5){
			num1=num1+1;
		}else{
			num1=num1;
		}
		return num1;
	}
}