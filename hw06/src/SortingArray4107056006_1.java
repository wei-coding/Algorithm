
public class SortingArray4107056006_1 extends SortingArray{
	private final int CUTOFF = 8;
	public int[] sorting(int[] A) {
		if(A.length==0) return A;
		for(int i=0;i<A.length;i++) {
			exch(A,0,(int)(Math.random()*i));
		}
		quicksort(A,0,A.length-1);
		return A;
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
}
