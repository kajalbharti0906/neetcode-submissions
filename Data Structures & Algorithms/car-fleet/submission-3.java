class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] pair = new int[len][2];
        for(int i=0;i<len;i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<len;i++) {
            stack.push((double)(target-pair[i][0])/pair[i][1]);
            if(stack.size()>=2 && stack.peek() <= stack.get(stack.size()-2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
