package th.ac.kmutt.cpe.algorithm.pawarisa.binpacking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV loader: each line contains width,height (no header required).
 * Produces Parcel objects with ids P1, P2, ...
 */
public class CSVReader {
    public static List<Parcel> load(String path) throws IOException {
        List<Parcel> parcels = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int id = 1;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("[,\\t; ]+");
                try {
                    if (parts.length >= 2) {
                        double w = Double.parseDouble(parts[0]);
                        double h = Double.parseDouble(parts[1]);
                        parcels.add(new Parcel("P" + id, w, h));
                        id++;
                    }
                } catch (NumberFormatException e) {
                    // skip invalid lines
                }
            }
        }
        return parcels;
    }
}
