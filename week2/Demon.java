package week2;
import java.util.*;

public class Demon {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int number = input.nextInt();
			int demon = input.nextInt();
			int men[] = new int[number];
			for(int k=0; k<number; k++){
				men[k]=input.nextInt();
			}
			if(men[0]<=demon && men[number-1]>=demon)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	}
	

