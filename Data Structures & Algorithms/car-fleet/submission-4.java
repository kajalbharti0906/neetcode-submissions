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
            double time = (double)(target-pair[i][0])/pair[i][1];
            if(stack.isEmpty()) {
                stack.push(time);
            } else if(time>stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
