package week8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class B {
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
  		static boolean s(int a, int b, ArrayList[] edge, int[] already){
  			if(a==b)
  				return true;
  			else if(edge[a].isEmpty())
  				return false;
  			else{
  				already[a] = 1;
  				for(int i=0; i<edge[a].size(); i++){
  					int child = (int)edge[a].get(i);
  					if(already[child]!=1){
  						already[child] = 1;
  						if(s(child,b,edge,already))
  							return true;
  					}
  				}
  			}
  			return false;
  		}
  		static void slove(InputReader in, PrintWriter out){
  			int cases = in.nextInt();
  			for(int i=0; i<cases; i++){
  				int nodes = in.nextInt();
  				int line = in.nextInt();
  				ArrayList[] edge = new ArrayList[nodes+1];
  				for(int j=0; j<nodes+1; j++){
  					edge[j] = new ArrayList();
  				}
  				for(int j=0;j<line; j++){
  					int a = in.nextInt();
  					int b = in.nextInt();
  					edge[a].add(b);
  				}
  				int Q = in.nextInt();
  				
  				for(int j=0; j<Q; j++){
  					int u = in.nextInt();
  					int v = in.nextInt();
  					int[] already = new int[nodes+1];
  					if(s(u,v,edge,already))
  						out.println("YES");
  					else
  						out.println("NO");
  				}
  			}
  		}
}
