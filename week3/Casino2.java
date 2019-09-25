package week3;
import java.util.*;

public class Casino2 {
	public static class Median{
		 PriorityQueue<Integer> max = new PriorityQueue<Integer> (new MaxComparator() );
		 PriorityQueue<Integer> min = new PriorityQueue<Integer> (new MinComparator() );

		 public void addNumber(int number) {
			if (this.max.isEmpty()) {
				this.max.add(number);
				return;
			}
			if (this.max.peek() >= number) {
				this.max.add(number);
			}
			else {
			if (this.min.isEmpty()) {
				this.min.add(number);
				return;
			}
				else if (this.min.peek() > number) {
					this.max.add(number);
				} 
				else {
					this.min.add(number);
				}
			}
			modifySize();
		}

		 private void modifySize() {
			if (this.max.size() - this.min.size() == 2) {
				this.min.add(this.max.poll());
			}
			if (this.min.size() - this.max.size() == 2) {
				this.max.add(this.min.poll());
			}
		}
		 
		public Integer getMedian() {
			int maxSize = this.max.size();
			int minSize = this.min.size();
			if (maxSize + minSize == 0) {
				return null;
			}
			Integer maxHead = this.max.peek();
			Integer minHead = this.min.peek();
			if (((maxSize + minSize) & 1) == 0) {
				return (maxHead + minHead) / 2;
			}
			if(maxSize>minSize)
				return maxHead;
			else
				return minHead;
		}
	 
	public static class MaxComparator implements Comparator<Integer>{
		public int compare(Integer first, Integer second) {
			if (second > first) {
				return 1;
			} else {
				return -1;
			}
	}
}
	public static class MinComparator implements Comparator<Integer>{
		public int compare(Integer first, Integer second) {
			if (second < first) {
				return 1;
			} else {
				return -1;
			}
	}
}
}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int day = input.nextInt();
			Median median = new Median();
			for(int j=0; j<day; j++){
				median.addNumber(input.nextInt());
				if(j%2==0){
					System.out.print(median.getMedian()+" ");
				}
			}
			System.out.println();
		}
	}
}