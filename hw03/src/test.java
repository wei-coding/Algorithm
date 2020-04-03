
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch sw = new StopWatch();
		sw.start();
		String[] A = {"AA","R","R","R","B","T","Q","T","O"};
		String[] B = {"R", "X","D","B","D","Y","O","O","1"};
		IslandCounting4107056006 obj = new IslandCounting4107056006();
		int ans = obj.count(A, B);
		sw.stop();
		System.out.println("ans = "+ans+"\ntotal time = "+sw.dur+" seconds");
	}

}
