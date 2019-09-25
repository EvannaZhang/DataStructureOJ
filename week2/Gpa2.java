package week2;
import java.util.*;

public class Gpa2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int delete = input.nextInt();
			double[][] child= new double [num][2];
			for(int i=0; i<2; i++){
				for(int j=0; j<num; j++){
					child[j][i] = input.nextInt();
				}
			}
			double a = gpa(0,1000,num,delete,child);
			System.out.printf("%.3f\n",a);
		}
	}
	
	public static double gpa(double start, double end, int number, int delete, double t[][])
	{
		double d = (start+end)/2;     
		double [] com = new double[number];  
		for(int i=0; i<number; i++){
			com[i] = t[i][0]*(t[i][1]-d);
		}
		/*for(int i=0; i<number-1; i++){
			for(int j=i; j<number; j++){
				if(com[i]<com[j]){
					double temp = com[i];
					com[i] = com[j];
					com[j] = temp;
				}
			}
		}*/
		Arrays.sort(com);
		double c = 0;
		for(int i=number-1; i>delete-1; i--){
			c = c + com[i];
		}
		if(Math.abs(c)<0.0001)
				return d;
		else if(c < 0)
				return gpa(start, d, number, delete, t);
		else
				return gpa(d, end, number, delete, t);
	}
}
