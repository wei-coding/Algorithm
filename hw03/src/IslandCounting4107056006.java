public class IslandCounting4107056006 extends IslandCounting{
	private int pos;
	private HashMap map;
	private int[] tree;
	public IslandCounting4107056006() {
		pos = 1;
		map = new HashMap(4096);
	}
	@Override
	public int count(String[] A, String[] B) {
		// TODO Auto-generated method stub
		tree = new int[A.length+B.length+1];
		for(int i=0;i<A.length;i++) {
			int a,b;
			a = map.get(A[i]);
			b = map.get(B[i]);
			if(a==-1) {
				a = pos;
				map.put(A[i],pos++);
			}
			if(b==-1) {
				b = pos;
				map.put(B[i],pos++);
			}
			this.union(a,b);
		}
		return this.findroot();
	}
	private void union(int a,int b) {
		int aroot = this.find(a);
		int broot = this.find(b);
		if(aroot>broot) { //aroot size is smaller than broot
			tree[aroot] = broot;
			tree[broot]--;
		}else if(aroot<broot){
			tree[broot] = aroot;
			tree[aroot]--;
		}
	}
	private int find(int i) {
		while(i!=0 && tree[i]>0) {
			i = tree[i];
		}
		return i;
	}
	private int findroot() {
		int count = 0;
		for(int i=0;i<tree.length;i++) {
			if(tree[i]<0) count++;
		}
		return count;
	}
}
class HashMap{
	LinkedList[] map;
	int size;
	public HashMap(int size) {
		this.size = size;
		map = new LinkedList[size];
		for(int i=0;i<size;i++) {
			map[i] = new LinkedList();
		}
	}
	public void put(String k,int v) {
		map[k.hashCode() & (size-1)].add(k, v);
	}
	public int get(String k) {
		return map[k.hashCode() & (size-1)].get(k);
	}
}
class LinkedList{
	class Node{
		String s;
		int data;
		Node next;
		public Node(String s,int data) {
			this.s = s;
			this.data = data;
			this.next = null;
		}
	}
	Node first = null,now = first;
	public void add(String s,int data) {
		if(first==null) {
			first = new Node(s,data);
			now = first;
		}else {
			Node temp = new Node(s,data);
			now.next = temp;
			now = temp;
		}
	}
	public int get(String s) {
		Node temp = first;
		if(temp==null) return -1;
		for(;temp.next!=null&&temp.s!=s;temp=temp.next);
		if(temp.s!=s) return -1;
		else return temp.data;
	}
}