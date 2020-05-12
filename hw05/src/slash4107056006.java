public class slash4107056006 extends slash {
	@Override
	public int slash_min(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		int mid = -1;
		while (right - left > 1) {
			mid = (right + left) / 2;
			if (array[right] < array[mid]) {
				left = mid;
			}else {
				right = mid;
			}
		}
		return array.length-right-1;
	}
}