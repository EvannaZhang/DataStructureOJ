package week1;
import java.math.BigDecimal;
import java.util.*;

public class TowerOfHanio {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	long cases = input.nextLong();
		for(int i=0; i<cases; i++){
			long moves = 1;
			long disks = input.nextLong();
			for(int k=0; k<disks; k++){
				moves = moves*3%1000000007;
			}
			System.out.println(moves-1);
		}
	} 
}
