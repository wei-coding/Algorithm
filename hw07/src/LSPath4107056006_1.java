
import java.util.ArrayList;

public class LSPath4107056006_1 extends LSPath{
	private ArrayList<ArrayList<Integer>> adjList;
	private HashMap hmap;
	private boolean[] visited;
	private int[] distTo;
	private Timer timer;
	@Override
	public int Ans(int[][] array) {
		// TODO Auto-generated method stub
		timer = new Timer();
		hmap = new HashMap(array.length);
		adjList = new ArrayList<ArrayList<Integer>>();
		//create adjList for the graph
		for(int i=0;i<array.length;i++) {
			timer.start();
			ensureCapaticy(adjList,array[i][0]);
			ensureCapaticy(adjList,array[i][1]);
			timer.stop();
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
			for(int node:adjList.get(v)) {
				if(!visited[node]) {
					//System.out.println("node = "+node);
					q.add(node);
					visited[node] = true;
					distTo[node] = distTo[v] + 1;
				}
			}
		}
	}
	public <T> void ensureCapaticy(ArrayList<T> arr,int size) {
		arr.ensureCapacity(size);
		while(arr.size()<=size) {
			arr.add(null);
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
	class HashMap{
		private LinkedList[] map;
		int size;
		public HashMap(int size) {
			this.size = size;
			map = new LinkedList[size];
			for(int i=0;i<size;i++) {
				map[i] = new LinkedList();
			}
		}
		public void put(int k,int v) {
			map[abs(Integer.hashCode(k)) & (size-1)].add(k, v);
		}
		public int get(int k) {
			return map[abs(Integer.hashCode(k)) & (size-1)].get(k);
		}
		private int abs(int n) {
			if(n>0) return n;
			else return -n;
		}
	}
	class LinkedList{
		private class Node{
			public int s;
			public int data;
			public Node next;
			public Node(int s,int data) {
				this.s = s;
				this.data = data;
				this.next = null;
			}
		}
		private Node first = null;
		public void add(int s,int data) {
			Node temp = new Node(s,data);
			temp.next = first;
			first = temp;
		}
		public int get(int s) {
			Node temp = first;
			if(temp==null) return -1;
			while(temp.next!=null && temp.s != s) {
				temp = temp.next;
			}
			if(temp.s!=s) return -1;
			else return temp.data;
		}
	}
}
