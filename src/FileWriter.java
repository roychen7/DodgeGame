import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileWriter {
    public List<String> readFromFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return lines;
    }

    public void writeToFile(String filePath, String content) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.add(content);
        ArrayList<Integer> temp = new ArrayList<>();
        for (String s : lines) {
            temp.add(Integer.parseInt(s));
        }
        Collections.sort(temp, Collections.reverseOrder());
        lines.clear();
        for (int i = 0; i < temp.size(); i++) {
            lines.add(Integer.toString(temp.get(i)));
        }
        java.io.FileWriter tempWriter = new java.io.FileWriter(new File(filePath), false);
        tempWriter.write("");

        for (int i = 0; i < lines.size(); i++) {
            java.io.FileWriter write = new java.io.FileWriter(new File(filePath), true);
            PrintWriter writer = new PrintWriter(write);
            writer.printf(lines.get(i) + "\n");
            writer.close();
        }
    }
}
