package week6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
	  	static void preorder(int number, int i,int[][]edge,Queue<Integer> queue){
	  		queue.offer(i);
	  		if(hasleft(edge,i))
	  			preorder(number,edge[i][0],edge,queue);
	  		if(hasright(edge,i))
	  			preorder(number,edge[i][1],edge,queue);
	  	}
	  	
	  	static void inorder(int number, int i,int[][]edge, Queue<Integer> queue){
	  		if(hasleft(edge,i))
	  			inorder(number,edge[i][0],edge,queue);
	  		queue.offer(i);
	  		if(hasright(edge,i))
	  			inorder(number,edge[i][1],edge,queue);
	  		
	  	}
	  	static void postorder(int number, int i,int[][]edge, Queue<Integer> queue){
	  		if(hasleft(edge,i))
	  			postorder(number,edge[i][0],edge,queue);
	  		if(hasright(edge,i))
	  			postorder(number,edge[i][1],edge,queue);
	  		queue.offer(i);
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
	  			
	  			Queue<Integer> queue = new LinkedList<Integer>();
	  			preorder(nodes,1,edge,queue);
	  			for(int j=0; j<nodes-1; j++){
	  				out.print(queue.poll()+" ");
	  			}
	  			out.println(queue.poll());
	  			
	  			Queue<Integer> qu = new LinkedList<Integer>();
	  			inorder(nodes,1,edge,qu);
	  			for(int j=0; j<nodes-1; j++){
	  				out.print(qu.poll()+" ");
	  			}
	  			out.println(qu.poll());
	  			
	  			Queue<Integer> q = new LinkedList<Integer>();
	  			postorder(nodes,1,edge,q);
	  			for(int j=0; j<nodes-1; j++){
	  				out.print(q.poll()+" ");
	  			}
	  			out.println(q.poll());
	  		}
	  		
	  	}
	  
}
