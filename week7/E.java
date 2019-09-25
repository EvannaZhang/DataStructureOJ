package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {
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
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
  	 		for(int i=0; i<cases; i++){
  	 			int number = in.nextInt();
  	 			int time = in.nextInt();
  	 			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
  	 			PriorityQueue<Integer> max = new PriorityQueue<Integer>();
  	 			ArrayList<Integer> all = new ArrayList<Integer>();
  	 			for(int j=0; j<number; j++){
  	 				int a = in.nextInt();
  	 				all.add(a);
  	 				if(min.size()<time)
  	 					min.add(a);
  	 				else{
  	 					if(a>min.peek()){
  	 						min.poll();
  	 						min.add(a);
  	 					}
  	 				}
  	 			}
  	 			int re = min.peek();
  	 			int modify = 0;
  	 			for(int j=number-1; j>=number-time; j--){
  	 				if(all.get(j)>=re)
  	 					modify++;
  	 			}
  	 			
  	 			for(int j=0; j<number; j++){
  	 				int a = all.get(j);
  	 				if(max.size()<time+modify)
  	 					max.add(a);
  	 				else{
  	 					if(a>max.peek()){
  	 						max.poll();
  	 						max.add(a);
  	 					}
  	 				}
  	 			}
  	 			int line = max.peek();
  	 			int count = 0;
  	 			for(int j=0; j<all.size(); j++){
  	 				if(all.get(j)<line){
  	 					System.out.print(all.get(j)+" ");
  	 					count++;
  	 				}
  	 			}
  	 			count = count+max.size(); 
  	 			for(int j=0; j<number-count;j++)
  	 				out.print(line+" ");
  	 			if(!max.isEmpty())
  	 				out.print(max.poll());
  	 			while(!max.isEmpty()){
  	 				out.print(" "+max.poll());
  	 			}
  	 			out.println();
  	 		
  	 		}
  	 	}
}
