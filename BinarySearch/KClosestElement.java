/*
* Assume array is not null
* Assume k >= 0, and k smaller than array.length
*/
public int[] kClosestElement(int[] array, int target, int k) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            left = mid;
            right = mid + 1;
        } else if (array[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        if (right >= array.length || left >= 0 && Math.abs(target - array[left]) <= Math.abs(array[right] - target)) {
            result[i] = array[left--];
        } else {
            result[i] = array[right++];
        }
    }
    return result;
}
