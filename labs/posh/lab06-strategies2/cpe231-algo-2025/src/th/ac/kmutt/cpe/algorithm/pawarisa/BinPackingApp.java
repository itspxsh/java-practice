package th.ac.kmutt.cpe.algorithm.pawarisa;

import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.*;
import th.ac.kmutt.cpe.algorithm.pawarisa.sorting.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BinPackingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter CSV path (e.g., Box Size 1.csv): ");
            String path = sc.nextLine().trim();
            if (path.isEmpty()) {
                path = "Box Size 1.csv";
            }

            String fullPath = "src/th/ac/kmutt/cpe/algorithm/pawarisa/Data/" + path;

            System.out.print("Enter box width: ");
            double bw = Double.parseDouble(sc.nextLine().trim());

            System.out.print("Enter box height: ");
            double bh = Double.parseDouble(sc.nextLine().trim());

            List<Parcel> parcels = CSVReader.load(fullPath);

            SortContext sorter = new SortContext(new AreaSortStrategy());
            sorter.sort(parcels);

            Box box = new Box(bw, bh);
            PackingStrategy strategy = new FirstFitDecreasingStrategy();
            PackingStrategy.PackResult result = strategy.pack(box, parcels);

            System.out.println("\n=== Packing Result ===");
            System.out.println(result.getBox());

            System.out.println("\n-- Placed --");
            for (Parcel p : result.getBox().getPlaced()) {
                System.out.println(p);
            }

            System.out.println("\n-- Not Placed --");
            for (Parcel p : result.getNotPlaced()) {
                System.out.println(p);
            }

            System.out.printf("\nRemaining Area: %.2f\n", result.getBox().remainingArea());

        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}