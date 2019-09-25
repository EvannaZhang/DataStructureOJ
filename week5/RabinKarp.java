package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import week5.KMP.InputReader;
	public class RabinKarp {
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
	  			if(a==0||b==0){
	  				out.println(0);
	  			}
	  			else if(a<b)
	  				out.println(0);
	  			else{
	  				int pattern = 0;
	  				int ans = 0;
	  				for(int j=0; j<b; j++){
	  					pattern = (int) (pattern +(int)y.charAt(j)*Math.pow(10, b-j-1))%1000;
	  				}
	  				for(int j=0; j<=a-b; j++){
	  					int search = 0;
	  					for(int k=0; k<b; k++){
	  						search = (int)(search + (int)x.charAt(j+k)*Math.pow(10, b-k-1))%1000;
	  					}
	  					if(search==pattern)
	  						if(x.substring(j, j+b).equals(y))
	  						ans++;
	  					}
	  				out.println(ans);
	  				}
	  			/*	int search = 0;
	  				for(int j=0; j<b; j++){
	  					search = (int)(search + (int)x.charAt(j)*Math.pow(100, b-j-1))%1000;
	  				}
	  				
	  				if(search==pattern){
	  					if(x.substring(0, b).equals(y)){
	  						ans++;
	  					}
	  				}
	  				for(int j=1; j<a-b+1; j++){
	  					int minus = (int)x.charAt(j-1)*(int)Math.pow(100, b-1);
	  					minus = minus%1000;
	  					search = (search - minus)*100 + (int)x.charAt(j+b-1);
	  					search = search%1000;
	  					out.println(search);
	  					if(search==pattern){
	  						if(x.substring(j, j+b).equals(y)){
	  							ans++;
	  						}
	  					}
	  				}*/
	  			
	  			}
	  			
	  	}
}
