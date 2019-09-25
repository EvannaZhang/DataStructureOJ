package week9;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class gnode{
	ArrayList<Integer> next = new ArrayList<Integer>();
	ArrayList<Integer> wei = new ArrayList<Integer>();
	int[] distance = new int[7];
	boolean[] ru = new boolean[7];
}
class pair{
	int node;
	int distance;
}


public class G2 {
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
	public static void main(String[] args)throws IOException{
		  	out = new PrintWriter(System.out);
	        in = new Reader();	
	        int cases = in.nextInt();
	        for(int i=0; i<cases; i++){
	        	int nodes = in.nextInt();
	        	int line = in.nextInt();
	        	int go = in.nextInt();
	        	gnode[] tree = new gnode[nodes+1];
	        	for(int j=0; j<nodes+1; j++)
	        		tree[j] = new gnode();
	        	for(int j=0; j<line; j++){
	        		int x = in.nextInt();
	        		int y = in.nextInt();
	        		int z = in.nextInt();
	        		tree[x].next.add(y);
	        		tree[x].wei.add(z);
	        		tree[y].next.add(x);
	        		tree[y].wei.add(z);
	        	}
	        	int[] must = new int[go];
	        	for(int j=0; j<go; j++){
	        		must[j] =in.nextInt();
	        	}	
	        	for(int j=0; j<nodes+1; j++)
        			tree[j].distance[5] = java.lang.Integer.MAX_VALUE;
        		tree[1].distance[5] = 0;
        		PriorityQueue<pair> check5 = new PriorityQueue<pair>(new MinComparator());
        		pair first = new pair();
        		first.distance = 0;
        		first.node = 1;
        		check5.add(first);
        		while(!check5.isEmpty()){
        			pair top = check5.poll();
        			if(tree[top.node].ru[5]==false){
        				tree[top.node].ru[5]= true;
	        			for(int j=0; j<tree[top.node].next.size(); ++j){
	        				int son = tree[top.node].next.get(j);
	        				if(tree[son].ru[5]==false){
	        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[5])
	        						tree[son].distance[5] = top.distance+tree[top.node].wei.get(j);
	        					pair second = new pair();
	        					second.distance = tree[son].distance[5];
	        					second.node = son;
	        					check5.add(second);
	        				}
	        			} 
	        		}
	        }
	        for(int j=0; j<nodes+1; j++)
    			tree[j].distance[6] = java.lang.Integer.MAX_VALUE;
    		tree[nodes].distance[6] = 0;
	        PriorityQueue<pair> check6 = new PriorityQueue<pair>(new MinComparator());
	        pair first6 = new pair();
    		first6.distance = 0;
    		first6.node = nodes;
	        check6.add(first6);
	        while(!check6.isEmpty()){
	        	pair top = check6.poll();
	        	if(tree[top.node].ru[6]==false){
	        		tree[top.node].ru[6]= true;
	        			for(int j=0; j<tree[top.node].next.size(); ++j){
	        				int son = tree[top.node].next.get(j);
	        				if(tree[son].ru[6]==false){
	        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[6])
	        						tree[son].distance[6] = top.distance+tree[top.node].wei.get(j);
	        					pair second = new pair();
	        					second.distance = tree[son].distance[6];
	        					second.node = son;
	        					check6.add(second);
	        				}
	        			} 
	        		}
	        }
	        	if(go>0){  //至少1
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[0] = java.lang.Integer.MAX_VALUE;
	        		tree[must[0]].distance[0] = 0;
	        	PriorityQueue<pair> check = new PriorityQueue<pair>(new MinComparator());
	        	pair first0 = new pair();
	        	first0.distance = 0;
	    		first0.node = must[0];
		        check.add(first0);
		        while(!check.isEmpty()){
		        	pair top = check.poll();
		        	if(tree[top.node].ru[0]==false){
		        		tree[top.node].ru[0]= true;
		        			for(int j=0; j<tree[top.node].next.size(); ++j){
		        				int son = tree[top.node].next.get(j);
		        				if(tree[son].ru[0]==false){
		        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[0])
		        						tree[son].distance[0] = top.distance+tree[top.node].wei.get(j);
		        					pair second = new pair();
		        					second.distance = tree[son].distance[0];
		        					second.node = son;
		        					check.add(second);
		        				}
		        			} 
		        		}
		        }
	        	}
	        	if(go>1){ //至少2
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[1] = java.lang.Integer.MAX_VALUE;
	        		tree[must[1]].distance[1] = 0;
	        		PriorityQueue<pair> check = new PriorityQueue<pair>(new MinComparator());
	        		first.distance = 0;
		    		first.node = must[1];
			        check.add(first);
			        while(!check.isEmpty()){
			        	pair top = check.poll();
			        	if(tree[top.node].ru[1]==false){
			        		tree[top.node].ru[1]= true;
			        			for(int j=0; j<tree[top.node].next.size(); ++j){
			        				int son = tree[top.node].next.get(j);
			        				if(tree[son].ru[1]==false){
			        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[1])
			        						tree[son].distance[1] = top.distance+tree[top.node].wei.get(j);
			        					pair second = new pair();
			        					second.distance = tree[son].distance[1];
			        					second.node = son;
			        					check.add(second);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>2){  //至少3
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[2] = java.lang.Integer.MAX_VALUE;
	        		tree[must[2]].distance[2] = 0;
	        		PriorityQueue<pair> check = new PriorityQueue<pair>(new MinComparator());
	        		first.distance = 0;
		    		first.node = must[2];
			        check.add(first);
			        while(!check.isEmpty()){
			        	pair top = check.poll();
			        	if(tree[top.node].ru[2]==false){
			        		tree[top.node].ru[2]= true;
			        			for(int j=0; j<tree[top.node].next.size(); ++j){
			        				int son = tree[top.node].next.get(j);
			        				if(tree[son].ru[2]==false){
			        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[2])
			        						tree[son].distance[2] = top.distance+tree[top.node].wei.get(j);
			        					pair second = new pair();
			        					second.distance = tree[son].distance[2];
			        					second.node = son;
			        					check.add(second);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>3){
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[3] = java.lang.Integer.MAX_VALUE;
	        		tree[must[3]].distance[3] = 0;
	        		PriorityQueue<pair> check = new PriorityQueue<pair>(new MinComparator());
	        		first.distance = 0;
		    		first.node = must[3];
			        check.add(first);
			        while(!check.isEmpty()){
			        	pair top = check.poll();
			        	if(tree[top.node].ru[3]==false){
			        		tree[top.node].ru[3]= true;
			        			for(int j=0; j<tree[top.node].next.size(); ++j){
			        				int son = tree[top.node].next.get(j);
			        				if(tree[son].ru[3]==false){
			        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[3])
			        						tree[son].distance[3] = top.distance+tree[top.node].wei.get(j);
			        					pair second = new pair();
			        					second.distance = tree[son].distance[3];
			        					second.node = son;
			        					check.add(second);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	if(go>4){
	        		for(int j=0; j<nodes+1; j++)
	        			tree[j].distance[4] = java.lang.Integer.MAX_VALUE;
	        		tree[must[4]].distance[4] = 0;
	        		PriorityQueue<pair> check = new PriorityQueue<pair>(new MinComparator());
	        		first.distance = 0;
		    		first.node = must[4];
			        check.add(first);
			        while(!check.isEmpty()){
			        	pair top = check.poll();
			        	if(tree[top.node].ru[4]==false){
			        		tree[top.node].ru[4]= true;
			        			for(int j=0; j<tree[top.node].next.size(); ++j){
			        				int son = tree[top.node].next.get(j);
			        				if(tree[son].ru[4]==false){
			        					if(top.distance+tree[top.node].wei.get(j)<tree[son].distance[4])
			        						tree[son].distance[4] = top.distance+tree[top.node].wei.get(j);
			        					pair second = new pair();
			        					second.distance = tree[son].distance[4];
			        					second.node = son;
			        					check.add(second);
			        				}
			        			} 
			        		}
			        }
	        	}
	        	int answer = java.lang.Integer.MAX_VALUE;
	        	if(go==1){
	        			int now = 0; 
	        			now = now + tree[must[0]].distance[5];
	        			now = now + tree[must[0]].distance[6];
	        		if(now<answer)
	        			answer = now;
	        	}
	        	else if(go==2){
	        		int now1 = 0;
	        		now1 = now1 + tree[must[0]].distance[5];
	        		now1 = now1 + tree[must[1]].distance[0];
	        		now1 = now1 + tree[must[1]].distance[6];
	        		if(now1< answer)
	        			answer = now1;
	        		int now2 = 0;
	        		now2 = now2 + tree[must[1]].distance[5];
	        		now2 = now2 + tree[must[1]].distance[0];
	        		now2 = now2 + tree[must[0]].distance[6];
	        		if(now2< answer)
	        			answer = now2;
	        	}
	        	else if(go==3){
	        		for(int j=0; j<3; j++){
	        			for(int k=0; k<3; k++){
	        				if(k!=j){
	        					for(int l = 0; l<3; l++){
	        						if(l!=j&&l!=k)
	        						{
	        							int now = 0;
	        							now = now + tree[must[j]].distance[5];
	        							now = now + tree[must[k]].distance[j];
	        							now = now + tree[must[l]].distance[k];
	        							now = now + tree[must[l]].distance[6];
	        							if(now<answer)
	        								answer = now;
	        						}
	        					
	        				}
	        			}
	        			}
	        		}
	        	}
	        	else if(go==4){
	        		for(int j=0; j<4; j++){
	        			for(int k=0; k<4; k++){
	        				if(k!=j){
	        					for(int l = 0; l<4; l++){
	        						if(l!=j&&l!=k)
	        						{
	        							for(int m=0; m<4; m++){
	        								if(m!=j&&m!=k&&m!=l){
	        									int now = 0;
	        									now = now + tree[must[j]].distance[5];
	        									now = now + tree[must[k]].distance[j];
	        									now = now + tree[must[l]].distance[k];
	        									now = now + tree[must[m]].distance[l];
	        									now = now + tree[must[m]].distance[6];
	        									if(now<answer)
	        										answer = now;
	        								}
	        							}
	        							
	        						}
	        					
	        				}
	        			}
	        			}
	        		}
	        	}
	        	else if(go==5){
	        		for(int j=0; j<5; j++){
	        			for(int k=0; k<5; k++){
	        				if(k!=j){
	        					for(int l = 0; l<5; l++){
	        						if(l!=j&&l!=k)
	        						{
	        							for(int m=0; m<5; m++){
	        								if(m!=j&&m!=k&&m!=l){
	        									for(int p=0; p<5; p++){
	        										if(p!=j&&p!=k&&p!=l&&p!=m){
	        											int now = 0;
	        											now = now + tree[must[j]].distance[5];
	        											now = now + tree[must[k]].distance[j];
	        											now = now + tree[must[l]].distance[k];
	        											now = now + tree[must[m]].distance[l];
	        											now = now + tree[must[p]].distance[m];
	        											now = now + tree[must[p]].distance[6];
	        											if(now<answer)	
	        												answer = now;
	        										}
	        									}
	        									
	        								}
	        							}
	        							
	        						}
	        					
	        				}
	        			}
	        			}
	        		}
	        	}
	        
	        	
	        	out.println(answer);
	        }
	        out.close();
	      	}
	      	static class Reader{
	      		
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


