import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

/**
 * Main
 * This will display all methods from Priority Queue using PQHeap and HeapSort from Main
 * @author Cody Bandrowski
 */
public class Main {
    public static void main(String[] args) {
        PQHeap pqHeap = new PQHeap();
        File file = new File("/Users/cbandrowski/School/CSC311/CSC329_Assignment2/src/input.txt");

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        Player[] players = new Player[1000];
        int count = 0;
        System.out.println("Reading file");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String nameline;
            while((nameline = br.readLine()) != null){
                String scoreLine = br.readLine();
                int score = Integer.parseInt(scoreLine.trim());
                Player p = new Player(nameline, score);
                pqHeap.add(p);
                players[count++] = p;

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file");
        }

        //Printing the Heap
        System.out.println("Printing pq heap----------------------------------------------------------------");
        System.out.println(pqHeap.toString());

        //Copy Constructor
        PQHeap pqHeap2 = new PQHeap(pqHeap);
        System.out.println("Copy Constructor --------------------------------------------------------------------------------------------");
        System.out.println(pqHeap2.toString());

        //CreatClone
         PQHeap pqHeap3 = pqHeap.createClone();
        System.out.println("Create Clone -----------------------------------------------------------------------------------------------");
         System.out.println(pqHeap3.toString());

         //Clear and is empty
        System.out.println("PQHeap clear and is Empty -----------------------------------------------------------------------------------");
        pqHeap3.clear();
        System.out.println(pqHeap3.isEmpty());
        System.out.println(pqHeap3.toString());

        //Display and remove players in order of highest score
        System.out.println("Highest Player ----------------------------------------------------------------------------------------------");
        System.out.println("Highest Score player: "+ pqHeap.getHighestScoreplayer()+"\n");

        //HeapSort
        heapsort(players);
        System.out.println("Sorted players in HeapSort -----------------------------------------------------------------------------------");
        for (Player p : players) {
            System.out.println(p.toString());
        }

    }

    /**
     * heapsort method
     * this will sort the list in order of highest to lowest
     * @param pa
     */
    public static void heapsort(Player[] pa){
        PQHeap pqHeap = new PQHeap();
        for(Player p : pa){
            pqHeap.add(p);
        }
        for(int i=0;i<pa.length;i++){
            pa[i] = pqHeap.getHighestScoreplayer();
        }
    }
}