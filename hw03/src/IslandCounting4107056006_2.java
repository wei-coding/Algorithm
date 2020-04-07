public class IslandCounting4107056006_2 extends IslandCounting{
	private int[] tree;
	private boolean[] enb;
	private int initsize = 4096;
	@Override
	public int count(String[] A, String[] B) {
		// TODO Auto-generated method stub
		tree = new int[initsize];
		enb = new boolean[initsize];
		for(int i=0;i<tree.length;i++) {
			tree[i] = -1;
		}
		for(int i=0;i<A.length;i++) {
			int a = parseInt(A[i]);
			int b = parseInt(B[i]);
			union(a,b);
		}
		/*for(int i=1;i<pos;i++) {
			System.out.println("tree["+i+"] = "+tree[i]);
		}*/
		return this.findroot();
	}
	private void union(int a,int b) {
		while(tree.length<=a || tree.length<=b) {
			tree = doubleArray(tree);
			enb = doubleArray(enb);
		}
		int aroot = this.find(a);
		int broot = this.find(b);
		if(aroot>broot) { //aroot size is smaller than broot
			tree[broot]+=tree[aroot];
			tree[aroot] = broot;
			enb[broot] = true;
		}else if(aroot<broot){
			tree[aroot]+=tree[broot];
			tree[broot] = aroot;
			enb[aroot] = true;
		}else {
			enb[aroot] = true;
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
		for(int i=0;i<this.tree.length;i++) {
			if(tree[i]<0 && enb[i]) count++;
		}
		return count;
	}
	private int[] doubleArray(int[] array) {
		int[] temp = new int[array.length*2];
		for(int i=0;i<temp.length;i++) {
			temp[i] = -1;
		}
		for(int i=0;i<array.length;i++) {
			temp[i] = array[i];
		}
		return temp;
	}
	private boolean[] doubleArray(boolean[] array) {
		boolean[] temp = new boolean[array.length*2];
		for(int i=0;i<array.length;i++) {
			temp[i] = array[i];
		}
		return temp;
	}
	private int parseInt(String s) {
		int temp = 0;
		int power = 1;
		for(int i=0;i<s.length();i++) {
			temp += ((int)s.charAt(i))*power;
			power *= 1000;
		}
		return temp;
	}
}