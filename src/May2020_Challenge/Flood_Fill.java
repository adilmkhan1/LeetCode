package May2020_Challenge;

import java.util.Arrays;

public class Flood_Fill {
	
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if (image[sr][sc] == newColor)
            return image;
        
        dfs(image,sr,sc,image[sr][sc],newColor);
        
        return image;
        
    }
    
    
    public static void dfs(int image[][],int r,int c,int currColor,int newColor)
    {
        
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length||image[r][c] != currColor)
            return;
        
        image[r][c] = newColor;
        
        dfs(image,r+1,c,currColor,newColor);
        dfs(image,r-1,c,currColor,newColor);
        dfs(image,r,c+1,currColor,newColor);
        dfs(image,r,c-1,currColor,newColor);
        
        
    }

	public static void main(String[] args) {

		int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
		
		int sr = 1,sc = 1, newColor = 2;
		
		int result [][] = floodFill(image, sr, sc, newColor);
		
		for(int i[] : result)
		{
			System.out.println(Arrays.toString(i));
		}

	}

}
