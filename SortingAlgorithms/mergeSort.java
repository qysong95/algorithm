public void mergeSort(int[] array) {
    if (array == null || array.length == 0) {
        return;
    }
    int[] buffer = new int[array.length];
    helper(array, 0, array.length - 1, buffer);
}

private void helper(int[] array, int left, int right, int[] buffer) {
    if (left >= right) {
        return;
    }
    int mid = left + (right - left) / 2;
    helper(array, left, mid, buffer);
    helper(array, mid + 1, right, buffer);
    merge(array, left, mid, right, buffer);
}

private void merge(int[] array, int left, int mid, int right, int[] buffer) {
    for (int i = left; i <= right; i++) {
        buffer[i] = array[i];
    }
    int one = left;
    int two = mid + 1;
    int index = left;
    while (one <= mid && two <= right) {
        if (buffer[one] <= buffer[two]) {
            array[index++] = buffer[one++];
        } else {
            array[index++] = buffer[two++];
        }
    }
    while (one <= mid) {
        array[index++] = buffer[one++];
    }
}
