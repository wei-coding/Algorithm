
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch sw = new StopWatch();
		sw.start();
		String[] A = {"A","A","B","D","F","G","H","B"};
		String[] B = {"B","C","C","E","E","E","D","I"};
		IslandCounting4107056006 obj = new IslandCounting4107056006();
		int ans = obj.count(A, B);
		sw.stop();
		System.out.println("ans = "+ans+"\ntotal time = "+sw.dur+" seconds");
	}

}
