public List<List<Integer>> shuffle(int n) {
    List<List<Integer>> result = new ArrayList<>();
    if (n <= 0) {
        return result;
    }
    int[] array = new int[2 * n];
    for (int i = 0; i < 2 * n; i++) {
        array[i] = i / 2 + 1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    helper(array, 0, map, result);
    return result;
}

private void helper(int[] array, int index, Map<Integer, Integer> map, List<List<Integer>> result) {
    if (index == array.length) {
        List<Integer> res = new ArrayList<>();
        for (int num: array) {
            res.add(num);
        }
        result.add(res);
        return;
    }
    Set<Integer> used = new HashSet<>();
    for (int i = index; i < array.length; i++) {
        if (used.add(array[i])) {
            if (map.containsKey(array[i])) {
                if (index - map.get(array[i]) - 1 == array[i]) {
                    swap(array, i, index);
                    helper(array, index + 1, map, result);
                    swap(array, i, index);
                }
            } else {
                map.put(array[i], index);
                swap(array, i, index);
                helper(array, index + 1, map, result);
                swap(array, i, index);
                map.remove(array[i]);
            }
        }
    }
}

private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
