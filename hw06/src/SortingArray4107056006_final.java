
public class SortingArray4107056006_final extends SortingArray{
	private final int CUTOFF = 10;
	@Override
	public int[] sorting(int[] A) {
		// TODO Auto-generated method stub
		if(A.length <= 1) return A;
		int subseq = 0;
		int equseq = 0;
		for(int i=1;i<A.length && subseq <= 500;i++) {
			if(A[i-1]<A[i])
				continue;
			else if(A[i-1]==A[i])
				equseq++;
			else
				subseq++;
		}
		if(subseq >= 500) {
			shuffle(A);
			quicksort(A,0,A.length-1);
			return A;
		}
		if(equseq >= 50){
			shuffle(A);
			three_way_quicksort(A,0,A.length-1);
			return A;
		}
		shellsort(A);
		return A;
	}
	public void shellsort(int[] arr) {
		int[] seq = {1,4,9,20,46,103,233,525,1182,2660,5985,13467};
		int h = 0;
		for(h=0;h<seq.length && seq[h]<arr.length;h++);
		h--;
		while(h>=0) {
			for(int i=seq[h];i<arr.length;i++) {
				for(int j=i;j >= seq[h] && arr[j]<arr[j-seq[h]];j-=seq[h]) {
					int temp = arr[j];
					arr[j] = arr[j-seq[h]];
					arr[j-seq[h]] = temp;
				}
			}
			h--;
		}
		
	}
	public void three_way_quicksort(int[] a,int lo,int hi) {
		if(hi <= lo + CUTOFF - 1) {
			for(int i=lo;i<hi;i++) {
				for(int j=i+1;j>lo;j--) {
					if(a[j]<a[j-1])
						exch(a,j,j-1);
					else break;
				}
			}
			return;
		}
		int lt = lo,gt = hi;
		int i = lo+1;
		//exch(a,lo,medianOf3(a,lo,(lo+hi)>>1,hi));
		int v = a[lo];
		while(i<=gt) {
			if(a[i]<v) {
				exch(a,i++,lt++);
			}
			else if(a[i]>v) {
				exch(a,i,gt--);
			}else {
				i++;
			}
		}
		three_way_quicksort(a,lo,lt-1);
		three_way_quicksort(a,gt+1,hi);
	}
	public void exch(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public int medianOf3(int[] arr,int a,int b,int c) {
		int a1 = arr[a];
		int b1 = arr[b];
		int c1 = arr[c];
		if((a1<b1 && a1>c1)||(a1<c1 && a1>b1)) return a;
		if((b1<a1 && b1>c1)||(b1<c1 && b1>a1)) return b;
		else return c;
	}
	public void shuffle(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			exch(arr,i,(int)(Math.random()*i));
		}
	}
	public void quicksort(int[] a,int lo,int hi) {
		if(hi <= lo + CUTOFF - 1) {
			for(int i=lo;i<hi;i++) {
				for(int j=i+1;j>lo;j--) {
					if(a[j]<a[j-1])
						exch(a,j,j-1);
					else break;
				}
			}
			return;
		}
		exch(a,lo,medianOf3(a,lo,(lo+hi)>>1,hi));
		int i = lo,j = hi+1;
		int pivot = a[lo];
		do {
			do i++; while(a[i]<pivot);
			do j--; while(a[j]>pivot);
			if(i<j) exch(a,i,j);
		}while(i<j);
		exch(a,lo,j);
		quicksort(a,lo,j-1);
		quicksort(a,j+1,hi);
	}
}
