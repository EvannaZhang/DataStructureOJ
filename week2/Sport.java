package week2;
import java.util.*;

public class Sport {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int length = input.nextInt();
			int places = input.nextInt();
			int racer = input.nextInt();
			int distance[] = new int[places+1];
			for(int j=0; j<places; j++){
				distance[j] = input.nextInt();
			}
			distance[places] = length;
			Arrays.sort(distance);
			System.out.println(run(distance,length, places, racer, 0, length));
		}
	}
	static int run(int[] distance, int length, int places, int racers, int start, int end){
		int mid = (start+end)/2;
		int count = 1;
		int last = 0;
		int max = 0;
		while(distance[last] < mid)
		{
			last++;
		}
		
		if(last < places-1){
			for(int i = last+1; i < places; i++){
				if(distance[i] - distance[last] >= mid){
					last = i;
					count = count + 1;
					if(distance[i]-distance[last] > max){
						max = distance[i]-distance[last];
					}
				}	
			}
		}
		if(last!=places && length - distance[last] < mid)
			return run(distance, length, places, racers, start, mid);
		else{
			if(length - distance[last] > max)
				max = length - distance[last];
			if(count == racers)
				return max;
			else if (count > racers)
				return run(distance, length, places, racers, start, mid);
			else
				return run(distance, length, places, racers, mid, end);
	}
	}

}
