package week2;
import java.util.*;

public class Puberty {
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
		
		double a = distance(child, number, (end+2*start)/3);
		double b = distance(child, number, (2*end+start)/3);
       
        if( Math.abs(a-b) < 1){ 
        	for(int i=0; i<20; i++){
        		if(distance(child, number, (end+2*start)/3) > distance(child, number, (2*end+start)/3)){
        			start = (end+2*start)/3;
        		}
        		else
        			end = (2*end+start)/3;
        	}
        	return (end+start)/2;
        }
    
        else if (a>b)
        	return three_divide(child, number, (end+2*start)/3, end);
        else 
        	return three_divide(child, number, start, (2*end+start)/3);

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
