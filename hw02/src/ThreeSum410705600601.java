public class ThreeSum410705600601 extends ThreeSum{
	//mainframe do nothing
	@Override
	public int T_sum(int[] A){
		// TODO Auto-generated method stub
		sort(A,0,A.length-1);
		int pivot,thread=4;
		for(pivot=0;pivot<A.length&&A[pivot]<0;pivot++);
		tsum s1 = new tsum(A,0,pivot/thread);
		tsum s2 = new tsum(A,pivot/thread,pivot/thread*2);
		tsum s3 = new tsum(A,pivot/thread*2,pivot/thread*3);
		tsum s4 = new tsum(A,pivot/thread*3,pivot);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();t2.join();t3.join();t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1.count+s2.count+s3.count+s4.count;
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
    public class tsum implements Runnable{
    	int[] A;
    	int count=0;
    	int sum=0;
    	int start,end;
    	public tsum(int[] arr,int a,int end) {
    		A = arr;
    		start = a;
    		this.end = end;
    	}
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		for(int a=start,c=0;a<end;a++) {
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
    	}
    }

}
