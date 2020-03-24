
public class ThreeSum410705600603 extends ThreeSum{
	//standard version(no multithread)
	@Override
	public int T_sum(int[] A) {
		// TODO Auto-generated method stub
		sort(A,0,A.length-1);
		int count=0;
		int sum=0;
		//s.start();
		for(int a=0,c=0;A[a]<0;a++) {
			c = A.length-1;
			for(int b=a+1;b<A.length && b<c;) {
				sum = A[a]+A[b]+A[c];
				if(sum==0) {
					count++;
					b++;c--;
				}else if(sum>0) {
					c--;
				}else {
					b++;
				}
			}
		}
		return count;
	}
    public static void merge(int arr[], int l, int m, int r) { 
        int n1 = m-l+1; 
        int n2 = r-m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1;i++) 
            L[i] = arr[l+i]; 
        for (int j=0; j<n2;j++) 
            R[j] = arr[m+1+j]; 
        int i=0,j=0; 
        int k=l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            }else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        }
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public static void sort(int arr[], int l, int r) { 
        if (l < r) { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    }
    
}
