class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails) {
            set.add(process(email));
        }
        return set.size();
    }
    
    private String process(String email) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (email.charAt(index) != '@') {
            char ch = email.charAt(index);
            if (ch == '+') {
                while (email.charAt(index) != '@') {
                    index++;
                }
            } else {
                if (ch != '.') {
                    sb.append(ch);
                }
                index++;
            }
        }
        sb.append(email.substring(index, email.length()));
        return sb.toString();
    }
}
