
public class PCL4107056003 extends PCL {
	public boolean checkPCL(int[][] array) {
		int i, j, k, h;
		int max = array.length;
		// System.out.println(max);
		double[] lin = new double[max];
		for (i = 0; i < max - 1; i++) {
			k = i + 1;
			for (j = i + 1; j < max; j++) {
				lin[j] = ((double) (array[i][1] - array[j][1]) / (double) (array[i][0] - array[j][0]));
				if (lin[j] == (-1.0 / 0.0)) {
					lin[j] = (1.0 / 0.0);
				}
			}
			mergeSort(lin, k, max - 1);
			for (h = k; h < max - 1; h++) {
				if (lin[h] == lin[h + 1]) {
					System.out.println(lin[h]);
					return true;
				}
			}
		}
		return false;
	}

	void merge(double arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;
		double[] L = new double[n1];
		double[] R = new double[n2];
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void mergeSort(double[] list, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(list, l, m);
			mergeSort(list, m + 1, r);
			merge(list, l, m, r);
		}
	}
}
