// Angel Guerra (angel.guerra@malad.us)
// For CTE Software Development 2
// Instructor: Mr. Gross

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LetterFrequency {

    public static void main(String[] args) {

        try {
            
            File file = new File("LetterFrequency.csv");
            Scanner scanner = new Scanner(file);

            int totalFrequency = 0;
            double totalPercentage = 0.0;
            int count = 0;

            // This skips the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            System.out.println("Letter\tFrequency\tPercentage");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Remove quotes
                line = line.replace("\"", "");

                // This splits the line by comma
                String[] parts = line.split(",");

                String letter = parts[0].trim();
                int frequency = Integer.parseInt(parts[1].trim());
                double percentage = Double.parseDouble(parts[2].trim());

                totalFrequency += frequency;
                totalPercentage += percentage;
                count++;

                // Will print out each line
                System.out.println(letter + "\t" + frequency + "\t\t" + percentage);
            }

            double averageFrequency = (double) totalFrequency / count;

            System.out.println("--------------------------------------------------");
            System.out.println("TOTAL\t" + averageFrequency + "\t" + totalPercentage);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
