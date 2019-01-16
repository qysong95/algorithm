public int[] selection(int[] array) {
    if (array == null || array.length == 0) {
        return array;
    }
    for (int i = 0; i < array.length; i=+) {
        int min = Integer.MAX_VALUE;
        int index = i;
        for (int j = i; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;
            }
        }
        swap(array, i, j);
    }
    return array;
}

private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
