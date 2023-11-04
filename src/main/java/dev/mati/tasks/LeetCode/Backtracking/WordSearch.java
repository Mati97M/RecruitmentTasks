package dev.mati.tasks.LeetCode.Backtracking;

public class WordSearch {
    private int rows;
    private int cols;
    private String word;

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCB"));
    }
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.word = word;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(Character.compare(board[r][c], word.charAt(0)) == 0)
                    if(bDFS(r, c, board, 0))
                        return true;
            }
        }
        return false;
    }
    private boolean bDFS(int r, int c, char[][] board, int i) {
        if(i == word.length())
            return true;

        if(r < 0 || r >= rows || c < 0 || c >= cols
                || Character.compare(word.charAt(i), board[r][c]) != 0
        )
            return false;

        char original = board[r][c];
        board[r][c] = '#';

        boolean found = bDFS(r, c - 1, board, i + 1) ||
                bDFS(r - 1, c, board, i + 1) ||
                bDFS(r, c + 1, board, i + 1) ||
                bDFS(r + 1, c, board, i + 1);

        board[r][c] = original;

        return found;
    }
}
