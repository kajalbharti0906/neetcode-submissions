class Solution {

    public boolean checkRow(char[][] board, int row, int col, char num) {
        int colSize = board[row].length;
        for(int i=0;i<colSize;i++) {
            if(i!=col && board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCol(char[][] board, int row, int col, char num) {
        int rowSize = board.length;
        for(int i=0;i<rowSize;i++) {
            if(i!=row && board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBox(char[][] board, int row, int col, char num) {
        int rowStart = (row/3)*3;
        int rowEnd = rowStart + 3;
        int colStart = (col/3)*3;
        int colEnd = colStart + 3;
        for(int i=rowStart;i<rowEnd;i++) {
            for(int j=colStart;j<colEnd;j++) {
                if(i!=row && j!=col && board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]!='.') {
                    if(checkRow(board, i, j, board[i][j]) || checkCol(board, i, j, board[i][j]) || checkBox(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
