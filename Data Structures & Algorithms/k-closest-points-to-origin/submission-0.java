class Solution {
    class Pair<K,V>{
        K key;
        V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    public int distanceFromOrigin(int x, int y) {
        return x * x + y * y;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a,b)->b.key-a.key);
        for(int i=0;i<points.length;i++) {
            int distance = distanceFromOrigin(points[i][0],points[i][1]);
            pq.offer(new Pair<>(distance, i));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(k>0) {
            Pair<Integer, Integer> p = pq.poll();
            ans[i][0] = points[p.value][0];
            ans[i][1] = points[p.value][1];
            ++i;
            --k;
        }
        return ans;
    }
}
