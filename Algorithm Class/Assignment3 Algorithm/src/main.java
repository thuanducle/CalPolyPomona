import java.util.Stack;
import java.util.Random;
public class main {

	public static void main(String[] args) { 

		Stack<String> direction = new Stack<>();
		int arr[][] = new int[3][3];
		int path[][] = new int[3][3];
		Random rand = new Random();
		for(int i =0; i < arr.length;i++)
		{
			for(int j = 0; j < arr.length;j++)
			{
				arr[i][j] = rand.nextInt(3);
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println();
	
                System.out.println("Max is: " + chooseBest(arr,path,direction));

		System.out.println("Direction from top left, Read it from left to right: " + direction);
	}

	public static int chooseBest(int[][] givenArray,int[][] path, Stack<String> direction) {
		path[0][0]= givenArray[0][0];
                //For Finding the Path Array.
		for(int row = 0; row < givenArray.length;row++)
		{
			for(int column =0;column<givenArray.length;column++)
			{
				if(column == 0 && row != 0)
				{
					path[row][column] = path[row-1][column] + givenArray[row][column];
				}else if(row==0 && column!=0){
					path[row][column] = path[row][column-1] + givenArray[row][column];
				}else {
					if(row == 0 && column == 0) 
						continue;
					int top = path[row-1][column];
					int topLeft = path[row-1][column-1];
					int left = path[row][column-1];
					
					if(top > topLeft && top > left)
					{
						path[row][column] = top + givenArray[row][column];
					}else if(topLeft > top && topLeft > left) {
						path[row][column] = topLeft + givenArray[row][column];
					}else if(left > top && left > topLeft) {
						path[row][column] = left + givenArray[row][column];
					}else if(topLeft == top && topLeft == left) {
						path[row][column] = topLeft + givenArray[row][column];
					}else if(topLeft == top && topLeft > left) {
						path[row][column] = topLeft + givenArray[row][column];
					}else if(topLeft > top && topLeft == left) {
						path[row][column] = topLeft + givenArray[row][column];
					}else if(left == top && left > topLeft)
					{
						path[row][column] = left + givenArray[row][column];
					}
					continue;		
				}
			}    
		}

		//After finding the path, trace back to see which one is most efficient one
				int i = path.length-1;
				int j = path.length-1;
			
				while(true)
				{
					if(i == 0 && j ==0)
					{
						break;
					}
					if((i -1) < 0)
					{
						
						direction.push("GO RIGHT");
						j--;
					}else if( j -1 <0)
					{
					
						direction.push("GO DOWN");
						i--;
					}
					else if(path[i][j] == path[i-1][j-1] + givenArray[i][j])
					{
					
						direction.push(" GO DIAGONAL");
						i--; j--;
					}
					else if(path[i][j] == path[i][j-1] + givenArray[i][j] )
					{
					
						direction.push("GO RIGHT");
						j--;
					}
					else if(path[i][j] == path[i-1][j] + givenArray[i][j]) {
					
						direction.push("GO DOWN");
						i--;
					}
				}
		
            return path[path.length-1][path.length-1];
	}	
	
}
