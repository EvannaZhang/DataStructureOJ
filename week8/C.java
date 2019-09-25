package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
  		static void count(int a, graph[] edge, Queue<Integer> check){
			check.add(a);
			edge[a].depth = 0;
			while(!check.isEmpty()){
			    int t = check.poll();     
			    for(int son: edge[t].son){
			    	if(edge[son].depth==-1){
			    		edge[son].depth = edge[t].depth+1;
			    		check.add(son);
			    		}
			    }
			    
			}
		}
  		static void slove(InputReader in, PrintWriter out){
  			Queue<Integer> check = new LinkedList<Integer>();
			int cases = in.nextInt();
			for(int i=0; i<cases; i++){
				int nodes = in.nextInt();
				int line = in.nextInt();
				int s = in.nextInt();
				graph[] edge = new graph[nodes+1];
				for(int j=0; j<nodes+1; j++){
					edge[j] = new graph();
				}
				for(int j=0;j<line; j++){
					int a = in.nextInt();
					int b = in.nextInt();
					edge[a].son.add(b);
					edge[b].son.add(a);
				}
				count(s, edge,check);
				for(int j=1; j<=nodes; j++){
					out.print(edge[j].depth);
					if(j!=nodes)
						out.print(" ");
				}
				out.println();
		}
  		}
}