package week5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

	public class RK2 {
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
	  					pattern = (int) (pattern +(int)y.charAt(j)*Math.pow(10, b-j-1));
	  					pattern = pattern%1000;
	  				}
	  				out.println(pattern);
	  				
	  				int search = 0;
	  				for(int j=0; j<b; j++){
	  					search = (int)(search + (int)x.charAt(j)*Math.pow(10, b-j-1));
	  					search = search%1000;
	  				}
	  				out.println(search);
	  				
	  				if(search==pattern){
	  					if(x.substring(0, b).equals(y)){
	  						ans++;
	  					}
	  				}
	  				
	  				for(int j=1; j<a-b+1; j++){
	  					int minus = (int)x.charAt(j-1);
	  					int time = (b-1)%3 +1;
	  					for(int q=0; q<time; q++){
	  						minus = minus*10;
	  						minus = minus%1000;
	  					}
	  					//out.println(minus);
	  					search = search + 1000 - minus;
	  					search = search*10 + (int)x.charAt(j+b-1);
	  					search = search%1000;
	  					//out.println(search);
	  					if(search==pattern){
	  						if(x.substring(j, j+b).equals(y)){
	  							ans++;
	  						}
	  					}
	  			
	  	}
	  				out.println(ans);
}
	  		}
	  	}
	}

