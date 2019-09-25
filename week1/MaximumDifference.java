package week1;
import java.util.Scanner;

public class MaximumDifference {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);	
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){               //number of cases
			int size = input.nextInt();
			int [] test = new int [size];
			for(int j=0; j<size; j++){            
				test[j] = input.nextInt();
			}
			int difference = test[0]-test[1];
			for(int k=0; k<size-1; k++){              //test every first number
					for(int l=k+1; l<size; l++){
						if (test[k]-test[l]>difference){
							difference = test[k]-test[l];
				}
			}
			
		}
			System.out.print(difference);
			    /*    int max_diff = test[0] - test[1];
			        int min_element = test[1];
			        for (int k = 2; k < size; k++) 
			        {
			            if (test[k] - min_element > max_diff)
			                max_diff = test[k] - min_element;
			            if (test[k] < min_element)
			                min_element = test[k];
			        }*/
			     
			
		
		}
	}
}
