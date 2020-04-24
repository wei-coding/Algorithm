
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 100000000;
		int[] A = new int[size];
		int slash = (int)(Math.random()*size);
		//int slash = 3128069;
		int p=0;
		for(int i=slash;i<size;i++) {
			A[p++] = i;
		}
		for(int i=0;i<slash;i++) {
			A[p++] = i;
		}
		/*for(int i:A) {
			System.out.print(i+" ");
		}*/
		System.out.println("Data generating finished.");
		StopWatch s = new StopWatch();
		s.start();
		slash obj = new slash4107056006();
		int ans = obj.slash_min(A);
		s.stop();
		System.out.printf("ans is %d,calculated ans is %d,used %.6f seconds\n",slash-1,ans,s.getDur());
	}

}
