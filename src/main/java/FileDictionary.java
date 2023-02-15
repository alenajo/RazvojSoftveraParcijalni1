import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDictionary extends Dictionary {
    public FileDictionary(String fileName, int wordLength) throws IOException {
        super(Files.readAllLines(Paths.get(fileName)).toArray(String[]::new), wordLength);
    }
}
