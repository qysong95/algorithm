public String removeChar(String input, char ch) {
    if (input == null || input.length() == 0) {
        return input;
    }
    char[] array = input.toCharArray();
    while (fast < array.length) {
        if (array[fast] == ch) {
            fast++;
        } else {
            array[slow++] = array[fast++];
        }
    }
    return new String(array, 0, slow)
}
/*
two pointers:
- slow: the left hand side of the slow index(not including slow) have been processed and should be kept
- fast: the current processing index

algorithms:
- if a[f] == ch, f++
- if a[f] != ch, a[s] = a[f], s++, f++

complexity:
- time: O(n)
- space: inplace, O(1)
*/
