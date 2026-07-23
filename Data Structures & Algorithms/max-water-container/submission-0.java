class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int maxRes = 0;
        while(start<end) {
            int distance = end-start;
            int storedWater = Math.min(heights[start],heights[end])*distance;
            maxRes = Math.max(maxRes, storedWater);
            if(heights[start]>heights[end]) {
                --end;
            } else {
                ++start;
            }
        }
        return maxRes;
    }
}
