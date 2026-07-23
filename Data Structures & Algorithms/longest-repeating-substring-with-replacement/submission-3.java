class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right<s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,map.get(s.charAt(right)));
            int windowLen = right-left+1;
            if(windowLen - maxFreq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                ++left;
            } else {
                res = Math.max(res,windowLen);
            }
            ++right;
        }
        return res;
    }
}
