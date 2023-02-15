import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dictionary implements WordGenerator {
    private final Random random = new Random();
    private final int wordLength;
    private final String[] words;

    public Dictionary(String[] words, int wordLength){
        if(words == null || wordLength <= 0) throw new IllegalArgumentException("Duzina rijeci mora biti pozitivna vrijednost");
        this.words = words;
        this.wordLength = wordLength;
    }

    public String generateWord(){
        List<String> validWords = Arrays.stream(words).filter(w -> w.length() == wordLength).toList();
        return validWords.get(random.nextInt(validWords.size()));
    }

    public boolean validateWord(String word){
        if(word == null) throw new IllegalArgumentException("Rijec ne moze biti null");
        return Arrays.asList(words).contains(word);
    }

}
