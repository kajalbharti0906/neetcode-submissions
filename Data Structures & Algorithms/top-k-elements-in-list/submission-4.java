class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        int cmp = Integer.compare(freq.get(b), freq.get(a));
        if (cmp == 0) {
            return Integer.compare(a, b); // smaller number first
        }
        return cmp;
    }
);
        pq.addAll(freq.keySet());
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}