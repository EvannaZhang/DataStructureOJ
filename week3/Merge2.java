package week3;

import java.util.Scanner;

public class Merge2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int n = input.nextInt();
			int m = input.nextInt();
			int[] first = new int[n];
			int[] second = new int[m];
			for(int j=0; j<n; j++){
				first[j]=input.nextInt();
			}
			for(int j=0; j<m; j++){
				second[j]=input.nextInt();
			}
			int[] answer = Merge(first,second,n,m);
			
			for(int j=0; j<m+n; j++){
				System.out.print(answer[j]+" ");
			}
			System.out.println();
		}
	
	}
	
	static int[] Merge(int[] a, int[] b,int n, int m){
		int[] answer = new int[m+n];
		int one = 0;
		int two = 0;
		
		for(int i=0; i<m+n; i++){
			if(one<n && two<m){
	
				if(a[one]>b[two]){
					answer[i]=b[two];
					two++;
				}
				else{
					answer[i]=a[one];
					one++;
				}
			}
			else
				if(one>=n && two<m){
					answer[i]=b[two];
					two++;
				}
				else if(two>=m && one<n){
					answer[i]=a[one];
					one++;
					
				}
		}
		return answer;
		
	}



}
