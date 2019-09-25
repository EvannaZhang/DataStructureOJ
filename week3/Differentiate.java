package week3;
import java.util.*;

public class Differentiate {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int number = input.nextInt();
			int[][] poly = new int[number][2];
			poly[0][0]=input.nextInt();
			poly[0][1]=input.nextInt();
			poly[0][0]=poly[0][0]*poly[0][1];
			poly[0][1]=poly[0][1]-1;
			int count = 0;
			if(poly[0][1]!=-1){
			if(poly[0][1]==0){
				if(poly[0][0]!=0)
				System.out.print(poly[0][0]);
				if(poly[0][0]==0)
					count++;
			}
			if(poly[0][1]==1){
				System.out.print(poly[0][0]+"x");
			}
			if(poly[0][1]!=0 && poly[0][1]!=1){
			System.out.print(poly[0][0]);
			System.out.print("x^");
			System.out.print(poly[0][1]);
			}
			}
			
			
			if(number==1){
				System.out.println();
			}
			for(int j=1; j < number; j++){
				poly[j][0]=input.nextInt();
				poly[j][1]=input.nextInt();
				if(poly[j][1]==0){
					count++;
					continue;
				}
					
				poly[j][0]=poly[j][0]*poly[j][1];
				poly[j][1]=poly[j][1]-1;
				
				if(poly[j][0]>0)
					System.out.print("+");
				if(poly[j][1]==0){
					System.out.print(poly[j][0]);
				}
				if(poly[j][1]==1){
					System.out.print(poly[j][0]+"x");
				}
				if(poly[j][1]!=0 && poly[j][1]!=1){
				System.out.print(poly[j][0]);
				System.out.print("x^");
				System.out.print(poly[j][1]);
				}
				if(j==number-1)
					System.out.println();
			}
			if(count==number-1)
				System.out.print(0);
		}
	}
}
