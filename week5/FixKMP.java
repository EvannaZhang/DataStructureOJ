package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FixKMP {
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
	  			int a = in.nextInt();
	  			String x = in.next();
	  			int b = in.nextInt();
	  			String y = in.next();
	  			int next[] = new int [a];
  				next[0] = 0;
  				for(int j=1; j<a; j++){  // when j==1, two chars substring
  					int count = 0;
  					outterloop: for(int k=j-1; k>-1; k--){           //k=character
  						if(y.substring(0, k+1).equals(y.substring(j-k,j+1))){
  							count = k+1;
  							break outterloop;
  						}
  						else if(k==0)
  							count=0;
  					}
  					next[j] = count;
  				}
	  			for(int j=a; j>0; j--){
	  				
	  				
	  			}
	  		}
	  	}
}
