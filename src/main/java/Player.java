import java.util.List;

public interface Player {
    String makeAttempt();
    void printCorrectPositions(List<Integer> correctIndexes);
    void printWrongPositions(List<Integer> wrongIndexes);
    String getPlayerName();
}
