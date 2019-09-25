package week6;
import java.util.*;

class Treenode{
	ArrayList<Treenode> son = new ArrayList<Treenode>();
	Treenode father;
	ArrayList<Integer> depth = new ArrayList<Integer>();
	int largest;

}

public class D2 {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int nodes = input.nextInt();
			Treenode[] tree = new Treenode[nodes+1];
			for(int j=1; j<=nodes; j++){
				Treenode now = new Treenode();
				tree[j] = now;
			}
			for(int j=1; j<nodes; j++){
				int father = input.nextInt();
				int son = input.nextInt();
				tree[father].son.add(tree[son]);
				tree[son].father = tree[father];
			}
			for(int j=1; j<=nodes; j++){
				if(tree[j].son.size()<1){
					int d = 0;
					tree[j].depth.add(d);
					Treenode leaf = tree[j];
					while(leaf.father!=null){
						leaf = leaf.father;
						d++;
						leaf.depth.add(d);
					}
				}
			}
			for(int j=1; j<=nodes; j++){
				int largest = 0;
				if(tree[j].depth.size()==1){
					largest = tree[j].depth.get(0);
				}
				else if(tree[j].depth.size()>1){
					for(int k=0; k<tree[j].depth.size(); k++){
						if(tree[j].depth.get(k)>largest){
							largest = tree[j].depth.get(k);
					}
				}
				}
				tree[j].largest = largest;
			}	
			int max = 0;
			int node = 0;
			for(int j=1; j<=nodes; j++){
				
				if(tree[j].son.size()>1){
					int first = 0;
					int second = 0;
					for(int k=0; k<tree[j].son.size(); k++){
						if(tree[j].son.get(k).largest>=first){
							second = first;
							first = tree[j].son.get(k).largest;
						}
						else if(tree[j].son.get(k).largest>second){
							second = tree[j].son.get(k).largest;
						}
					}
				
				if(first+second+2>max){
					max = first+second+2;
					node = j;
				}
				}
				}
			System.out.println(max);
			
		}
	}
}
