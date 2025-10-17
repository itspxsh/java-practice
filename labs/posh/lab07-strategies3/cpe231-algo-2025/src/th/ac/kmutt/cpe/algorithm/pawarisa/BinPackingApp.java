package th.ac.kmutt.cpe.algorithm.pawarisa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.BFDHStrategy;
import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.CSVReader;
import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.PackingStrategy;
import th.ac.kmutt.cpe.algorithm.pawarisa.binpacking.Parcel;

public class BinPackingApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter container width: ");
        double containerW = sc.nextDouble();

        System.out.print("Enter container height: ");
        double containerH = sc.nextDouble();

        sc.close();

        String dataFolder = "src/th/ac/kmutt/cpe/algorithm/pawarisa/data";

        System.out.println("Using container size: " + containerW + "x" + containerH);
        System.out.println("Reading all CSVs from: " + dataFolder);

        // 🧩 Load all CSV files in the data folder
        List<Parcel> parcels = new ArrayList<>();
        File folder = new File(dataFolder);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

        if (files == null || files.length == 0) {
            System.err.println("❌ No CSV files found in " + dataFolder);
            return;
        }

        for (File f : files) {
            System.out.println("📦 Loading parcels from: " + f.getName());
            parcels.addAll(CSVReader.load(f.getPath()));
        }

        System.out.println("✅ Loaded total parcels: " + parcels.size());

        // 🧠 Choose strategy (Best-Fit Decreasing Height)
        PackingStrategy strat = new BFDHStrategy();
        strat.pack(containerW, containerH, parcels);

        int placed = 0;
        double usedArea = 0.0;
        for (Parcel p : parcels) {
            if (p.isPlaced()) {
                placed++;
                usedArea += p.area();
                System.out.println(p);
            } else {
                System.out.println("❌ NOT PLACED: " + p.getId() + " (" + p.getWidth() + "x" + p.getHeight() + ")");
            }
        }

        double containerArea = containerW * containerH;
        double emptyArea = containerArea - usedArea;
        System.out.printf("\n📊 Placed parcels: %d/%d\n", placed, parcels.size());
        System.out.printf("Used area: %.2f, Empty area: %.2f (Container area: %.2f)\n", usedArea, emptyArea, containerArea);

        sc.close();
    }
}
