import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {

    public List<String> scanOrder(String file){
        List<String> lines = new ArrayList<String>();
        Path path = Paths.get(file);
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line;
            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }


        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        } catch (IOException e) {
            System.err.println("There is something wrong with the file: " + e);
        }
        return lines;

    }

}
