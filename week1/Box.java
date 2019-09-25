package week1;
import java.util.*;
public class Box {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
			for(int i=0; i<cases; i++){
				int a = input.nextInt();
				int b = input.nextInt();
				int c = input.nextInt();
				int m = input.nextInt();
				int n = input.nextInt();
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
				if(2*b+2*c<=m && a+2*c<=n){
					System.out.println("Yes");
					continue;
				}
				if(2*b+2*c<=n && a+2*c<=m){
					System.out.println("Yes");
					continue;
				}
				if(2*a+2*c<=m && b+2*c<=n){
					System.out.println("Yes");
					continue;
				}
				if(2*a+2*c<=n && b+2*c<=m){
					System.out.println("Yes");
					continue;
				}
				if(b+c<=m && 3*a+b+c<=n){
					System.out.println("Yes");
					continue;
				}
				if(b+c<=n && 3*a+b+c<=m){
					System.out.println("Yes");
					continue;
				}
				if(a+3*b+c<=m && a+c<=n){
					System.out.println("Yes");
					continue;
				}
				if(a+3*b+c<=n && a+c<=m){
					System.out.println("Yes");
					continue;
				}
				if(a+b+3*c<=m && a+b<=n){
					System.out.println("Yes");
					continue;
				}
				if(a+b+3*c<=n && a+b<=m){
					System.out.println("Yes");
					continue;
				}
				if(2*b+c<=m && 2*a+2*b<=n){
					System.out.println("Yes");
					continue;
				}
				if(2*b+c<=m && 2*a+2*b<=n){
					System.out.println("Yes");
					continue;
				}
				System.out.println("No");
			}
	
}
}