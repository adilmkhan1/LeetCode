package May2020_Challenge;

public class CheckStraightLine {
	
	public static boolean checkStraightLine(int [][]coordinates)
	{
		
		//(Y2-Y1) * (X3-X1) = (X2-X1) * (Y3-Y1)  
		
		for(int i=2;i<coordinates.length;i++)
        {
            if( (coordinates[1][1] - coordinates[0][1] ) * ( coordinates[i][0] - coordinates[0][0] )
               != (coordinates[1][0] - coordinates[0][0] ) * (coordinates[i][1] - coordinates[0][1]) )
            {
                
                return false;
            }
            
            
        }
        
        
        return true;
		
	}

	public static void main(String[] args) {
		
       int coordinates[][] = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}; //true
       
       int coordinates1[][]= {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}; //false
       
       System.out.println(checkStraightLine(coordinates1));
		
		
	}

}
