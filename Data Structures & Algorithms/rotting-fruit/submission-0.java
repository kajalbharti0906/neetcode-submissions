class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j,0});
                } else if(grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        if(fresh == 0) {
            return 0;
        }
        int minuteElapse = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int min = curr[2];
            minuteElapse = Math.max(minuteElapse, min);
            for(int[] d:dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    --fresh;
                    queue.offer(new int[]{nr,nc,min+1});
                }
            }
        }
        return fresh == 0 ? minuteElapse : -1;
    }
}
