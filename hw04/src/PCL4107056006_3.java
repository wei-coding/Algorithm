
public class PCL4107056006_3 extends PCL{
	//sorting base algorithm
	private double[] sortedlist;
	private int pivot = 0;
	private boolean find = false;
	@Override
	public boolean checkPCL(int[][] array) {
		// TODO Auto-generated method stub
		sortedlist = new double[array.length*array.length];
		for(int i=0;i<array.length && !find;i++) {
			
			for(int j=i+1;j<array.length && !find;j++) {
				double m = (array[j][1]-array[i][1])/(double)(array[j][0]-array[i][0]);
				sortedlist[pivot++] = m;
				insertionsort(sortedlist,pivot);
			}
		}
		return find;
	}
	public void insertionsort(double[] arr,int len) {
		if(len==1) return;
		int i = len-1;
		double key = arr[i];
		int j = i-1;
		while(key<arr[j] && j>0) {
			if(key==arr[j]) {
				find = true;
				return;
			}
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}
}
