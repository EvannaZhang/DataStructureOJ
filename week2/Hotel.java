package week2;
import java.util.*;

public class Hotel {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
		int day = input.nextInt();
		int order = input.nextInt();
		int rooms[] = new int[day];
		for(int i=0; i<day; i++){
			rooms[i] = input.nextInt();
		}
		int test[][] = new int[order][3];
		for(int i=0; i<order; i++){
			test[i][0] = input.nextInt();         //room
			test[i][1] = input.nextInt();         //begin
			test[i][2] = input.nextInt();         //end
		}
		
		outterloop: for(int i=0; i<order; i++){
			for(int j=test[i][1]; j<=test[i][2]; j++){
					rooms[j-1] = rooms[j-1]-test[i][0];
			
				if(rooms[j-1]<0){
					System.out.println(-1);
					System.out.println(i+1);
					break outterloop;
				}
			}
		}
		int count=0;
		for(int i=0; i<day; i++){
			if(rooms[i]>=0)
				count++;
		}
		if(count==day)
			System.out.println(0);
		}
		}
}
