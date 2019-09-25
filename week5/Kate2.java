package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Kate2 {
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
	  			int count = 0;
	  			int fix = 0;
	  			for(int k=b; k>=0; k--){
	  				fix = k;
	  				if(y.substring(0,k).equals(y.substring(b-k,b)))
	  					break;
	  			}
	  			int add = b-fix;
	  			if(a<b)
	  				out.println(0);
	  			else{
	  				int test = a-b+1;
	  				int j = 0;
	  				while(j<=a-b){
	  					if(x.substring(j,j+b).equals(y)){
	  							count++;	
	  							if(add>0)
	  								j=j+add;
	  							else
	  								j=j+1;
	  					}
	  					else
	  						if(fix==0)
	  							j=j+b;
	  						else 
	  							j=j+1;
	  				}
	  			}
	  			out.println(count);
	  		}
}
}
