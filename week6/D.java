package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Queue;
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
	  		static int findmax(int i,int[][]edge, int[][] depth, int d){
	  			if(!hasright(edge,i)&&!hasleft(edge,i))
	  				return d;
	  			if(!hasleft(edge,i))
	  				depth[i][0] = 0;
	  			if(!hasright(edge,i))
	  				depth[i][1] = 0;
		  		if(hasleft(edge,i))
		  			findmax(edge[i][0],edge,depth,d);	
		  		if(hasright(edge,i))
		  			findmax(edge[i][1],edge,depth,d);
		  		if(hasleft(edge,i)){
		  			if((depth[edge[i][0]][0] > depth[edge[i][0]][1]))
		  				depth[i][0] = depth[edge[i][0]][0]+1;
		  			else
		  				depth[i][0] = depth[edge[i][0]][1] +1;
		  		}
		  		if(hasright(edge,i)){
		  			if(depth[edge[i][1]][0] > depth[edge[i][1]][1])
		  				depth[i][1] = depth[edge[i][1]][0] +1;
		  			else
		  				depth[i][1] = depth[edge[i][1]][1] +1;
		  		}
		  		if(depth[i][0] +depth[i][1] > d)
		  			d = depth[i][0] +depth[i][1];
				return d;
		  		
		  	}
		  	
		  	static boolean hasleft(int[][] edge, int i){
		  		if(edge[i][0]==0)
		  			return false;
		  		else
		  			return true;
		  	}
		  	
		  	static boolean hasright(int[][] edge, int i){
		  		if(edge[i][1]==0)
		  			return false;
		  		else
		  			return true;
		  	}
	  	 	static void slove(InputReader in, PrintWriter out){ 
		  		int cases = in.nextInt();
		  		for(int i=0; i<cases; i++){
		  			int nodes = in.nextInt();
		  			int[][] edge = new int [nodes+1][2];
		  			for(int j=0; j<nodes-1; j++){
		  				int father = in.nextInt();
		  				int son = in.nextInt();
		  				if(edge[father][0]!=0)
		  					edge[father][1] = son;
		  				else
		  					edge[father][0] = son;
		  			}
		  			int [][]depth = new int[nodes+1][2];
		  			int max = 0;
		  			out.println(findmax(1,edge,depth,max));
		  		}
	  	 	}
	  	 	
}
//二叉树