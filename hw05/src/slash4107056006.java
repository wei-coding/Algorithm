public class slash4107056006 extends slash{
	@Override
	public int slash_min(int[] A) {
		int lo=0,hi=A.length-1,mid=lo+(hi-lo)/2;
		if(A[lo]<=A[hi]) return -1;
		while(lo<=hi) {
			if(A[lo]<=A[mid] && A[mid]>=A[hi]) lo=mid+1;
			if(A[mid]<=A[hi] && A[mid]<=A[lo]) hi=mid-1;
			mid=lo+(hi-lo)/2;
			if(A[mid-1]>=A[mid]) return A.length-mid-1;
			if(A[mid]>=A[mid+1]) return A.length-mid-2;
		}
		return -1;
	}
}