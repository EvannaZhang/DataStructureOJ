package week3;
import java.util.*;

public class Merge {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int n = input.nextInt();
			int m = input.nextInt();
			LinkedList<Integer> first = new LinkedList<Integer>();
			LinkedList<Integer> second = new LinkedList<Integer>();
			for(int j=0; j<n; j++){
				first.add(input.nextInt());
			}
			for(int j=0; j<m; j++){
				second.add(input.nextInt());
			}
			System.out.print(Merge(first,second));
		}
	
	}
	
	static LinkedList<Integer> Merge(LinkedList<Integer> a, LinkedList <Integer>b){
		LinkedList<Integer> answer = new LinkedList<Integer>();
		if(a==null && b!=null){
			return b;
		}
		if(b==null && a!=null){
			return a;
		}
		
		if(a.getFirst() >= b.getFirst()){
			answer.add(b.getFirst());
				
		}
		else {
			answer.add(a.getFirst());
	
		}
		
		return answer;
		
	}


}
