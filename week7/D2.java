package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class D2 {
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
  				PriorityQueue<Integer> min = new PriorityQueue<Integer> ();
  				int number = in.nextInt();
  				int k = in.nextInt();
  				for(int j=0; j<number; j++){
  					int a = in.nextInt();
  					if(min.size()<k)
  						min.add(a);
  					else{
  						if(a>min.peek()){
  							min.poll();
  							min.add(a);
  						}
  					}
  				}
  				out.println(min.peek());
  			}
  		}
}
