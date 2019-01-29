public String deduplication(String input) {
    if (input == null || input.length() == 0) {
        return input;
    }
    char[] array = input.toCharArray();
    int fast = 1;
    int slow = 1;
    while (fast < array.length) {
        if (slow > 0 && array[fast] == array[slow - 1]) {
            while (fast < array.length && array[fast] == array[slow - 1]) {
                fast++;
            }
            slow--;
        } else {
            array[slow++] = array[fast++];
        }
    }
    return new String(array, 0, slow);
}
/*
two pointers:
- slow: the left hand side of the slow index (not including slow) have been processed and should be kept
- fast: the current processing index

initial:
- slow = 1
- fast = 1

algorithm:
- if a[f] == a[s-1], f++ until a[f] != a[s-1], s--
- if a[f] != a[s-1], a[s] = a[f], s++, f++
- if s == 0, a[s] = a[f], s++, f++

complexity
- time: O(n)
- space: o(1)
*/
