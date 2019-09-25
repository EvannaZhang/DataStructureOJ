package week2;
import java.util.Scanner;

public class Gpa {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			int delete = input.nextInt();
			int c [][]= new int [num][3];
			for(int i=0; i<2; i++){
				for(int j=0; j<num; j++){
					c[j][i] = input.nextInt();
					c[j][2] = 1;
				}
				
}
			System.out.printf("%.3f\n",gpa(c,num,delete));
}
	}
		
	public static double gpa(int[][] c, int num, int delete){
			for(int j=0; j<delete; j++){
				
				double x=getgpa(c,num);
				int place = 0;
				for(int i=0; i<num; i++){
					if(c[i][2]==1){
					if(c[i][0]*(c[i][1]-x)<c[place][0]*(c[place][1]-x)){
						place = i;
					}
					}
				}
				c[place][2] = 0;
			}
			
			return getgpa(c,num);
	}
		static public double getgpa(int c[][], int x){
			double zi =0;
			double mu =0;
			for(int i=0; i<x; i++){
				if(c[i][2]==1){
					zi = zi +c[i][0]*c[i][1];
					mu = mu + c[i][0];
				}
			}
			return zi/mu;
		}
	}