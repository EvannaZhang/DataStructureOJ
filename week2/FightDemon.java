package week2;
import java.util.*;

public class FightDemon {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int number = input.nextInt();
			int target = input.nextInt();
			int sword[] = new int[number];
			int count=0;
			for(int k=0; k<number; k++){
				sword[k] = input.nextInt();
			}
			for(int k=0; k<number-1; k++){
				count=count+binSearch (sword, k,k+1,number-1,target);
			}
			System.out.println(count);
		}
	}
	 public static int binSearch(int a[],int i, int start, int end, int target) {   
		  	int mid = (end + start) / 2;   
	        if (a[mid]+a[i] == target) {   
	            return 1;   
	        }   
	        if (start >= end) {   
	            return 0;   
	        } else if (a[mid]+a[i] < target) {   
	            return binSearch(a, i, mid+1, end, target);   
	        } else if (a[mid]+a[i] > target) {   
	            return binSearch(a, i, start, mid-1, target);   
	        }   
	        return 0;   
	  
	    }   
	

}
