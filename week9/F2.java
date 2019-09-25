package week9;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//class fnode{
//	ArrayList<Integer> next = new ArrayList<Integer>();
//	ArrayList<Integer> w = new ArrayList<Integer>();
//	boolean ru1 = false;
//	boolean ru2 = false;
//}

public class F2 {
	static PrintWriter out;
    static Reader in;
   
	public static void main(String[] args)throws IOException{
		  out = new PrintWriter(System.out);
	        in = new Reader();
	        int cases = in.nextInt();
	        for(int i=0; i<cases; ++i){
	        	int n = in.nextInt();
	        	int m = in.nextInt();
	        	fnode[] tree = new fnode[n+1];
	        	for(int j=0; j<n+1; ++j){
	        		tree[j] = new fnode();
	        	}
	        	for(int j=0; j<m; ++j){
	        		int u = in.nextInt();
	        		int v = in.nextInt();
	        		int w = in.nextInt();
	        		tree[u].next.add(v);
	        		tree[u].w.add(w);
	        		tree[v].next.add(u);
	        		tree[v].w.add(w);
	        	}
	        	int s = in.nextInt();
	        	int t = in.nextInt();
	        	long[][] distance = new long[n+1][3];
	        	
	        	for(int j=0; j<n+1; ++j){
	        		distance[j][0]=java.lang.Long.MAX_VALUE;
	        		distance[j][1]=java.lang.Long.MAX_VALUE;
	        	}
	        	
	        	
	        	distance[s][0] = 0;
	        	distance[t][1] = 0;
	        	Queue<Integer> check = new LinkedList<Integer>();
	        	check.add(s);
	        	tree[s].ru1 = true;
	        	while(!check.isEmpty()){
	        		int minnow = java.lang.Integer.MAX_VALUE;
	        		int sonnext = -1;
	        		int size = check.size();
	        		for(int q=0; q<size; q++){
	        			int top = check.poll();
	        			//each enqueue element
	        			for(int j=0; j<tree[top].next.size(); ++j){
	        				int son = tree[top].next.get(j);
	        				if(tree[son].ru1==false){
	        					int quan = tree[top].w.get(j);
	        					if(distance[top][0]+quan<distance[son][0])
	        						distance[son][0] = distance[top][0]+quan;
	        					if (minnow>quan){
	        						minnow = quan;
	        						sonnext = son;
	        					}
	        				}
	        			} //each son
	        			if(sonnext>0){
	        				check.add(sonnext);
	        				tree[sonnext].ru1 = true;
	        			}
	        			else{
	        				break;
	        			}
	        		check.add(top);
	        		}
	        	}
	        	
	        	
	        	
	        	Queue<Integer> check2 = new LinkedList<Integer>();
	        	check2.add(t);
	        	tree[t].ru2 = true;
	        	while(!check2.isEmpty()){
	        		int minnow = java.lang.Integer.MAX_VALUE;
	        		int sonnext = -1;
	        		int size = check2.size();
	        		for(int q=0; q<size; q++){
	        			int top = check2.poll();
	        			//each enqueue element
	        			for(int j=0; j<tree[top].next.size(); ++j){
	        				int son = tree[top].next.get(j);
	        				if(tree[son].ru2==false){
	        					int quan = tree[top].w.get(j);
	        					if(distance[top][1]+quan<distance[son][1])
	        						distance[son][1] = distance[top][1]+quan;
	        					if (minnow>quan){
	        						minnow = quan;
	        						sonnext = son;
	        					}
	        				}
	        			} //each son
	        			if(sonnext>0){
	        				check2.add(sonnext);
	        				tree[sonnext].ru2 = true;
	        			}
	        			else{
	        				break;
	        			}
	        		check2.add(top);
	        		}
	        	}
	        	
	        	for(int j=1; j<n+1; ++j){
	        		distance[j][2] = Math.max(distance[j][0],distance[j][1]);
	        	}
	        	long min = java.lang.Long.MAX_VALUE;
	        	for(int j=1; j<n+1; ++j){
	        		if(min>distance[j][2])
	        			min = distance[j][2];
	        	}
	        	out.println(min);
	        }
	    	out.close();
		}
		static class Reader
	    {
	        final private int BUFFER_SIZE = 1 << 16;
	        private DataInputStream din;
	        private byte[] buffer;
	        private int bufferPointer, bytesRead;
	 
	        public Reader()
	        {
	            din = new DataInputStream(System.in);
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public Reader(String file_name) throws IOException
	        {
	            din = new DataInputStream(new FileInputStream(file_name));
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public String readLine() throws IOException
	        {
	            byte[] buf = new byte[64]; // line length
	            int cnt = 0, c;
	            while ((c = read()) != -1)
	            {
	                if (c == '\n')
	                    break;
	                buf[cnt++] = (byte) c;
	            }
	            return new String(buf, 0, cnt);
	        }
	 
	        public int nextInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do
	            {
	                ret = ret * 10 + c - '0';
	            }  while ((c = read()) >= '0' && c <= '9');
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public long nextLong() throws IOException
	        {
	            long ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public double nextDouble() throws IOException
	        {
	            double ret = 0, div = 1;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	 
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	 
	            if (c == '.')
	            {
	                while ((c = read()) >= '0' && c <= '9')
	                {
	                    ret += (c - '0') / (div *= 10);
	                }
	            }
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        private void fillBuffer() throws IOException
	        {
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	            if (bytesRead == -1)
	                buffer[0] = -1;
	        }
	 
	        private byte read() throws IOException
	        {
	            if (bufferPointer == bytesRead)
	                fillBuffer();
	            return buffer[bufferPointer++];
	        }
	 
	        public void close() throws IOException
	        {
	            if (din == null)
	                return;
	            din.close();
	        }
	    }
}