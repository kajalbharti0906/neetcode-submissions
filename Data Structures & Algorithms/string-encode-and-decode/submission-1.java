class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s:strs) {
            str.append(s.length());
            str.append(",");
        }
        str.append('#');
        for(String s:strs) {
            str.append(s);
        }
        return str.toString();
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
        for(int size:sizes) {
            res.add(str.substring(i, i+size));
            i+=size;
        }
        return res;
    }
}
