
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class TestDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Reading file
		int[][] array = usingTestData("test_data.txt");
		
		Timer timer = new Timer();
		timer.start();
		
		LSPath entity1 = new LSPath4107056006_1();
		int ans = entity1.Ans(array);
		
		double dur = timer.stop();
		
		System.out.println("ans is: "+ans+" ,takes "+dur+" seconds.");
		
		timer.start();
		
		LSPath entity2 = new LSPath4107056006_2();
		ans = entity2.Ans(array);
		
		dur = timer.stop();
		
		System.out.println("ans is: "+ans+" ,takes "+dur+" seconds.");
	}
	public static int[][] usingTestData(String path) throws IOException {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\User\\git\\Algorithm\\hw07\\data\\"+path));
		while(bfr.ready()) {
			String t = bfr.readLine();
			Scanner scn = new Scanner(t);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(scn.nextInt());temp.add(scn.nextInt());
			arr.add(temp);
		}
		int[][] array = arr.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
		return array;
	}
}
