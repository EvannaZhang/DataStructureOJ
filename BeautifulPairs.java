package week1;
import java.util.*;
public class BeautifulPairs {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		String a = input.nextLine();
		
		for(int i=0; i<cases; i++){
				String str = input.nextLine();
				int size = str.length();
				int [] count = new int[size];
				for(int j=0;j<size; j++){         //each char
				
					for(int k=0; k<size-1; k++){
						int num = 0;
						if(str.charAt(k)=='a'||str.charAt(k)=='e'||str.charAt(k)=='i'||str.charAt(k)=='o'
								||str.charAt(k)=='u'||str.charAt(k)=='w'||str.charAt(k)=='y'){
							continue;
						}
						if(str.charAt(k+1)=='a'||str.charAt(k+1)=='e'||str.charAt(k+1)=='i'||str.charAt(k+1)=='o'
								||str.charAt(k+1)=='u'||str.charAt(k+1)=='w'||str.charAt(k+1)=='y'){
							continue;
						}
						if(str.charAt(k)==str.charAt(j) && str.charAt(k+1)!=str.charAt(j)){
							count[j]++;
						}
						if(str.charAt(k)!=str.charAt(j) && str.charAt(k+1)==str.charAt(j)){
							count[j]++;
						}
						
					}
					
				}
				
				int max = 0;
				for(int j=0; j<size-1; j++){
					if(count[j] >= max){
						max=count[j];
					}
				}
				System.out.println(max);
			}//each case
}
}