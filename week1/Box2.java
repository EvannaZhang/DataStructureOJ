package week1;
import java.util.*;

public class Box2 {
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			int[][] side = new int[cases][3];
			 if(a < b) {
			     int t = a;
			     a = b;
			     b = t;
			    }
			      if(a < c) {
			     int t = a;
			     a = c;
			     c = t;
			    }
			     if(b < c) {
			     int t = b;
			     b = c;
			     c = t;
			    }
			side[i][0] = a;
			side[i][1] = b;
			side[i][2] = c;
			int n = input.nextInt();
			int m = input.nextInt();
			if(2*side[i][1]+2*side[i][2]<=m && side[i][0]+2*side[i][2]<=n){
				System.out.print("Yes");
				continue;
			}
			if(2*side[i][1]+2*side[i][2]<=n && side[i][0]+2*side[i][2]<=m){
				System.out.print("Yes");
				continue;
			}
			if(2*side[i][0]+2*side[i][2]<=m && side[i][1]+2*side[i][2]<=n){
				System.out.print("Yes");
				continue;
			}
			if(2*side[i][0]+2*side[i][2]<=n && side[i][1]+2*side[i][2]<=m){
				System.out.print("Yes");
				continue;
			}
			if(side[i][1]+side[i][2]<=m && 3*side[i][0]+side[i][1]+side[i][2]<=n){
				System.out.print("Yes");
				continue;
			}
			if(side[i][1]+side[i][2]<=n && 3*side[i][0]+side[i][1]+side[i][2]<=m){
				System.out.print("Yes");
				continue;
			}
			if(side[i][0]+3*side[i][1]+side[i][2]<=m && side[i][0]+side[i][2]<=n){
				System.out.print("Yes");
				continue;
			}
			if(side[i][0]+3*side[i][1]+side[i][2]<=n && side[i][0]+side[i][2]<=m){
				System.out.print("Yes");
				continue;
			}
			if(side[i][0]+side[i][1]+3*side[i][2]<=m && side[i][0]+side[i][1]<=n){
				System.out.print("Yes");
				continue;
			}
			if(side[i][0]+side[i][1]+3*side[i][2]<=n && side[i][0]+side[i][1]<=m){
				System.out.print("Yes");
				continue;
			}
			if(2*side[i][1]+side[i][2]<=m && 2*side[i][1]+2*side[i][0]<=n){
				System.out.print("Yes");
				continue;
			}
			if(2*side[i][1]+side[i][2]<=n && 2*side[i][1]+2*side[i][0]<=m){
				System.out.print("Yes");
				continue;
			}
			System.out.print("No");
		}
		
	}

	
}
