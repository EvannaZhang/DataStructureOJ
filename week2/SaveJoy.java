package week2;
import java.util.*;

public class SaveJoy {
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
			double gpa = getgpa(c,num);
			int place=0;
			for(int i=0; i<delete; i++){
			
					for(int j=0; j<num; j++){
						if(c[j][2]!=0){
							c[j][2]=0;
							if(gpa<getgpa(c,num)){
								gpa=getgpa(c,num);
								place=j;
							}
							c[j][2]=1;
						}
						}
					c[place][2]=0;
				
			}
			double answer = getgpa(c,num);
			System.out.printf("%.3f\n",answer);

		}
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
