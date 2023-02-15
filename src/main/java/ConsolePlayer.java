import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ConsolePlayer implements Player {
    private final String name;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream out = System.out;

    public ConsolePlayer(String name) {
        this.name = name;
    }

    @Override
    public String makeAttempt() {
        out.print("Vas pokusaj: ");
        return SCANNER.next();
    }

    @Override
    public void printCorrectPositions(List<Integer> correctIndexes) {
        if (correctIndexes.isEmpty()) {
            System.out.println("Lista je prazma");
        } else {
            System.out.println("Slova na pozicijama "+ correctIndexes + " su pogodjena");
        }
    }

    @Override
    public void printWrongPositions(List<Integer> wrongIndexes) {
        if (wrongIndexes.isEmpty()) {
            System.out.println("Lista je prazma");
        } else {
            System.out.println("Slova na pozicijama "+ wrongIndexes + " nisu na pravom mjestu");        }
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    public static ConsolePlayer createPlayer(Scanner scanner) {
        System.out.print("Unesite vaše ime: ");
        return new ConsolePlayer(scanner.nextLine());
    }
}
