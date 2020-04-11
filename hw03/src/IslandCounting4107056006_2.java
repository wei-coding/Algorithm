public class IslandCounting4107056006_2 extends IslandCounting{
	private int[] tree;
	private boolean[] enb;
	@Override
	public int count(String[] A, String[] B) {
		// TODO Auto-generated method stub
		tree = new int[1];
		enb = new boolean[1];
		for(int i=0;i<tree.length;i++) {
			tree[i] = -1;
		}
		for(int i=0;i<A.length;i++) {
			int a = Integer.parseInt(A[i]);
			int b = Integer.parseInt(B[i]);
			union(a,b);
		}
		return findroot();
	}
	private void union(int a,int b) {
		while(tree.length<=a || tree.length<=b) {
			tree = doubleArray(tree);
			enb = doubleArray(enb);
		}
		int aroot = find(a);
		int broot = find(b);
		int temp = tree[aroot] + tree[broot];
		if(aroot==broot) return;
		if(tree[aroot]>tree[broot]) { //aroot size is smaller than broot
			tree[aroot] = broot;
			tree[broot] = temp;
			enb[broot] = true;
		}else{
			tree[broot] = aroot;
			tree[aroot] = temp;
			enb[aroot] = true;
		}
	}
	private int find(int i) {
		int root,trail,lead;
		for(root = i;tree[root]>=0;root=tree[root]);
		lead = tree[i];
		for(trail = i; trail!=root ; trail=lead) {
			lead = tree[trail];
			tree[trail] = root;
		}
		return root;
	}
	private int findroot() {
		int count = 0;
		for(int i=0;i<tree.length;i++) {
			if(tree[i]<0 && enb[i]) count++;
		}
		return count;
	}
	private int[] doubleArray(int[] array) {
		int[] temp = new int[array.length<<1];
		for(int i=0;i<temp.length;i++) {
			temp[i] = -1;
		}
		for(int i=0;i<array.length;i++) {
			temp[i] = array[i];
		}
		return temp;
	}
	private boolean[] doubleArray(boolean[] array) {
		boolean[] temp = new boolean[array.length<<1];
		for(int i=0;i<array.length;i++) {
			temp[i] = array[i];
		}
		return temp;
	}
}