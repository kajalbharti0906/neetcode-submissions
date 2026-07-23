class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int maxFreq = 0;
        while(right<s.length()) {
            char current = s.charAt(right);
            map.put(current, map.getOrDefault(current, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(current));
            
            int windowLen = right - left + 1;
            if (windowLen - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            } else {
                maxLen = Math.max(maxLen, windowLen);
            }
            ++right;
        }
        return maxLen;
    }
}