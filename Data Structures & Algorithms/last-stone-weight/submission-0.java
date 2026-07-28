class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++) {
            pq.offer(stones[i]);
        }
        while(pq.size()>1) {
            int first = pq.poll();
            int second = pq.poll();
            int diff = first - second;
            pq.offer(diff);
        }
        return pq.peek();
    }
}
