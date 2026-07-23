class Solution {

    public String sort(String str) {
        String sorted = str.chars()
                   .sorted()
                   .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                   .toString();
        return sorted;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            String str = strs[i];
            String sorted = sort(str);
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            } 
            map.get(sorted).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> mp:map.values()) {
            ans.add(mp);
        }
        return ans;
    }
}
