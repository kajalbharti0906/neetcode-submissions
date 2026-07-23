class Solution {

    public String encode(List<String> strs) {
        StringBuilder wholeStr = new StringBuilder();
        for(String string:strs) {
            wholeStr.append(string.length());
            wholeStr.append(',');
        }
        wholeStr.append('#');
        for(String str:strs) {
            wholeStr.append(str);
        }
        return wholeStr.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> sizes = new ArrayList<>();
        int i=0;
        while(str.charAt(i)!='#') {
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i)!=',') {
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        List<String> res = new ArrayList<>();
        for(int sz : sizes) {
            res.add(str.substring(i, i+sz));
            i += sz;
        }
        return res;
    }
}
