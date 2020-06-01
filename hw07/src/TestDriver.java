import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class TestDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		LSPath entity1 = new LSPath4107056006_1();
		BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\User\\git\\Algorithm\\hw07\\data\\testdata1.txt"));
		while(bfr.ready()) {
			String t = bfr.readLine();
			Scanner scn = new Scanner(t);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(scn.nextInt());temp.add(scn.nextInt());
			arr.add(temp);
		}
		int[][] array = arr.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
		int ans = entity1.Ans(array);
		System.out.println("ans is:"+ans);
	}

}
