package week6;

import java.util.ArrayList;
import java.util.Scanner;

class Treenode{
	static ArrayList<Treenode> arr = new ArrayList<Treenode>();
	int value = 0;
	public Treenode(int value){
		this.value = value;
	}
}
public class Tree {
		
/*		
static int findmax(Treenode a, f){
		int first = 0;
		for(int i=0; i<a.arr.size(); i++){
			if(findmax(a.arr.get(i),d)>max)
				first = findmax(a.arr.get(i),d);
		}
		
		
	}*/
	static void findmax(Treenode a,int[][] depth, int d){
			depth[a.value][0] = 1;
			depth[a.value][1] = 0;
			if(a.arr.size()<1)
				return;
			else{
				 
				int[] test = new int[a.arr.size()];
			    
				for(int j=0; j<a.arr.size(); j++){
					Treenode n = a.arr.get(j);
					test[j] = findmax(n,depth,d);
				}
				
				int ans = 0;
				int posi = 0;
				for(int i=0; i<a.arr.size(); i++){
					if(test[i]>ans){
						ans = test[i];
						posi = i;
					}	
				}
				Treenode now = a.arr.get(posi);
					if(depth[a.value][0]>=depth[now.value][0]+1)
						depth[a.value][0] = depth[a.value][0];
					else
						depth[a.value][0] = depth[now.value][0]+1;
					int max = 0;
					if(depth[now.value][0]>=depth[now.value][1])
						max = depth[now.value][0];
					else
						max = depth[now.value][1];
					if(depth[a.value][1]<max)
						depth[a.value][1] = max;
					if(depth[a.value][0] +depth[a.value][1] > d)
						d = depth[a.value][0] +depth[a.value][1];
				
			return;
			}
	
  	}
	

	
	public static void main(String[] args){	
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i=0; i<cases; i++){
			int nodes = input.nextInt();
			Treenode[] tree = new Treenode[nodes+1];
			for(int j=1; j<=nodes; j++){
				tree[j] =  new Treenode(j);
			}
			for(int j=1; j<nodes; j++){
				int father = input.nextInt();
				int child = input.nextInt();
				tree[father].arr.add(tree[child]);
			}
			int[][] depth = new int[nodes+1][2];
			System.out.print(findmax(tree[1],depth,0));
	}
	}	
}
