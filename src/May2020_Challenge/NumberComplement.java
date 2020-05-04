package May2020_Challenge;

public class NumberComplement {
	
	public static int findComplement(int num) 
	{
		
		String binNumber = Integer.toBinaryString(num);
		
		StringBuilder sb = new StringBuilder();
		
		
		for(char c : binNumber.toCharArray())
		{
			if(c == '0')
			{
				sb.append(1);
			}else
			{
				sb.append(0);
			}
		}
		
		Integer convertedNum = Integer.valueOf(sb.toString(),2);
		
		return convertedNum;
	}

	public static void main(String[] args) {
		
		int n = 5; //2
		
		int n1 = 1; //0
		
		System.out.println(findComplement(n1));

		

	}

}
