package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import week7.A2.InputReader;

public class D {
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
          return tokenizer.nextToken();
		}
      public int nextInt() {
    	  return Integer.parseInt(next());
      }
      public long nextLong() {
          return Long.parseLong(next());
      }
	}
  		public static void main(String []args) {
  			InputStream inputStream = System.in;
  			OutputStream outputStream = System.out;
  			InputReader in = new InputReader(inputStream);
  			PrintWriter out = new PrintWriter(outputStream);	
  			slove(in,out);
  			out.close();
  		}
  		public static class Median{
  			PriorityQueue<Integer> max = new PriorityQueue<Integer> (new MaxComparator() );
  			PriorityQueue<Integer> min = new PriorityQueue<Integer> (new MinComparator() );
		 
  			public void addNumber(int number,int size) {
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
				modifySize(size);
			}

  			private void modifySize(int size) {
				while (this.min.size() > size) {
					this.max.add(this.min.poll());
				}
				if(this.min.size()<size){
					while(this.max.size()>0){
						this.min.add(this.max.poll());
					}
				}
			}
			 
			public Integer getMedian() {
				if(this.max.size()==0)
					return this.max.peek();
				else
				    return this.min.peek();
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
	static void slove(InputReader in, PrintWriter out){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int number = input.nextInt();
			int k =input.nextInt();
			int size = k;
			Median median = new Median();
			for(int j=0; j<number; j++){
				median.addNumber(input.nextInt(),size);
			}
			System.out.println(median.getMedian());
		}
	}
}

