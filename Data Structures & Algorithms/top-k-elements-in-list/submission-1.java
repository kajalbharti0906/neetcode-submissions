class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(freq.keySet());
        list.sort((a, b) -> freq.get(b) - freq.get(a));
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}