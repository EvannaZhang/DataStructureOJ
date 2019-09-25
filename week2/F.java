package week2;

import java.util.*;

public class F {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int number = input.nextInt();
			double child[][] = new double [number][2];
			for(int j=0; j<number; j++){
				child[j][0] = input.nextDouble();
				child[j][1] = input.nextDouble();
			}	
			
			double a = three_divide(child,number,child[0][0],child[number-1][0]);
			double b = distance(child,number,a);
			System.out.print("Case #"+(i+1)+": " );	
			System.out.printf("%.0f\n", b);
			
		}
	}
	public static double three_divide(double child[][], int number, double start, double end){  
		double mid = (start+end)/2;
		double mmid = (mid+end)/2;
		double a = distance(child, number, mid);
		double b = distance(child, number, mmid);
       
        if( Math.abs(mmid-mid) < 0.000000001){ 
        	/*for(int i=0; i<20; i++){
        		if(distance(child, number, mid) > distance(child, number, mmid)){
        			start = mid;
        		}
        		else
        			end = mmid;
        	}*/
        	return (mid+mmid)/2;
        }
    
        else if ( a > b )
        	return three_divide(child, number, mid, end);
        else 
        	return three_divide(child, number, start, mmid);

	}
	
	public static double distance(double child[][], int number, double point){
		double x = 0;
		for(int i=0; i < number; i++){
			double c = Math.abs(child[i][0]-point);
			x = x + c*c*c*child[i][1];
		}
		return x;
	}
}
