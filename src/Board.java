import java.util.Arrays;

public final class Board {
    public static final int ROWS = 6;
    public static final int COLS = 7;

    private final char[][] grid = new char[ROWS][COLS];

    public Board() {
        clear();
    }

    public void clear() {
        for (int r = 0; r < ROWS; r++) {
            Arrays.fill(grid[r], ' ');
        }
    }

    public boolean isValidMove(int col) {
        return col >= 0 && col < COLS && grid[0][col] == ' ';
    }

    public int drop(int col, char player) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (grid[r][col] == ' ') {
                grid[r][col] = player;
                return r;
            }
        }
        return -1;
    }

    public boolean isFull() {
        for (int c = 0; c < COLS; c++) {
            if (grid[0][c] == ' ') return false;
        }
        return true;
    }

    public boolean isWinningMove(int row, int col, char player) {
        return hasFour(row, col, player, 0, 1)   // horizontal
                || hasFour(row, col, player, 1, 0)   // vertical
                || hasFour(row, col, player, 1, 1)   // diagonal down-right
                || hasFour(row, col, player, 1, -1); // diagonal down-left
    }

    private boolean hasFour(int row, int col, char player, int dr, int dc) {
        int count = 1;
        count += countDirection(row, col, player, dr, dc);
        count += countDirection(row, col, player, -dr, -dc);
        return count >= 4;
    }

    private int countDirection(int row, int col, char player, int dr, int dc) {
        int r = row + dr;
        int c = col + dc;
        int count = 0;

        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == player) {
            count++;
            r += dr;
            c += dc;
        }
        return count;
    }

    public void print() {
        System.out.println();
        for (int r = 0; r < ROWS; r++) {
            System.out.print("|");
            for (int c = 0; c < COLS; c++) {
                char cell = grid[r][c];
                System.out.print((cell == ' ' ? '.' : cell) + "|");
            }
            System.out.println();
        }

        System.out.print(" ");
        for (int c = 0; c < COLS; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}