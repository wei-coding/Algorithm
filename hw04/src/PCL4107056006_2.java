
public class PCL4107056006_2 extends PCL{
	HashMap hm;
	public PCL4107056006_2() {
		hm = new HashMap(4096);
	}
	@Override
	public boolean checkPCL(int[][] array) {
		//n*2 size
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++) {
			hm.clear();
			for(int j=i+1;j<array.length;j++) {
				double m = (array[j][1]-array[i][1])/(double)(array[j][0]-array[i][0]);
				if(hm.contain(m)) {
					//System.out.printf("(%d,%d),(%d,%d)\n",array[i][0],array[i][1],array[j][0],array[j][1]);
					return true;
				}else {
					hm.put(m);
				}
			}
		}
		return false;
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
		public void put(double k) {
			map[Double.valueOf(k).hashCode() & (size-1)].add(k);
		}
		public boolean contain(double k) {
			return map[Double.valueOf(k).hashCode() & (size-1)].contain(k);
		}
		private void clear() {
			for(int i=0;i<size;i++) {
				//map[i].first = null;
				map[i] = new LinkedList();
			}
		}
	}
	class LinkedList{
		private class Entry{
			public double k;
			public Entry next;
			public Entry(double k) {
				this.k = k;
				this.next = null;
			}
		}
		private Entry first = null;
		public void add(double k) {
			Entry temp = new Entry(k);
			temp.next = first;
			first = temp;
		}
		public boolean contain(double k) {
			Entry temp = first;
			while(temp!=null) {
				if(temp.k == k) return true;
				temp = temp.next;
			}
			return false;
		}
	}
}
