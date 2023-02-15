import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface(new Game(new FileDictionary("words_alpha.txt", 5)), new Scanner(System.in));
        ui.start();
    }
}
