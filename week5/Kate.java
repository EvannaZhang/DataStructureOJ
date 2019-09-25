package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Kate {
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
	  		
	  		public static int[] cal(String t){
	  			int m = t.length();
	  			int[] pi = new int[m];
	  			pi[0]=0;
	  			int k = 0;
	  			for(int q=2; q<=m; q++){
	  				while(k>0&&t.charAt(k)!=t.charAt(q-1))
	  					k = pi[k-1];
	  				if(t.charAt(k)==t.charAt(q-1))
	  					k = k+1;
	  				pi[q-1] = k;
	  			}
	  			return pi;
	  		}
	  		
	  		
	  
	  	static void slove(InputReader in, PrintWriter out){ 
	  		int cases = in.nextInt();
	  		for(int i=0; i<cases; i++){
	  			int a = in.nextInt();
	  			String x = in.next();
	  			int b = in.nextInt();
	  			String y = in.next();
	  			int count = 0;
	  			if(a<b)
	  				out.println(0);
	  			else{
	  				int[] pi = cal(y);
	  				int q = 0;
	  				for(int j=1;j<=a; j++){
	  					while(q>0&&y.charAt(q)!=x.charAt(j-1))
	  						q = pi[q-1];
	  					if(y.charAt(q)==x.charAt(j-1))
	  						q = q+1;
	  					if(q==b){
	  						count++;
	  						q = pi[q-1];
	  					}
	  				}
	  			}out.println(count);
	  	}
	  	}
}
