package week1;
import java.util.*;
public class FindAlgorithms {

	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		String article = " ";
		for (int i=0; i<cases; i++){         //each case  
			boolean print = false;
			int lines = input.nextInt();
			String a = input.nextLine();
			String [] describe = new String [lines];
			for(int j=0; j<lines; j++){
			 describe[j]=input.nextLine();
			}
			
			int length = input.nextInt();
			String b = input.nextLine();
			
			article = input.nextLine();
			String[] parts = article.split(" ");
			
		outterloop:	for(int j=0; j<lines; j++){
						for(int k=0; k<length; k++){
								if(describe[j].equalsIgnoreCase(parts[k])){
									print = true;
									break outterloop;
					}
			}
			}
			if(print==true)
				System.out.println("Appeared");
			if(print==false)
				System.out.println("Not appeared");
		}
	}
}
