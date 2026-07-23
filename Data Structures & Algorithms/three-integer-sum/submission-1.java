class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int target = -1*nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end) {
                int sum = nums[start] + nums[end];
                if(sum<target) {
                    ++start;
                } else if(sum>target) {
                    --end;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    if(!ans.contains(List.of(nums[i],nums[start],nums[end]))) {
                        ans.add(List.of(nums[i],nums[start],nums[end]));
                    }
                    ++start;
                    --end;
                }
            }
            // while(i<nums.length-1 && nums[i]==nums[i+1]) {
            //         ++i;
            // }
        }
        return ans;
    }
}
