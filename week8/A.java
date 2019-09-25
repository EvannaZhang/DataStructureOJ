package week8;
import java.util.*;

public class A {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int nodes = input.nextInt();
			int line = input.nextInt();
			int[][] matrix = new int [nodes+1][nodes+1];
			for(int j=0; j<line; j++){
				int a = input.nextInt();
				int b = input.nextInt();
				matrix[a][b] = 1;
			}
			for(int j=1; j<nodes+1;j++){
				for(int k=1; k<nodes+1; k++){
					System.out.print(matrix[j][k]);
					if(k!=nodes)
						System.out.print(" ");
				}
				if(j!=nodes)
					System.out.println();
			}
			System.out.println();
		}
	}
}
