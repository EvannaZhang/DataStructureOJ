package week1;
import java.util.*;
public class ChessGame {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int row = input.nextInt();
			int column = input.nextInt();
			if(row==1 && column==1)
				System.out.print("Bob");
			else
				System.out.print("Alice");
		}
	}

}
