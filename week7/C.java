package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class binode{
	int value, height;
	binode father,left,right;
}
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
  		
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
  	 		for(int i=0; i<cases; i++){
  	 			boolean answer = true;
  	 			int nodes = in.nextInt();
  	 			binode[] tree = new binode[nodes+1];
  	 			for(int j=1; j<=nodes; j++){
  	 				binode t = new binode();
  	 				t.value = in.nextInt();
  	 				tree[j] = t;
  	 			}
  	 			for(int j=1; j<=nodes; j++){
  	 				int a = in.nextInt();
  	 				int b = in.nextInt();
  	 				if(a!=0){
  	 					tree[j].left = tree[a];
  	 					tree[a].father = tree[j];
  	 				}
  	 				if(b!=0){
  	 					tree[j].right = tree[b];
  	 					tree[b].father = tree[j];
  	 				}
  	 			}
  	 			int root = 0;
  	 			for(int j=1; j<=nodes; j++){
  	 				if(tree[j].father==null){
  	 					root = j;
  	 					break;
  	 				}		
  	 			}
  	 			for(int j=1; j<=nodes; j++){      //问题
  	 				binode now = tree[j];
  	 				if(tree[j].left==null&&tree[j].right==null){
  	 					int d =1;
  	 					tree[j].height = 1;
  	 					while(now.father!=null){
  	 						d++;
  	 						if(now.father.height==0)
  	 							now.father.height = d;
  	 						else if(d>now.father.height)
  	 							now.father.height = d;
  	 						now = now.father;
  	 					}
  	 				}
  	 			}
  	 			
  	 			for(int j=1; j<=nodes; j++){
  	 				if(tree[j].left!=null)
  	 					if(tree[j].left.value>=tree[j].value)
  	 						answer = false;
  	 				if(tree[j].right!=null)
  	 					if(tree[j].right.value<=tree[j].value)
  	 						answer = false;
  	 				if(tree[j].left!=null&&tree[j].right!=null){
  	 					int diff = Math.abs(tree[j].left.height-tree[j].right.height);
  	 					if(diff>1)
  	 						answer = false;
  	 				}
  	 			}
  	 			if(answer){ //检查大小
  	 				Stack<binode> check = new Stack<binode>();
  	 				int[] v = new int[nodes+1];
  	 				int posi = 0;
  	 				binode n = tree[root];
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
  	 					if(v[j]>=v[j+1]){
  	 						answer = false;
  	 						break;
  	 					}
  	 					}
  	 			}
  	 			
  	 			if(answer)
  	 				out.println("Yes");
  	 			else
  	 				out.println("No");
  	 		}
  	 	}
}
