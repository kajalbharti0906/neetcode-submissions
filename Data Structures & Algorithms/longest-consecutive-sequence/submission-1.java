class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],false);
        }
        int maxLength = 0;
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            int count = 1;
            while(map.containsKey(num-1) && map.get(num-1)==false) {
                map.put(num-1, true);
                ++count;
                --num;
            }
            num = nums[i];
            while(map.containsKey(num+1) && map.get(num+1)==false) {
                map.put(num+1, true);
                ++num;
                ++count;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
