package week9;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//class bnode{
//	ArrayList<Integer> next = new ArrayList<Integer>();
//	ArrayList<Integer> wei = new ArrayList<Integer>();
//	boolean ru = false;
//	int distance = java.lang.Integer.MAX_VALUE;
//	int value;
//	bnode(int i){
//		this.value = i;
//	}
//	
//}
public class D3{
	static PrintWriter out;
    static Reader in;
	public static class MinComparator implements Comparator<bnode>{
		public int compare(bnode first, bnode second) {
			if (second.distance < first.distance) {
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
	        for(int i=0; i<cases; i++){
	        	int n = in.nextInt();
	        	int m = in.nextInt();
	        	int q = in.nextInt();
	        	bnode[] tree = new bnode[n+1];
	        	int minwei = java.lang.Integer.MAX_VALUE;
	        	int u = 0, v=0;
	        	for(int j=0; j<n+1; j++){
	        		tree[j] = new bnode(j);
	        	}
	        	for(int j=0; j<m+q; j++){
	        		int x = in.nextInt();
	        		int y = in.nextInt();
	        		int z = in.nextInt();
	        		tree[x].next.add(y);
	        		tree[x].wei.add(z);
	        		tree[y].next.add(x);
	        		tree[y].wei.add(z);
	        		if(minwei>z){
	        			minwei=z;
	        			u=x;
	        			v=y;
	        		}
	        	}
	        	PriorityQueue<bnode> now = new PriorityQueue<bnode>(new MinComparator());
	        	now.add(tree[u]);
	        	int answer = 0;
	        	int count = 0;
	        	tree[u].distance = 0;
	        	while(!now.isEmpty()){
	        		bnode top = now.poll();
	        		if(tree[top.value].ru==false){
	        			tree[top.value].ru = true;
	        			answer = answer+top.distance;
	        			count++;
	        			int stop = 0;
	        			for(int j=0; j<top.next.size(); j++){
	        				if(tree[top.next.get(j)].ru==false){
	        					stop++;
	        					if(top.wei.get(j)<tree[top.next.get(j)].distance)
	        						tree[top.next.get(j)].distance = top.wei.get(j);
	        					now.add(tree[top.next.get(j)]);
	        				}
	        			}
	        			if(stop==0)
	        				break;
	        			}
	        		}
	        	if(count<n)
	        		out.println(-1);
	        	else
	        		out.println(answer);
	        	
	     
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
