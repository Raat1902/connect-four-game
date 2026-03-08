import java.util.Locale;
import java.util.Scanner;

public final class ConnectFourGame {
    private final Board board = new Board();

    public void play(Scanner in) {
        board.clear();
        char currentPlayer = 'X';

        System.out.println("=== Connect Four (Java) ===");
        System.out.println("Players: X and O");
        System.out.println("Enter a column number (0-" + (Board.COLS - 1) + "), or 'q' to quit.");
        board.print();

        while (true) {
            System.out.print("\nPlayer " + currentPlayer + ", choose column: ");
            String line = in.nextLine().trim();

            String lower = line.toLowerCase(Locale.ROOT);
            if (lower.equals("q") || lower.equals("quit")) {
                System.out.println("Goodbye!");
                return;
            }

            Integer col = parseInt(line);
            if (col == null) {
                System.out.println("Invalid input. Example: 3");
                continue;
            }

            if (!board.isValidMove(col)) {
                System.out.println("Invalid move. Try a different column.");
                continue;
            }

            int row = board.drop(col, currentPlayer);
            board.print();

            if (board.isWinningMove(row, col, currentPlayer)) {
                System.out.println("\nPlayer " + currentPlayer + " wins!");
                return;
            }

            if (board.isFull()) {
                System.out.println("\nIt's a draw!");
                return;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}