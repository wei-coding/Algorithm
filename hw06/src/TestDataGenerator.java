import java.io.*;
public class TestDataGenerator {
	
	public static void main(String[] args) throws IOException{
		
		FileWriter fw = new FileWriter("C:\\Users\\User\\git\\Algorithm\\hw06\\src\\SortingArray_test_data_4107056006.txt");
		BufferedWriter bfw = new BufferedWriter(fw);

		int size = 20000;
		int boundary = Integer.MAX_VALUE;
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = 0;//(int)(-Math.random()*boundary);
		}
		for(int i:arr) {
			bfw.write(String.valueOf(i));
			bfw.newLine();
		}
		bfw.flush();
		bfw.close();
		
		SortingArray obj = new SortingArray4107056006();
		int[] sorted = obj.sorting(arr);
		
		fw = new FileWriter("C:\\Users\\User\\git\\Algorithm\\hw06\\src\\SortingArray_ans_4107056006.txt");
		bfw = new BufferedWriter(fw);
		for(int i:sorted) {
			bfw.write(String.valueOf(i));
			bfw.newLine();
		}
		bfw.flush();
		bfw.close();
	}
}
