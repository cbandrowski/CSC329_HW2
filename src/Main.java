import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap();
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
               pqHeap.add(new Player(nameline, score));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file");
        }



        //Display and remove players in order of highest score
        while (!pqHeap.isEmpty()) {
            System.out.println("Highest Score player: "+ pqHeap.getHighestScoreplayer());
        }
    }
}