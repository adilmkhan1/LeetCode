package May2020_Challenge;

public class ValidPerfectSquare {
	
	
	public static boolean isPerfectSquare(int num)
	{
		
		if (num < 2)
			return true;
		
		for (int i = 2; i <= num/2; i++) 
		{
			int curr = i*i;
			
			if (curr == num)
			{
				return true;
			}
		}
		
		
		
		return false;
	}

	public static void main(String[] args) {
		
       int num = 16; //true
       
       int num1 = 14; //false
       
       System.out.println(isPerfectSquare(4));
       
		

	}

}
