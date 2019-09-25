package week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.*;

public class Count {
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
	  	        Long count = (long) 0;
	  	        int length = in.nextInt();
	  	        int difference = in.nextInt();
	  	        if(length<=2){
	  	            out.print("0");
	  	        }
	  	        else{
	  	            int value[] = new int[length];
	  	            for(int j=0; j<length; j++){
	  	            	value[j] = in.nextInt();
	  	            }
	  	            int end = 1;
	  	            for(int j=0; j<length; j++){
	  	            	while(value[end]-value[j]<=difference && end<length-1){
	  	            		end++;
	  	            	}
	  	            	if(value[end]-value[j]>difference)
	  	            		end--;
	  	            	if(end-j>=2)
	  	            		count = count + (end-j-1)*(end-j)/2;
	  	            }
	  	            out.println(count);
	  	        }

	  	    }
	  	}
}
	  	
