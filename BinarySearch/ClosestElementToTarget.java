public int binarySearch(int[] array, int target) {
    // assume array is not null and length larger than 1
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }
    // post-processing
    if (Math.abs(array[mid] - left) < Math.abs(array[mid] - right)) {
        return left;
    } else {
        return right;
    }
}
