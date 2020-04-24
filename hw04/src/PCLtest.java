public class PCLtest extends PCL {
	int[][] array;

	public boolean checkPCL(int[][] array) {
		this.array = array;
		int i, j, k, num = 0;
		double[] A = new double[array.length];
		for (i = 0; i < array.length; i++) {
			for (j = i + 1; j < array.length; j++) {
				A[num] = (double) ((double) (array[j][0] - array[i][0]) / (double) (array[j][1] - array[i][1]));
				System.out.print(A[num] + " ");
				num++;
			}
			System.out.print(" * \n");
			sort(A, 0, A.length - 1 - i);
			for (k = 0; k < num; k++)
				System.out.print(A[k] + " ");
			System.out.print(" * \n");
			num = 0;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] A = { { 12, -8 }, { 6, -4 }, { 3, -2 }, { 1111, 1111 }, { 2222, 2222 }, { 5555, 5555 } };
		PCLtest p = new PCLtest();
		System.out.print(p.checkPCL(A));
	}

	public static void sort(double[] A, int left, int right) {
		if (left < right) {
			int q = partition(A, left, right);
			sort(A, left, q - 1);
			sort(A, q + 1, right);
		}
	}

	public static int partition(double[] A, int left, int right) {
		int i = left - 1;
		int j;
		for (j = left; j < right; j++) {
			if (A[j] < A[right]) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, right);
		return i + 1;
	}

	public static void swap(double[] A, int a, int b) {
		double temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}