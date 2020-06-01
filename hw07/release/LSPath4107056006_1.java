import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
public class LSPath4107056006_1 extends LSPath{
	private ArrayList<ArrayList<Integer>> adjList;
	private Queue q;
	private boolean[] visited;
	private int[] distTo;
	private int[] edgeTo;
	public LSPath4107056006_1() {
		q = new Queue();
	}
	@Override
	public int Ans(int[][] array) {
		// TODO Auto-generated method stub
		
		adjList = new ArrayList<ArrayList<Integer>>(array.length);
		
		//create adjList for the graph
		for(int i=0;i<array.length;i++) {
			ensureCapaticy(adjList,array[i][0]);
			ensureCapaticy(adjList,array[i][1]);
			if(adjList.get(array[i][0])==null) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(array[i][1]);
				adjList.set(array[i][0],temp);
			}else {
				if(!adjList.get(array[i][0]).contains(array[i][1]))
					adjList.get(array[i][0]).add(array[i][1]);
			}
			if(adjList.get(array[i][1])==null) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(array[i][0]);
				adjList.set(array[i][1],temp);
			}else {
				if(!adjList.get(array[i][1]).contains(array[i][0]))
					adjList.get(array[i][1]).add(array[i][0]);
			}
		}
		
		visited = new boolean[adjList.size()];
		distTo = new int [adjList.size()];
		edgeTo = new int [adjList.size()];
		
		
		int minNode = -1;
		int minSize = Integer.MAX_VALUE;
		for(int i=0;i<adjList.size();i++) {
			if(adjList.get(i).size()<minSize) {
				minSize = adjList.get(i).size();
				minNode = i;
			}
		}
		
		bfs(minNode);
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<distTo.length;i++) {
			if(distTo[i] > max)
				max = distTo[i];
			System.out.println("i = "+i+", dist = "+distTo[i]);
		}
		
		
		
		return max;
	}
	public void bfs(int s) {
		q.push(s);
		visited[s] = true;
		distTo[s] = 0;
		while(!q.isEmpty()) {
			int v = q.pop();
			for(int node:adjList.get(v)) {
				if(!visited[node]) {
					visited[node] = true;
					q.push(node);
					edgeTo[node] = v;
					distTo[node] = distTo[v] + 1;
				}
			}
		}
	}
	public void ensureCapaticy(ArrayList arr,int size) {
		arr.ensureCapacity(size);
		while(arr.size()<=size) {
			arr.add(null);
		}
	}
	class Queue{
		private ArrayList<Integer> queue;
		private int p = 0;
		public Queue() {
			queue = new ArrayList<Integer>();
		}
		public void push(int x) {
			queue.add(x);
			p++;
		}
		public int pop() {
			int t = queue.get(--p);
			queue.remove(p);
			return t;
		}
		public boolean isEmpty() {
			return queue.isEmpty();
		}
	}
}
