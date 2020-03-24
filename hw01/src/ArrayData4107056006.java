
public class ArrayData4107056006 extends ArrayData{
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;
	private int a,b;
	public ArrayData4107056006(int []A){
		for(int i=0;i<A.length-1;i+=2) {
			a = A[i];
			b = A[i+1];
			if(a>b) {
				if(b<min) min = b;
				if(a>max) max = a;
			}else {
				if(a<min) min = a;
				if(b>max) max = b;
			}
		}
		if((A.length%2)!=0) {
			a = A[A.length-1];
			if(a<min) min = a;
			if(a>max) max = a;
		}
	}

	@Override
	public int max() {
		return max;
	}

	@Override
	public int min() {
		return min;
	}
}