package week9;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class L {
	static PrintWriter out;
    static Reader in;
    	static int linked;
    	static int d;
    	
    	static void suodian(int u, int[] dfn, int[] small, int[] id, Stack<Integer> s,ArrayList<Integer>[] son) {
    		d = d + 1;
    		dfn[u] = d;
    		small[u] = d;
    		s.push(u);
    		int size = son[u].size();
    		for(int i = 0; i < size; i++) {
    			int now = son[u].get(i);
    			if(dfn[now] == 0) {
    				suodian(now, dfn, small, id, s, son);
    				small[u] = Math.min(small[u], small[now]);
    			}
    			else if(id[now] == 0)
    				small[u] = Math.min(small[u], dfn[now]);
    		}
    		
    		if(dfn[u] == small[u]){
    			linked++;
    			while(!s.isEmpty()) {
    				int top = s.pop();
    				id[top] = linked;
    				if(top==u){
    					break;
    				}
    			}
    		}
    	}
    
    	public static void main(String[] args) throws IOException{
    		out = new PrintWriter(System.out);
	        in = new Reader();
    		int cases = in.nextInt();
    		for(int k=0; k<cases; k++) {
    			linked = 0;
        		d = 0;
    			int n = in.nextInt();
    			int m = in.nextInt();
    			ArrayList<Integer>[] son = new ArrayList[n+1];
    			for(int j = 0; j <= n; j++){
    				son[j] = new ArrayList<Integer>();
    			}
    			
    			for(int j = 0; j < m; j++) {
    				int x = in.nextInt();
    				int y = in.nextInt();
    				son[x].add(y);			
    			}
    			
    			int[] ru = new int[n+1];
    	    	int[] chu = new int[n+1];
    	    	Stack<Integer> s = new Stack<Integer>(); 
    			int[] dfn = new int[n+1];
    			int[] small = new int[n+1];
    			int[] id = new int[n+1];
    			for(int j = 1; j <= n; j++){
        			if(dfn[j]==0){
        				suodian(j, dfn, small, id, s, son);
        			}
    			}
    			if(linked == 1)
    				System.out.println(0);
    			else{
    				for(int i = 1; i <= n; i++){
    					for(int j = 0; j < son[i].size(); j++){
    						int next = son[i].get(j);
    						if(id[i] != id[next]){
    							chu[id[i]]++;
    							ru[id[next]]++;
    						}
    					}
    				}
    				int chudu = 0, rudu = 0, answer = 0;
    				for(int i = 1; i <= linked; i++) {
    					if(chu[i] == 0) 
    						chudu++;
    					if(ru[i] == 0) 
    						rudu++;
    				}
    				answer = Math.max(chudu, rudu);
    				System.out.println(answer);
    			}
    		}
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
