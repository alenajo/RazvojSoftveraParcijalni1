import java.util.HashMap;
import java.util.Map;

public class Game {
    private final Map<String, Integer> scores = new HashMap<>();
    private final WordGenerator generator;

    public Game(WordGenerator generator) {
        this.generator = generator;
    }

    public void startGame(Player player){
        String generisanaRijec = generator.generateWord();
        int brojPokusaja = 0;
        do {
            String pokusaj;
            do {
                pokusaj = player.makeAttempt();
            } while (pokusaj.length() != generisanaRijec.length() || !generator.validateWord(generisanaRijec));
            brojPokusaja++;

            if (pokusaj.equals(generisanaRijec)) {
                System.out.println("Pogodili ste rijec u " + brojPokusaja + " pokusaja");
                addScore(player.getPlayerName(), brojPokusaja);
                return;
            }


        } while (true);

    }



    public void printLeaderboard() {
        if(scores.isEmpty()) {
            System.out.println("Nema odigranih partija");
        }
        else {
            scores.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> {
                System.out.println(e.getKey() + " sa rezultatom " + e.getValue());
            });
        }
    }

    public void addScore(String playerName, int attempts) {
       int staraVrijednost = scores.getOrDefault(playerName, Integer.MAX_VALUE);
       scores.put(playerName, Math.min(staraVrijednost, attempts));
    }
    public void resetScores(){
        scores.clear();
    }
}
