
public class SortingArray4107056006_3 extends SortingArray{
	private static final int RUN = 32;
	public int[] sorting(int[] A) {
		if(A.length==0) return A;
		timsort(A,A.length);
		return A;
	}

	public void merge(int[] a,int lo,int mid,int hi) {
		int llen = mid - lo + 1,rlen = hi - mid;
		int[] left = new int[llen];
		int[] right = new int[rlen];
		for(int i=0;i<llen;i++) {
			left[i] = a[lo+i];
		}
		for(int i=0;i<rlen;i++) {
			right[i] = a[mid+1+i];
		}
		
		int i=0,j=0,k=lo;
		
		while(i<llen && j<rlen) {
			if(left[i] <= right[j]) {
				a[k] = left[i++];
			}else {
				a[k] = right[j++];
			}
			k++;
		}
		while(i<llen) {
			a[k++] = left[i++];
		}
		while(j<rlen) {
			a[k++] = right[j++];
		}
	}
	public void timsort(int[] arr,int n) {
		for (int i = 0; i < n; i += RUN)  
        { 
            InsertionSort(arr, i, Math.min((i + RUN - 1), (n - 1))); 
        } 
  
        // start merging from size RUN (or 32). It will merge  
        // to form size 64, then 128, 256 and so on ....  
        for (int size = RUN; size < n; size = size << 1)  
        { 
              
            // pick starting point of left sub array. We  
            // are going to merge arr[left..left+size-1]  
            // and arr[left+size, left+2*size-1]  
            // After every merge, we increase left by 2*size  
            for (int left = 0; left < n; left += size << 1)  
            { 
                  
                // find ending point of left sub array  
                // mid+1 is starting point of right sub array  
                int mid = Math.min(left + size - 1,(n - 1)); 
                int right = Math.min((left + (size << 1) - 1), (n - 1)); 
  
                // merge sub array arr[left.....mid] &  
                // arr[mid+1....right]  
                merge(arr, left, mid, right); 
            } 
        } 
	}
	public void InsertionSort(int[] a,int lo,int hi) {
		for(int i=lo;i<=hi;i++) {
			for(int j=i;j>lo;j--) {
				if(a[j]<a[j-1])
					exch(a,j,j-1);
				else break;
			}
		}
	}
	public void exch(int[] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
