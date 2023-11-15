import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyDataFile {
    public static ArrayList<String> readDataFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return lines;
    }

    public static void saveDataToFile(ArrayList<String> linesToSave, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (String line : linesToSave) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}