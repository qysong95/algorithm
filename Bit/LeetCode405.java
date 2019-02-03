class Solution {
    public String toHex(int num) {
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        boolean isLeading = true;
        for (int i = 28; i >= 0; i -= 4) {
            char digit = base[(num >> i) & 15];
            if (digit != '0' || !isLeading) {
                sb.append(digit);
                isLeading = false;
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}
