import java.util.ArrayList;
public class LSPath4107056006_2 extends LSPath{
	
	//multiBFS method
	
	//1: U ←∅{the set of processed vertices}
	//2: for i ← 1 to k do
	//3: 	if i = 1 then
	//4: 		Let vi ∈ V be an arbitrary vertex
	//5: 	else
	//6: 		Let vi ∈ V be a vertex with maximal d(vi, U)
	//7: 	U ← U + vi
	//8: 	Perform a breadth first search from vi and find its eccentricity e(vi)
	//9: return D¯ = max v∈U e(v) as an approximation for the diameter of G
	
	private ArrayList<ArrayList<Integer>> adjList;
	private boolean[] visited;
	private int[] distTo;
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
		distTo = new int[adjList.size()];
		return multiBFS(adjList,5);
	}
	
	//core algorithm
	public int multiBFS(ArrayList<ArrayList<Integer>> adjList,int k) {
		ArrayList<Integer> U = new ArrayList<Integer>();
		ArrayList<Integer> ev = new ArrayList<Integer>();
		int[] d = new int[adjList.size()];
		for(int i=0;i<d.length;i++) {
			d[i] = Integer.MAX_VALUE;
		}
		int v = 1;
		for(int i=0;i<k;i++) {
			if(i==0) {
				int maxSize = Integer.MIN_VALUE;
				for(int t=0;t<adjList.size();t++) {
					if(adjList.get(t) != null) {
						if(adjList.get(t).size() > maxSize) {
							maxSize = adjList.get(t).size();
							v = t;
						}
					}
				}
			}else {
				int max = Integer.MIN_VALUE;
				for(int j=0;j<d.length;j++) {
					if(d[j] > max) {
						max = d[j];
						v = j;
					}
				}
			}
			if(!U.contains(v)) 
				U.add(v);
			for(int j=0;j<visited.length;j++) {
				visited[j] = false;
				distTo[j] = 0;
			}
			bfs(v);
			int evi = Integer.MIN_VALUE;
			for(int j=0;j<distTo.length;j++) {
				if(distTo[j] > evi)
					evi = distTo[j];
			}
			for(int j=0;j<distTo.length;j++) {
				d[j] = Math.min(d[j], distTo[j]); 
			}
			ev.add(evi);
		}
		int ans = Integer.MIN_VALUE;
		for(int i:ev) {
			ans = Math.max(ans, i);
		}
		return ans;
	}
	public <T> void ensureCapaticy(ArrayList<T> arr,int size) {
		arr.ensureCapacity(size);
		while(arr.size()<=size) {
			arr.add(null);
		}
	}
	public void bfs(int s) {
		Queue q = new CircularQueue(adjList.size());
		q.add(s);
		visited[s] = true;
		distTo[s] = 0;
		while(!q.isEmpty()) {
			int v = q.remove();
			for(int node:adjList.get(v)) {
				if(!visited[node]) {
					visited[node] = true;
					q.add(node);
					distTo[node] = distTo[v] + 1;
				}
			}
		}
	}
	class Queue{
		protected int[] queue;
		protected int size;
		protected int front = -1;
		protected int rear = -1;
		public Queue(int size) {
			queue = new int[size];
			this.size = size;
		}
		public void add(int x) {
			queue[++rear] = x;
		}
		public int remove() {
			return queue[++front];
		}
		public boolean isEmpty() {
			return front==rear;
		}
		public boolean isFull() {
			return rear == size - 1;
		}
	}
	class CircularQueue extends Queue{
		public CircularQueue(int size) {
			super(size);
		}
		public void add(int x) {
			rear = (rear+1)%size;
			queue[rear] = x;
		}
		public int remove() {
			front = (front+1)%size;
			return queue[front];
		}
		public boolean isFull() {
			return (rear+1)%size == front;
		}
	}
}
