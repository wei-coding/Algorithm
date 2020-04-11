public class IslandCounting4107056006 extends IslandCounting{
	private int pos;
	private HashMap map;
	private int[] tree;
	public IslandCounting4107056006() {
		pos = 1;
		map = new HashMap(1048576);
	}
	@Override
	public int count(String[] A, String[] B) {
		// TODO Auto-generated method stub
		tree = new int[A.length+B.length+1];
		for(int i=0;i<tree.length;i++) {
			tree[i] = -1;
		}
		for(int i=0;i<A.length;i++) {
			int a,b;
			//System.out.println(pos);
			a = map.get(A[i]);
			if(a==-1) {
				a = pos;
				map.put(A[i],pos++);
			}
			b = map.get(B[i]);
			if(b==-1) {
				b = pos;
				map.put(B[i],pos++);
			}
			union(a,b);
		}
		return findroot();
	}
	private void union(int a,int b) {
		int aroot = find(a);
		int broot = find(b);
		int temp = tree[aroot] + tree[broot];
		if(aroot==broot) return;
		if(tree[aroot]>tree[broot]) { //aroot size is smaller than broot
			tree[aroot] = broot;
			tree[broot] = temp;
		}else{
			tree[broot] = aroot;
			tree[aroot] = temp;
		}
	}
	private int find(int i) {
		int root,trail,lead;
		for(root = i;tree[root]>0;root=tree[root]);
		lead = tree[i];
		for(trail = i; trail!=root ; trail=lead) {
			lead = tree[trail];
			tree[trail] = root;
		}
		return root;
	}
	private int findroot() {
		int count = 0;
		for(int i=1;i<this.pos;i++) {
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
		map[abs(k.hashCode()) & (size-1)].add(k, v);
	}
	public int get(String k) {
		return map[abs(k.hashCode()) & (size-1)].get(k);
	}
	private int abs(int n) {
		if(n>0) return n;
		else return -n;
	}
}
class LinkedList{
	private class Node{
		public String s;
		public int data;
		public Node next;
		public Node(String s,int data) {
			this.s = s;
			this.data = data;
			this.next = null;
		}
	}
	private Node first = null;
	public void add(String s,int data) {
		Node temp = new Node(s,data);
		temp.next = first;
		first = temp;
	}
	public int get(String s) {
		Node temp = first;
		if(temp==null) return -1;
		while(temp.next!=null&&!temp.s.equals(s)) {
			temp = temp.next;
		}
		if(!temp.s.equals(s)) return -1;
		else return temp.data;
	}
}