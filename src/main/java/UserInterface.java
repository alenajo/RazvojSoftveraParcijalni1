import java.util.Scanner;

public class UserInterface {
    private final Game game;
    private final Scanner scanner;
    private boolean active;

    public UserInterface(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    private void printMenu(){
        System.out.println("1. Započni igru");
        System.out.println("2. Ispis rezultata");
        System.out.println("3. Obriši prošle rezultate");
        System.out.println("4. Izlaz");
    }

    public void start(){
        active = true;
        while (active) {
            printMenu();
            performAction(scanner.nextInt());
        }
    }

    private void performAction(int option) {
        scanner.nextLine();
        try {
            switch (option) {
                case 1 -> game.startGame(ConsolePlayer.createPlayer(scanner));
                case 2 -> game.printLeaderboard();
                case 3 -> game.resetScores();
                case 4 -> active = false;
                default -> System.out.println("Pogrešan izbor!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
