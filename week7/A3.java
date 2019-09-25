package week7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class node{
	int father,left,right;
	int value,height,order;
}
public class A3 {
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
  		static boolean hasleft(node now){
  			if(now.left!=0)
  				return true;
  			else
  				return false;
  		}
  		
  		static boolean hasright(node now){
  			if(now.right!=0)
  				return true;
  			else
  				return false;
  		}
  		
  		static void order(int now, node[] tree,Stack<Integer> out){
  			out.push(now);
	  		if(hasleft(tree[now]))
	  			order(tree[now].left,tree,out);
	  		if(hasright(tree[now]))
	  			order(tree[now].right,tree,out);
	  	
  		}
  		
  	 	static void slove(InputReader in, PrintWriter out){
  	 		int cases = in.nextInt();
  	 		for(int i=0; i<cases; i++){
  	 			boolean answer = true;
  	 			int nodes = in.nextInt();
  	 			if(nodes<=0)
  	 				answer = false;
  	 			else{
  	 			node[] tree = new node[nodes+1];
  	 			for(int j=1; j<=nodes; j++){
  	 				node t = new node();
  	 				t.value = j;
  	 				tree[j] = t;
  	 			}
  	 			for(int j=1; j<=nodes; j++){
  	 				int a = in.nextInt();
  	 				int b = in.nextInt();
  	 				if(a!=0){
  	 					tree[j].left = a;
  	 					tree[a].father = j;
  	 				}
  	 				if(b!=0){
  	 					tree[j].right = b;
  	 					tree[b].father = j;
  	 				}
  	 			}
  	 			int root = 0;
  	 			for(int j=1; j<=nodes; j++){
  	 				if(tree[j].father==0){
  	 					root = j;
  	 					break;
  	 				}
  	 			}
  	 			int max = 0;
  	 			int test = nodes;
  	 			while(test/2>0){
  	 				max++;
  	 				test = test/2;
  	 			}
  	 			int height[] = new int[max+1];
  	 			for(int j=1; j<=nodes; j++){
  	 				int d = 0;
  	 				node now = tree[j];
  	 				if(now==tree[root])
  	 					tree[j].height = 0;
  	 				else{
  	 					while(now.father!=root){
  	 						d++;
  	 						now = tree[now.father];
  	 					}
  	 					tree[j].height = d+1;
  	 				}
  	 				if(tree[j].height>max){
  	 					answer = false;
  	 					break;
  	 				}
  	 				else
  	 					height[tree[j].height]++;
  	 			}
  	 			if(answer){
  	 				for(int j=0; j<max; j++){
  	 					if(height[j]!=(int)Math.pow(2, j)){
  	 						answer= false;
  	 						break;
  	 					}
  	 				}
  	 			}     //除最后一层每层都符合
  	 			if(answer){
  	 				int before = (int)Math.pow(2, max);
  	 				if(height[max] != before){      //最后一层不满
  	 					for(int j=before; j<=nodes; j++){
  	 						int[] binary = new int[max+1];
  	 						int now = j;
  	 						for(int k=max; k>=0; k--){
  	 							binary[k] = now%2;
  	 							now = now/2;
  	 						}
  	 						node check = tree[root];
  	 						for(int k=1; k<=max; k++){
  	 							if(binary[k]%2==0){
  	 								if(check.left==0)
  	 								{
  	 									answer = false;
  	 									break;
  	 								}
  	 								else{
  	 									check = tree[check.left];
  	 								}
  	 							}
  	 							else if(binary[k]%2==1){
  	 								if(check.right==0){
  	 									answer = false;
  	 									break;
  	 								}
  	 								else
  	 									check = tree[check.right];
  	 							}
  	 						}
  	 					}
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