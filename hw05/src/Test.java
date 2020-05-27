import java.io.*;
import java.util.*;
public class Test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] A;
		FileReader fr = new FileReader("C:\\Users\\User\\git\\Algorithm\\hw05\\src\\data5.txt");
		BufferedReader bfr = new BufferedReader(fr);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(bfr.ready()) {
			arr.add(Integer.parseInt(bfr.readLine()));
		}
		A = new int[arr.size()];
		for(int i=0;i<A.length;i++) {
			A[i] = arr.get(i);
		}
		//int slash = 55;

		/*for(int i:A) {
			System.out.print(i+" ");
		}*/
		System.out.println("Data generating finished.");
		StopWatch s = new StopWatch();
		int ans;
		
		s.start();
		slash obj = new slash4107056006();
		ans = obj.slash_min(A);
		s.stop();
		System.out.printf("§Úªº->ans is %d,used %.6f seconds\n",ans,s.getDur());
		
	}

}
