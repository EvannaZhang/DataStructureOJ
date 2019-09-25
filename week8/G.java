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

class gnode{
	int value;
	ArrayList<Integer> son = new ArrayList<Integer>();
}
public class G {
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
  		static void dfs(gnode[] tree, int a, Queue<Integer> d){
  				d.add(a);
  				for(int i=0; i<tree[a].son.size(); i++){
  					dfs(tree,tree[a].son.get(i),d);
  				}
  				d.add(a);
  		}
  		static void slove(InputReader in, PrintWriter out){
  			int cases = in.nextInt();
  			for(int i=0; i<cases; i++){
  				int n = in.nextInt();
  				int m = in.nextInt();
  				int[] root = new int[n+1];
  				gnode[] tree = new gnode[n+1];
  				for(int j=0; j<n+1; j++){
  					tree[j] = new gnode();
  				}
  				for(int j=0; j<n-1; j++){
  					int a = in.nextInt();
  					int b = in.nextInt();
  					root[b] = 1;
  					tree[a].son.add(b);
  				}
  				int r = 0;
  				for(int j=1; j<n+1; j++){
  					if(root[j]==0){
  						r = j;
  						break;
  					}
  				}
  				int [][] time = new int[n+1][2];
  				Queue<Integer> d  = new LinkedList<Integer>();
  				dfs(tree,r,d);
  				int count = 0;
  				while(!d.isEmpty()){
  					count++;
  					int t = d.poll();
  					if(time[t][0]==0)
  						time[t][0] = count;
  					else
  						time[t][1] = count;
  				}
  				for(int k=0; k<2; k++){
  					for(int l=1; l<n+1; l++){
  						out.print(time[l][k]+" ");
  					}
  					out.println();
  				}
  				
  				for(int j =0; j<m; j++){
  					int a = in.nextInt();
  					int b = in.nextInt();
  					if(a==b)
  						out.println("Yes");
  					else{
  					if(time[a][0]<time[b][0]&&time[b][0]<time[b][1]&&time[b][1]<time[a][1])
  						out.println("Yes");
  					else
  						out.println("No");
  					}
  				}
  			}
  		}
}
