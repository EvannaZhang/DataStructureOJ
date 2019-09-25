package week2;
import java.util.*;

public class HighSchool {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int y = input.nextInt();
			double point = binSearch(0,100,y);
			System.out.print("Case "+(i+1)+": ");
			double z = 5*point*point*point*point*point*point*point+6*point*point*point*point
					*point*point+3*point*point*point+4*point*point-2*point*y;
			System.out.printf("%.4f\n",z);
			
		}
	}
	
	 public static double binSearch(double start, double end,int y) {   
	        double x = (start + end) / 2;   
	        double a = 35*x*x*x*x*x*x+36*x*x*x*x*x+9*x*x+8*x;
	        if (Math.abs(a-2*y)<=0.1) {   
	            return x;
	        }   
	        else if (a>2*y) {   
	            return binSearch(start, x, y);  
	        } else {   
	            return binSearch(x, end, y);   
	        }   
	    }   
}
