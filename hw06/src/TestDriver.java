import java.util.Arrays;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopWatch sw = new StopWatch();
		int arr_size = 20000;
		int boundary = Integer.MAX_VALUE;
		int[] org_array = new int[arr_size];
		int[] A;
		for(int i=0;i<arr_size;i++) {
			org_array[i] = (int)(boundary*Math.random());
		}
		
		int[] systemsort = CopyArray(org_array);
		
		sw.start();
		Arrays.parallelSort(systemsort);
		sw.stop();
		
		System.out.printf("system sort:\tused %.6f sec\n",sw.getDur());
		
		A = CopyArray(org_array);
		
		
		SortingArray shell = new SortingArray4107056006();
		
		sw.start();
		int[] afterSorting = shell.sorting(A);
		sw.stop();
		
		for(int i=0;i<afterSorting.length;i++)
			if(afterSorting[i]!=systemsort[i]) {
				System.out.println("Arrays is not sorted, on "+i+" th item.");
				break;
			}
		System.out.printf("shellsort:\tused %.6f sec\n",sw.getDur());
		
		A = CopyArray(org_array);
		
		
		SortingArray three_way = new SortingArray4107056006_2();
		
		sw.start();
		int[] afterSorting2 = three_way.sorting(A);
		sw.stop();
		
		for(int i=0;i<afterSorting2.length;i++)
			if(afterSorting2[i]!=systemsort[i]) {
				System.out.println("Arrays is not sorted, on "+i+" th item.");
				break;
			}
		System.out.printf("3-way:\t\tused %.6f sec\n",sw.getDur());
		
		A = CopyArray(org_array);
		
		
		SortingArray quick = new SortingArray4107056006_1();
		
		sw.start();
		int[] afterSorting3 = quick.sorting(A);
		sw.stop();
		
		for(int i=0;i<afterSorting3.length;i++)
			if(afterSorting3[i]!=systemsort[i]) {
				System.out.println("Arrays is not sorted, on "+i+" th item.");
				break;
			}
		System.out.printf("quick:\t\tused %.6f sec\n",sw.getDur());
		
		A = CopyArray(org_array);
		
		
		SortingArray tim = new SortingArray4107056006_3();
		
		sw.start();
		int[] afterSorting4 = tim.sorting(A);
		sw.stop();
		
		for(int i=0;i<afterSorting4.length;i++)
			if(afterSorting4[i]!=systemsort[i]) {
				System.out.println("Arrays is not sorted, on "+i+" th item.");
				break;
			}
		System.out.printf("timsort:\tused %.6f sec\n",sw.getDur());
		
		A = CopyArray(org_array);
		
		
		SortingArray finalsort = new SortingArray4107056006_final();
		
		sw.start();
		int[] afterSorting5 = finalsort.sorting(A);
		sw.stop();
		
		for(int i=0;i<afterSorting5.length;i++)
			if(afterSorting5[i]!=systemsort[i]) {
				System.out.println("Arrays is not sorted, on "+i+" th item.");
				break;
			}
		System.out.printf("finalsort:\tused %.6f sec\n",sw.getDur());
		
	}
	public static int[] CopyArray(int[] a) {
		int[] new_array = new int[a.length];
		for(int i=0;i<a.length;i++) {
			new_array[i] = a[i];
		}
		return new_array;
	}
}
