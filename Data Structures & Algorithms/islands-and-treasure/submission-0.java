class Solution {
    public void islandsAndTreasure(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length;
        int cols = rooms[0].length;

        int[] queue = new int[rows*cols];
        int head = 0;
        int tail = 0;

        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                if(rooms[r][c] == 0) {
                    queue[tail++] = r * cols + c;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(head<tail) {
            int encoded = queue[head++];
            int r = encoded/cols;
            int c = encoded%cols;
            for(int d = 0;d<4;d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0 && nr<rows && nc>=0 && nc<cols && rooms[nr][nc] == Integer.MAX_VALUE) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue[tail++] = nr * cols + nc;
                }
            }
        }
    }
}
