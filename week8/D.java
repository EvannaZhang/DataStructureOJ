package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
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
  				int nodes = in.nextInt();
  				int line = in.nextInt();
  				int[][] edge = new int [nodes+1][nodes+1];
  				for(int j=0; j<line; j++){
  					int a = in.nextInt();
  					int b = in.nextInt();
  					edge[a][b] = 1;
  					edge[b][a] = 1;
  				}
  				
  				if(nodes<4)
  					System.out.println(0);
  				else{//nodes>=4
  					int count = 0;
  					for(int j=1; j<=nodes-3; j++){
  						for(int k=j+1; k<=nodes-2; k++){
  							for(int l=k+1; l<=nodes-1; l++){
  								for(int m=l+1; m<=nodes; m++){
  									if(edge[j][k]+edge[j][l]+edge[j][m]+edge[k][l]+edge[k][m]+edge[l][m]>5)
  										count++;
  								}
  							}
  						}
  					}
  					System.out.println(count);
  				}
  			}
  		}
}
