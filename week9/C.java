package week9;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import week9.D4.MinComparator;
import week9.D4.Reader;

class bnode{
	ArrayList<Integer> next = new ArrayList<Integer>();
	ArrayList<Integer> wei = new ArrayList<Integer>();
	boolean ru = false;
}
class pair{
	int node;
	int distance;
}

public class C {
	static PrintWriter out;
    static Reader in;
	public static class MinComparator implements Comparator<pair>{
		public int compare(pair first, pair second) {
			if (second.distance < first.distance) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	static boolean dj(int n,PriorityQueue<pair> now, bnode[] tree, int count, int answer, int key, int[] check){
		while(!now.isEmpty()){
    		pair top = now.poll();
    		if(check[top.node]==0){
    			check[top.node] = 1;
    			count++;
    			answer = answer+top.distance;
    			for(int j=0; j<tree[top.node].next.size(); j++){
    				int son = tree[top.node].next.get(j);
    				if(check[son]==0){
    					pair t = new pair();
    					t.node = son;
    					t.distance = tree[top.node].wei.get(j);
    					if(t.distance>=key)
    						now.add(t);
    				}
    			}
    		}
    	}
		if(count>=n)
			return true;
		else
			return false;
	}
	public static void main(String[] args)throws IOException{
		  out = new PrintWriter(System.out);
	        in = new Reader();
	        int cases = in.nextInt();
	        for(int i=0; i<cases; i++){
	        	int n = in.nextInt();
	        	int m = in.nextInt();
	        	bnode[] tree = new bnode[n+1];
	        	for(int j=0; j<n+1; j++){
	        		tree[j] = new bnode();
	        	}
	        	for(int j=0; j<m; j++){
	        		int x = in.nextInt();
	        		int y = in.nextInt();
	        		int z = in.nextInt();
	        		tree[x].next.add(y);
	        		tree[x].wei.add(z);
	        		tree[y].next.add(x);
	        		tree[y].wei.add(z);
	        	}
	        	
	        	int key= 0;
	        	int low = 0;
	        	int high = 1000;
	        	int lastkey = 0;
	        	while(low <= high){
	        	
	        		PriorityQueue<pair> now = new PriorityQueue<pair>(new MinComparator());
	        		int[] check = new int[n+1];
		        	pair first = new pair();
		        	first.node = 1;
		        	first.distance = 0;
		        	now.add(first);
		        	int answer = 0;	
		        	key = (low+high)/2;
	        		boolean time = dj(n, now, tree, 0, answer, key, check);
	        	//	System.out.print(key+" ");
	        	//	System.out.println(time);
	        		if(time){
	        			low = key + 1;
	        			lastkey = key;
	        		}
	        		else
	        			high = key - 1;
	        		
	        	}
	        //	System.out.println(key);
	        
	        	PriorityQueue<pair> now = new PriorityQueue<pair>(new MinComparator());
	        	int answer = 0;
	        	pair first = new pair();
	        	first.node = 1;
	        	first.distance = 0;
	        	now.add(first);
	        	while(!now.isEmpty()){
	        		pair top = now.poll();
	        		if(tree[top.node].ru==false){
	        			tree[top.node].ru = true;
	        			answer = answer+top.distance;
	        			for(int j=0; j<tree[top.node].next.size(); j++){
	        				int son = tree[top.node].next.get(j);
	        				if(tree[son].ru==false){
	        					pair t = new pair();
	        					t.node = son;
	        					t.distance = tree[top.node].wei.get(j);
	        					if(t.distance>=lastkey)
	        						now.add(t);
	        				}
	        			}
	        		}
	        	}
	        	System.out.println(answer);
	        	
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

