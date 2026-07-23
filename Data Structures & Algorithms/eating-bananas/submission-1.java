class Solution {
    public int timeTaken(int[] piles, int k) {
        int time = 0;
        for(int i=0;i<piles.length;i++) {
            if(piles[i]<=k) {
                ++time;
            } else {
                time += (piles[i]/k);
                if(piles[i]%k != 0) {
                    ++time;
                }
            }
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int res = right;
        while(left<=right) {
            int mid = (left+right)/2;
            int time = timeTaken(piles, mid);
            if(time<=h) {
                res = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }
}
