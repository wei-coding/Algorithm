
public class SortingArray4107056006_2 extends SortingArray{
	//three-way quick sort with cutoff
	private final int CUTOFF = 16;
	@Override
	public int[] sorting(int[] A) {
		// TODO Auto-generated method stub
		if(A.length<=1) return A;
		shuffle(A);
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
		quicksort(a,lo,lt-1);
		quicksort(a,gt+1,hi);
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
}
