package week6;
import java.util.*;

class Treenode{
	ArrayList<Treenode> son = new ArrayList<Treenode>();
	Treenode father;
	ArrayList<Integer> depth = new ArrayList<Integer>();
	int largest;
}
public class F {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			
			int nodes = input.nextInt();
			int[][] store = new int[nodes+1][2];
			boolean answer = false;
			Treenode[] tree = new Treenode[nodes+1];
			for(int j=1; j<=nodes; j++){
				Treenode now = new Treenode();
				tree[j] = now;
			}
			for(int j=1; j<=nodes; j++){
				store[j][0] = input.nextInt();
			}
			for(int j=1; j<nodes; j++){
				int father = input.nextInt();
				int son = input.nextInt();
				tree[father].son.add(tree[son]);
				tree[son].father = tree[father];
			}
			//算深度
			for(int j=1; j<nodes+1; j++){
				int d = 0;
				Treenode temp = tree[j];
				while(temp.father!=null){
					d++;
					temp = temp.father;
				}
				tree[j].largest = d;
			}
			for(int j=1; j<=nodes; j++){
				if(store[j][0]==1)
						store[tree[j].largest][1] = store[tree[j].largest][1]+1;
			}
			for(int j=0; j<nodes; j++){
				if(store[j][1]%2==1){
					answer = true;
					break;
				}
			}
			
			if(answer)
				System.out.println("YES");
			if(!answer)
				System.out.println("NO");
			
		}//each case
	}

}
