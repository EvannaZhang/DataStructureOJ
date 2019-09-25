package week9;
import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class fnode{
	ArrayList<Integer> next = new ArrayList<Integer>();
	ArrayList<Integer> w = new ArrayList<Integer>();
	int distance1 = java.lang.Integer.MAX_VALUE;
	int distance2 = java.lang.Integer.MAX_VALUE;
	boolean ru1 = false;
	boolean ru2 = false;
}


public class F {
	static PrintWriter out;
    static Reader in;
    
	public static class MinComparator implements Comparator<fnode>{
		public int compare(fnode first, fnode second) {
			if (second.distance1 < first.distance1) {
				return 1;
			} else {
				return -1;
			}
	}
}
	public static class MinComparator2 implements Comparator<fnode>{
		public int compare(fnode first, fnode second) {
			if (second.distance2 < first.distance2) {
				return 1;
			} else {
				return -1;
			}
	}
}
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
	        	tree[s].distance1 = 0;
	        	tree[t].distance2 = 0;
	        	
	        	PriorityQueue<fnode> check = new PriorityQueue<fnode>(new MinComparator());
	        	check.add(tree[s]);
	        	while(!check.isEmpty()){
	        		fnode top = check.poll();
	        		if(top.ru1==false){
	        			top.ru1 = true;
	        			for(int j=0; j<top.next.size(); ++j){
	        				int son = top.next.get(j);
	        				if(tree[son].ru1==false){
	        					if(top.distance1+top.w.get(j)<tree[son].distance1)
	        						tree[son].distance1 = top.distance1+top.w.get(j);
	        					check.add(tree[son]);
	        				}
	        			} 
	        		}
	        	}
	        	
	        	PriorityQueue<fnode> check2 = new PriorityQueue<fnode>(new MinComparator2());
	        	check2.add(tree[t]);
	        	while(!check2.isEmpty()){
	        		fnode top = check2.poll();
	        		if(top.ru2==false){
	        			top.ru2 = true;
	        		for(int j=0; j<top.next.size(); ++j){
        				int son = top.next.get(j);
        				if(tree[son].ru2==false){
        					if(top.distance2+top.w.get(j)<tree[son].distance2)
        						tree[son].distance2 = top.distance2+top.w.get(j);
        					check2.add(tree[son]);
        				}
	        		}
	        		}
	        	}
	        	int [] distance = new int[n+1];
	        	for(int j=1; j<n+1; ++j){
	        		distance[j] = Math.max(tree[j].distance1,tree[j].distance2);
	        	}
	        	long min = java.lang.Long.MAX_VALUE;
	        	for(int j=1; j<n+1; ++j){
	        		if(min>distance[j])
	        			min = distance[j];
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
