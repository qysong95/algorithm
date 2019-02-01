public int flip(String input, int k) {
    if (input == null) {
        return 0;
    }
    int globalMax = 0;
    int fast = 0;
    int slow = 0;
    while (fast < input.length()) {
        if (k >= 0) {
            if (input.charAt(fast) == '0') {
                k--;
            }
            fast++;
        }
        if (k < 0) {
            slow++;
            if (input.charAt(slow - 1) == '0') {
                k++;
            }
        }
        if (k == 0) {
            globalMax = Math.max(globalMax, fast - slow);
        }
    }
    return globalMax;
}
