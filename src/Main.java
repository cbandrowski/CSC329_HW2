import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // PQList pqList = new PQList();
        File file = new File("/Users/cbandrowski/School/CSC311/CSC329_Assignment2/src/input.txt");

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        System.out.println("Reading file");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String nameline;
            while((nameline = br.readLine()) != null){
                String scoreLine = br.readLine();
                int score = Integer.parseInt(scoreLine.trim());
            //    pqList.add(new Player(nameline, score));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file");
        }
    }
}