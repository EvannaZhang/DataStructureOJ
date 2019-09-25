package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class C {
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
		  			PriorityQueue<Integer> min = new PriorityQueue<Integer> ();
		  			for(int j=0; j<number; j++){
		  				min.add(in.nextInt());
		  			}
		  			int line = in.nextInt();
		  			int count = 0;
		  			for(int j=0; j<line; j++){
		  				int temp = in.nextInt();
		  				count++;
		  				if(temp==1){
		  					min.add(in.nextInt());
		  				}
		  				else if(temp==2){
		  					min.poll();
		  				}
		  				else{
		  					out.print(min.peek());
                            break;
		  				}
		  			}
		  			for(int j=count; j<line; j++){
		  				int temp = in.nextInt();
		  				if(temp==1){
		  					min.add(in.nextInt());
		  				}
		  				else if(temp==2){
		  					min.poll();
		  				}
		  				else{
		  					out.println();
		  					out.print(min.peek());
		  					}
		  			}
		  			out.println();
		  		}
	  	 	}
}
