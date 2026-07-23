class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) {
            return "";
        }
        int countRequired = t.length();
        Map<Character, Integer> tmap = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int minLen = s.length()+1;
        int start = -1;
        int end = -1;
        while(right<s.length()) {
            if(tmap.containsKey(s.charAt(right)) && tmap.get(s.charAt(right))>0) {
                --countRequired;
            }
            tmap.put(s.charAt(right),tmap.getOrDefault(s.charAt(right),0)-1);
            while(left<=right && countRequired == 0) {
                int len = right-left+1;
                if(len<minLen) {
                    start = left;
                    end = right;
                    minLen = len;
                }
                tmap.put(s.charAt(left),tmap.getOrDefault(s.charAt(left),0)+1);
                if(tmap.get(s.charAt(left))>0) {
                    ++countRequired;
                }
                ++left;
            }
            ++right;
        }
        if(start == -1) {
            return "";
        }
        return s.substring(start,end+1);
    }
}
