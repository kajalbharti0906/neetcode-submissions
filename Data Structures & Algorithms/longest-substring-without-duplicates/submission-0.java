class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while(right<s.length()) {
            if(set.contains(s.charAt(right))) {
                while(left<right && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    ++left;
                }
            }
            set.add(s.charAt(right));
            int len = right-left+1;
            maxLen = Math.max(len, maxLen);
            ++right;
        }
        return maxLen;
    }
}
