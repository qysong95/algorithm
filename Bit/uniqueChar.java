// Solution 1
public boolean unique(String input) {
    if (input == null) {
        return true;
    }
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < input.length(); i++) {
        if (!set.add(input.charAt(i)) {
            return false;
        }
    }
    return true;
}

// Solution 2
// assume only 'a'-'z'
public boolean unique(String input) {
    if (input == null) {
        return true;
    }
    boolean[] visited = new boolean[26];
    for (int i = 0; i < input.length(); i++) {
        int k = input.charAt(i) - 'a';
        if (visited[k]) {
            return false;
        }
        visited[k] = true;
    }
    return true;
}

// Solution 3
// assume only 'z' - 'a'
public boolean unique(String input) {
    if (input == null) {
        return true;
    }
    int check = 0;
    for (int i = 0; i < input.length(); i++) {
        int k = input.charAt(i) - 'a';
        if ((check >> k) & 1 == 1) {
            return false;
        }
        check = check | (1 << k);
    }
    return true;
}

// Solution 4
// assume ascii, 256
// one int is 32bit, we need 256/32 = 8, 8 int
public boolean unique(String input) {
    if (input == null) {
        return true;
    }
    int[] check = new int[8];
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        int row = ch / 32;
        int col = ch % 32;
        if ((check[row] >> rol) & 1 == 1) {
            return false;
        }
        check[row] = check[row] | (1 << k);
    }
    return true;
}
