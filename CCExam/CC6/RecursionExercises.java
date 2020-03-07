import java.util.*;

public class RecursionExercises{
	public static double fractionSum(int n){
		if(n <= 0)
			return 0.0;
		if(n == 1){
			return 1.0;
		}else{
			return (double)1/n + fractionSum(n-1);
		}
	}
	public int sum1(int n){
		if(n < 0){
			return 0;
		}
		else{
			boolean odd = n % 2 == 1;
			if (odd){
			return n+sum1(n-1);
			}
			else{
				return sum1(n-1);
			}
		}
	}
	public int sum2(ArrayList<Integer> list){
		if (list == null || list.size() == 0){
			return 0;
		}
		else{
			int n = list.get(0);
			if(n % 2 == 0){
				list.remove(0);
				return sum2(list);
			}else{
				list.remove(0);
				return n + sum2(list);
			}
		}	
	}
	public String getVowels(String str){
		if (str == null || str.length() == 0) {
			return str;
		}
		else if(str.charAt(0)== 'a'|| str.charAt(0) == 'i' || str.charAt(0) == 'e' || str.charAt(0) == 'o' || str.charAt(0) == 'u'|| str.charAt(0)=='A' || str.charAt(0)=='I'|| str.charAt(0)=='E' || str.charAt(0)== 'O' || str.charAt(0)=='U' 
		|| str.charAt(0)=='y'|| str.charAt(0)=='Y')
			{
				return str.charAt(0)+ getVowels(str.substring(1));
		}else {
			return getVowels(str.substring(1));
		}
	}
}