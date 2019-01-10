// assume there is no duplicate elements
public int rotatedPosition(int[] array) {
    if (array == null || array.length == 0) {
        return -1;
    }
    int left = 0;
    int right = array.length - 1;
    // check if the array is in order
    if (array[left] <= array[right]) {
        return 0;
    }
    while (left < right - 1) {  // we want to terminate if left neighbors right
        int mid = left + (right - left) / 2;
        if (array[mid] > array[left]) {
            left = mid; // left = mid + 1 (wrong!!! when input.length == 3, it would be left == right after first round
        } else {
            right = mid; // right = mid - 1 (wrong!!!)
        }
    }
    if (array[left] <= array[right]) {
        return 0;
    } else {
        return right;
    }
}
