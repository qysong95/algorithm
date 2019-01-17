public void quickSort(int[] array) {
    if (array == null || array.length == 0) {
        return;
    }
    helper(array, 0, array.length - 1);
}

private void helper(int[] array, int left, int right) {
    if (left >= right) {
        return;
    }
    int pivotIndex = partition(array, left, right);
    helper(array, left, pivotIndex - 1);
    helper(array, pivotIndex + 1, right);
}

private int partition(int[] array, int left, int right) {
    int pivotIndex = getPivotIndex(left, right);
    int pivotValue = array[pivotIndex];
    swap(array, pivotIndex, right);
    pivotIndex = right--;
    while (left <= right) {
        if (array[left] <= pivotValue) {
            left++;
        } else if (array[right] > pivotValue) {
            right--;
        } else {
            swap(array, left++, right--);
        }
    }
    swap(array, left, pivotIndex);
    return left;
}

private int getPivotIndex(int left, int right) {
    return (int) (left + Math.random() * (right - left + 1));
}

private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
