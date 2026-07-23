class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++) {
            if(map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                return new int[]{index,i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
