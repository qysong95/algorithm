public String remove(String input) {
    if (input == null || input.length() == 0) {
        return input;
    }
    char[] array = input.toCharArray();
    int fast = 0;
    int slow = 0;
    while (fast < array.length) {
        if (array[fast] == ' ') {
            if (slow == 0 || array[slow - 1] == ' ') {
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        } else {
            array[slow++] = array[fast++];
        }
    }
    if (slow > 0 && array[slow - 1] == ' ') {
        s--;
    }
    return new String(array, 0, slow);
}
/*
two pointers:
- slow: the left hand side of the slow index (not inlcuding slow) have been processed and should be kept
- fast: the current processing index

initial:
- slow = 0
- fast = 0

algorithm:
- if a[f] == ' ':
    - leading: s == 0: f++
    - middle: a[s-1] == ' ': f++
    - middle: s[s-1] != ' ': a[s] = a[f], s++, f++
- if a[f] != ' ', a[s] = a[f], s++, f++
- post processing for traling empty spaces: if a[s-1] == ' ', s--

complexity:
- time: O(n)
- space: inplace O(1)
*/
