public class IslandCounting4107056006 extends IslandCounting{

	@Override
	public int count(String[] A, String[] B) {
		// TODO Auto-generated method stub
		int pos = 0;
		HashMap map = new HashMap(4096);
		
		return 0;
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
		for(;temp.next!=null&&temp.s!=s;temp=temp.next);
		if(temp.s!=s) return -1;
		else return temp.data;
	}
}