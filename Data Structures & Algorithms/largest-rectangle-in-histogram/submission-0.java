class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++) {
            int curr = heights[i];
            while(!stack.isEmpty() && curr<=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=len-1;i>=0;i--) {
            int curr = heights[i];
            while(!stack.isEmpty() && curr<=heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                right[i] = len;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<len;i++) {
            int height = (right[i]-left[i]-1)*heights[i];
            ans = Math.max(height, ans);
        }
        return ans;
    }
}
