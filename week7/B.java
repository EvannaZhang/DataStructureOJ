package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class node{
	int value;
	node father,left,right;
}

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
  		public static void main(String[] args) {
  			InputStream inputStream = System.in;
  			OutputStream outputStream = System.out;
  			InputReader in = new InputReader(inputStream);
  			PrintWriter out = new PrintWriter(outputStream);	
  			slove(in,out);
  			out.close();
  		}
  		
  		static boolean hasleft(node now){
  			if(now.left!=null)
  				return true;
  			else
  				return false;
  		}
  		
  		static boolean hasright(node now){
  			if(now.right!=null)
  				return true;
  			else
  				return false;
  		}
  		
  		static void order(node now, ArrayList<Integer> out){
	  		if(hasleft(now))
	  			order(now.left,out);
	  		out.add(now.value);
	  		if(hasright(now))
	  			order(now.right,out);
	  		
  		}
  		
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
  	 		for(int i=0; i<cases; i++){
  	 			boolean answer = true;
  	 			int nodes = in.nextInt();
  	 			node[] tree = new node[nodes+1];
  	 			for(int j=1; j<=nodes; j++){
  	 				node t = new node();
  	 				t.value = in.nextInt();
  	 				tree[j] = t;
  	 			}
  	 			for(int j=0; j<nodes-1; j++){
  	 				int a = in.nextInt();
  	 				int b = in.nextInt();
  	 				if(tree[a].left!=null&&tree[a].right!=null){
  	 					answer = false;
  	 				}
  	 				else if(tree[a].left==null){
  	 					tree[a].left = tree[b];
  	 					tree[b].father = tree[a];
  	 				}
  	 				else{
  	 					tree[a].right = tree[b];
  	 					tree[b].father = tree[a];
  	 				}
  	 			}
  	 			int root = 0;
  	 			for(int j=1; j<=nodes;j++){
  	 				if(tree[j].father==null){
  	 					root = j;
  	 					break;
  	 				}
  	 			}
  	 			if(answer){
  	 				ArrayList<Integer> t= new ArrayList<Integer>();
  	 				order(tree[root],t);
  	 				for(int j=0; j<t.size()-1; j++){
  	 					if(t.get(j+1)<t.get(j)){
  	 						answer = false;
  	 						break;
  	 					}
  	 				}
  	 			}
  	 			if(answer)
  	 				out.println("Case #"+(i+1)+": YES");
  	 			else
  	 				out.println("Case #"+(i+1)+": NO");
  	 		}
  	 	
}
}
