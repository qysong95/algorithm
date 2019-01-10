// assume there is no duplicate elements
public int rotatedPosition(int[] array) {
    if (array == null || array.length == 0) {
        return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] > array[left]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    if (array[left] <= array[right]) {
        return 0;
    } else {
        return right;
    }
}
