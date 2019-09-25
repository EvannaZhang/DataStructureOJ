package week6;
import java.util.*;

public class A {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int nodes = input.nextInt();
	  			int[] check = new int[nodes+1];
	  			for(int j=0; j<2*nodes-2; j++){
	  				int temp = input.nextInt();
	  				check[temp]++;
	  			}
	  			int num=0;
	  			int[] ans = new int[nodes+1];
	  			for(int j=2; j<nodes+1; j++){
	  				if(check[j]==1){
	  					ans[num] = j;
	  					num++;
	  				}	
	  			}
	  			if(num==1)
	  				System.out.println(ans[0]);
	  			if(num > 1){
	  				for(int j=0; j<num-1; j++)
	  					System.out.print(ans[j]+" ");
	  				System.out.println(ans[num-1]);
	  			}
	  		}
}
}