
public class PCL4107056006 extends PCL{
	private volatile boolean flag = false;
	HashMap[] hm;
	int thread = 8;
	public PCL4107056006() {
		hm = new HashMap[thread];
		for(int i=0;i<thread;i++) {
			hm[i] = new HashMap(4096);
		}
	}
	@Override
	public boolean checkPCL(int[][] array) {
		//n*2 size
		// TODO Auto-generated method stub
		Thread[] th = new Thread[thread];
		for(int i=0;i<th.length;i++) {
			th[i] = new Thread(new check(array,thread,i+1,hm[i]));
		}
		for(int i=0;i<th.length;i++) {
			th[i].start();
		}
		for(int i=0;i<th.length;i++) {
			try {
				th[i].join();
			}catch (InterruptedException e) {}
		}
		return flag;
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
				map[i].first = null;
				//map[i] = new LinkedList();
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
	class check implements Runnable{
		private int[][] array;
		private int start;
		private int end;
		private HashMap hm;
		public check(int[][] arr,int part,int ith,HashMap h) {
			this.array = arr;
			this.start = arr.length*(ith-1)/part;
			this.hm = h;
			if(part==ith) {
				this.end = arr.length;
			}else {
				this.end = arr.length*ith/part;
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=start;i<end;i++) {
				hm.clear();
				for(int j=i+1;j<array.length;j++) {
					if(flag) return;
					double m = (array[j][1]-array[i][1])/(double)(array[j][0]-array[i][0]);
					if(array[j][0]-array[i][0]==0) {
						if(m<0) m=-m;
					}
					if(hm.contain(m)) {
						//System.out.printf("(%d,%d),(%d,%d)\n",array[i][0],array[i][1],array[j][0],array[j][1]);
						flag = true;
						return;
					}else {
						hm.put(m);
					}
				}
			}
		}
	}
}
