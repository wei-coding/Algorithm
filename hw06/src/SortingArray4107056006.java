
public class SortingArray4107056006 extends SortingArray{
	//shell sort version,used the fastest seq
	@Override
	public int[] sorting(int[] A) {
		// TODO Auto-generated method stub
		if(A.length<=1) return A;
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
}
