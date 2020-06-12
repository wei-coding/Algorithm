
public class LSPath4107056006_4 extends LSPath{
	private ArrayList adjList;
	private boolean[] visited;
	private int[] distTo;
	@Override
	public int Ans(int[][] array) {
		// TODO Auto-generated method stub
		adjList = new ArrayList();
		//create adjList for the graph
		for(int i=0;i<array.length;i++) {
			adjList.ensureCapaticy(array[i][0]);
			adjList.ensureCapaticy(array[i][1]);
			if(adjList.get(array[i][0])==null) {
				innerArrayList temp = new innerArrayList();
				temp.add(array[i][1]);
				adjList.set(array[i][0],temp);
			}else {
				if(!adjList.get(array[i][0]).contains(array[i][1]))
					adjList.get(array[i][0]).add(array[i][1]);
			}
			if(adjList.get(array[i][1])==null) {
				innerArrayList temp = new innerArrayList();
				temp.add(array[i][0]);
				adjList.set(array[i][1],temp);
			}else {
				if(!adjList.get(array[i][1]).contains(array[i][0]))
					adjList.get(array[i][1]).add(array[i][0]);
			}
			
		}
		
		int maxNode = -1;
		int maxSize = Integer.MIN_VALUE;
		for(int i=0;i<adjList.size();i++) {
			if(adjList.get(i)!=null && adjList.get(i).size()>maxSize) {
				maxSize = adjList.get(i).size();
				maxNode = i;
			}
		}
		int k = 4;
		int v = maxNode;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<k;i++) {
			visited = new boolean[adjList.size()];
			distTo = new int [adjList.size()];
			
			bfs(v);
			
			for(int j=0;j<distTo.length;j++) {
				if(distTo[j] > max) {
					max = distTo[j];
					v = j;
				}
			}
			//System.out.println("Max is "+max);
		}
		
		return max;
	}
	public void bfs(int s) {
		Queue q = new CircularQueue(adjList.size());
		q.add(s);
		visited[s] = true;
		distTo[s] = 0;
		while(!q.isEmpty()) {
			int v = q.remove();
			//System.out.println("v = "+v);
			innerArrayList t = adjList.get(v);
			for(int i=0;i<t.size;i++) {
				int node = t.get(i);
				if(!visited[node]) {
					//System.out.println("node = "+node);
					q.add(node);
					visited[node] = true;
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
	class ArrayList{
		private innerArrayList[] arr;
		private int size;
		private int p;
		public ArrayList() {
			arr = new innerArrayList[1];
			size = 1;
			p = 0;
		}
		public void set(int p,innerArrayList x) {
			ensureCapaticy(p+1);
			arr[p] = x;
		}
		public void add(innerArrayList x) {
			arr[p++] = x;
			ensureCapaticy(p+1);
		}
		public void ensureCapaticy(int s) {
			if(s > size) {
				while(s > size)
					size = size << 2;
				innerArrayList[] newarr = new innerArrayList[size];
				for(int i=0;i<arr.length;i++) {
					newarr[i] = arr[i];
				}
				arr = newarr;
			}
		}
		public int size() {
			return size;
		}
		public innerArrayList get(int p) {
			return arr[p];
		}
	}
	class innerArrayList{
		private int[] arr;
		private int size;
		private int p;
		public innerArrayList() {
			arr = new int[1];
			size = 1;
			p = 0;
		}
		public void add(int x) {
			arr[p++] = x;
			ensureCapaticy(p+1);
		}
		public void ensureCapaticy(int s) {
			if(s > size) {
				while(s > size)
					size = size << 1;
				int[] newarr = new int[size];
				for(int i=0;i<arr.length;i++) {
					newarr[i] = arr[i];
				}
				arr = newarr;
			}
			
		}
		public int size() {
			return size;
		}
		public int get(int p) {
			return arr[p];
		}
		public boolean contains(int x) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==x) return true;
			}
			return false;
		}
	}
}
