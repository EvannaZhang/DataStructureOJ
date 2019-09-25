package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class treenode{
	int value;
	treenode father,left,right;
}

public class B2 {
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
  		
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
  	 		for(int i=0; i<cases; i++){
  	 			boolean answer = true;
  	 			int nodes = in.nextInt();
  	 			treenode[] tree = new treenode[nodes+1];
  	 			for(int j=1; j<=nodes; j++){
  	 				treenode t = new treenode();
  	 				t.value = in.nextInt();
  	 				tree[j] = t;
  	 			}
  	 			for(int j=0; j<nodes-1; j++){
  	 				int a = in.nextInt();
  	 				int b = in.nextInt();
  	 				if(tree[a].left!=null&&tree[a].right!=null){
  	 					answer = false;
  	 				}
  	 				else if(tree[a].left==null&&tree[a].right==null){
  	 					tree[b].father = tree[a];
  	 					if(tree[a].value < tree[b].value)
  	 						tree[a].right = tree[b];
  	 					else
  	 						tree[a].left = tree[b];
  	 				}
  	 				else if(tree[a].left==null&&tree[a].right!=null){
  	 					tree[b].father = tree[a];
  	 					if(tree[b].value < tree[a].right.value )
  	 						tree[a].left = tree[b];
  	 					else{
  	 						tree[a].left = tree[a].right;
  	 						tree[a].right = tree[b];
  	 					}
  	 					if(tree[a].left.value>tree[a].value||tree[a].right.value<tree[a].value)
  	 						answer = false;
  	 				}
  	 				else if(tree[a].right==null&&tree[a].left!=null){
  	 					tree[b].father = tree[a];
  	 					if(tree[b].value>tree[a].left.value)
  	 						tree[a].right = tree[b];
  	 					else{
  	 						tree[a].right = tree[a].left;
  	 						tree[a].left = tree[b];
  	 					}
  	 					if(tree[a].left.value>tree[a].value||tree[a].right.value<tree[a].value)
  	 						answer = false;
  	 				}
  	 			}
  	 			int root = 0;
  	 			for(int j=1; j<=nodes;j++){
  	 				if(tree[j].father==null){
  	 					root = j;
  	 					break;
  	 				}
  	 			}
  	 			if(answer){ //检查大小
  	 				Stack<treenode> check = new Stack<treenode>();
  	 				int[] v = new int[nodes+1];
  	 				int posi = 0;
  	 				treenode n = tree[root];
  	 				check.push(n);
  	 				while(!check.isEmpty()){      //中序遍历
  	 					while(n!=null){
  	 						check.push(n);
  	 						n = n.left;
  	 					}
  	 					if(!check.isEmpty()){
  	 						n = check.peek();
  	 						v[posi] = n.value;
  	 						posi++;
  	 						check.pop();
  	 						n = n.right;
  	 					}
  	 				}
  	 				for(int j=0; j<nodes-1; j++)
  	 					{
  	 					if(v[j]>v[j+1]){
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
