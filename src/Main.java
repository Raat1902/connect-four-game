import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            ConnectFourGame game = new ConnectFourGame();

            while (true) {
                game.play(in);

                System.out.print("\nPlay again? (y/n): ");
                String again = in.nextLine().trim().toLowerCase(Locale.ROOT);
                if (!again.equals("y")) {
                    System.out.println("Bye!");
                    break;
                }
                System.out.println();
            }
        }
    }
}