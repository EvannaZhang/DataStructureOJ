package week9;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
class hnode{
	int x,y,z,r;
	double distance = java.lang.Integer.MAX_VALUE;
	boolean check = false;
}
class hpair{
	int node;
	double distance;
}
public class H {
	static PrintWriter out;
    static Reader in;
    public static class MinComparator implements Comparator<hpair>{
  		public int compare(hpair first, hpair second) {
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
	        	int N = in.nextInt();
	        	hnode[] tree = new hnode[N+3];
	        	for(int j=0; j<N+3; j++){
	        		tree[j] = new hnode();
	        	}
	        	for(int j=0; j<N; j++){
	        		int x = in.nextInt();
	        		int y = in.nextInt();
	        		int z = in.nextInt();
	        		int w = in.nextInt();
	        		tree[j].x = x;
	        		tree[j].y = y;
	        		tree[j].z = z;
	        		tree[j].r = w;
	        	}
	        	tree[N].x = in.nextInt();
	        	tree[N].y = in.nextInt();
	        	tree[N].z = in.nextInt();
	        	tree[N].r = 0;
	        	tree[N].distance = 0;
	        	tree[N+1].x = in.nextInt();
	        	tree[N+1].y = in.nextInt();
	        	tree[N+1].z = in.nextInt();
	        	tree[N+1].r = 0;
	        	PriorityQueue<hpair> now = new PriorityQueue<hpair>(new MinComparator());
	        	hpair first = new hpair();
	        	first.distance = 0;
	        	first.node = N;
	        	now.add(first);
	        	while(!now.isEmpty()){
	        		hpair top = now.poll();
	        		if(tree[top.node].check==false){
	        			tree[top.node].check = true;
	        			for(int j=0; j<N+2; j++){
	        				double dx = Math.pow(Math.abs(tree[top.node].x - tree[j].x),2);
	        				double dy = Math.pow(Math.abs(tree[top.node].y - tree[j].y),2);
	        				double dz = Math.pow(Math.abs(tree[top.node].z - tree[j].z),2);
	        				double d = Math.pow(dx+dy+dz, 0.5);
	        				d = d - tree[top.node].r - tree[j].r;
	        				if(d<0)
	        					d=0;
	        				if(top.distance+d < tree[j].distance)
	        					tree[j].distance = top.distance+d;
	        				if(tree[j].check==false){
	        					hpair second = new hpair();
	        					second.node = j;
	        					second.distance = tree[j].distance;
	        					now.add(second);
	        				}
	        			}
	        		}
	        	}
	        	double answer = tree[N+1].distance;
	        	double ddx = Math.pow(Math.abs(tree[N+1].x - tree[N].x),2);
	         	double ddy = Math.pow(Math.abs(tree[N+1].y - tree[N].y),2);
	         	double ddz = Math.pow(Math.abs(tree[N+1].z - tree[N].z),2);
				double dd = Math.pow(ddx+ddy+ddz, 0.5);
				if(dd<answer)
					answer =dd;
				out.println(Math.round(answer*100));
	        	
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
