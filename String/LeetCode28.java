class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        
        // naive solution
        // for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        //     if (equalString(haystack, i, needle)) {
        //         return i;
        //     }
        // }
        // return -1;
        
        int largePrime = 101;
        int prime = 31;
        int seed = 1;
        
        // convert target to hashcode
        int targetHash = needle.charAt(0) % largePrime;
        for (int i = 1; i < needle.length(); i++) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, needle.charAt(i), prime, largePrime);
        }
        
        // convert the first needle.length of haystack to hashcode
        int hash = 0;
        for (int i = 0; i < needle.length(); i++) {
            hash = moduleHash(hash, haystack.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && equalString(haystack, 0, needle)) {
            return 0;
        }
        
        // do sliding window
        for (int i = 1; i <= haystack.length() - needle.length(); i++) {
            hash = nonNegative(hash - haystack.charAt(i - 1) * seed % largePrime, largePrime);
            hash = moduleHash(hash, haystack.charAt(i + needle.length() - 1), prime, largePrime);
            if (hash == targetHash && equalString(haystack, i, needle)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean equalString(String haystack, int start, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(start + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }
    
    private int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash = hash + largePrime;
        }
        return hash;
    }
}
