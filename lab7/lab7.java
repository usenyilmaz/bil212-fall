package lab7;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        ProbeHashMap<String, Integer> map = new ProbeHashMap<>(2027, 109345121);

        FileInputStream fis;
        Scanner sc;

        long totalProbes = 0;
        int maxProbes = 0;
        int wordCount = 0;

        try {
            fis = new FileInputStream("G:\\Drive'ım\\güz2025\\BİL212\\bil212-fall\\lab7\\words.txt");
            sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(", ");
                for (String word : words) {
                    map.put(word, null);
                    int probes = map.getLastProbeCount();
                    totalProbes += probes;
                    maxProbes = Math.max(maxProbes, probes);
                    wordCount++;
                }
            }
            sc.close();

            System.out
                    .println("-----------------------------probe count statistics for insertions--------------------");

            // Print statistics
            double avgProbes = (double) totalProbes / wordCount;
            System.out.println("Insertion complete.");
            System.out.println("Total words inserted: " + wordCount);
            System.out.println("Total probes: " + totalProbes);
            System.out.println("Average probes per insertion: " + avgProbes);
            System.out.println("Maximum probes: " + maxProbes);

        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        System.out.println("------------------------Search Results-------------------------");
        try {
            fis = new FileInputStream("G:\\Drive'ım\\güz2025\\BİL212\\bil212-fall\\lab7\\search.txt");
            sc = new Scanner(fis);
            long totalSearchProbes = 0;
            int maxSearchProbes = 0;
            int searchCount = 0;
            while (sc.hasNextLine()) {
                String word = sc.nextLine().trim();
                // search the original word (this sets probeCount inside the map)
                boolean found = searchWord(map, word);
                int probes = map.getLastProbeCount();
                totalSearchProbes += probes;
                maxSearchProbes = Math.max(maxSearchProbes, probes);
                searchCount++;

                if (found) {
                    System.out.println("The word '" + word + "' was found in the map.");
                } else {
                    System.out.println("The word '" + word + "' is mispelled. Checking for suggestions...");
                    ArrayList<String> suggestions = new ArrayList<>();
                    for (int i = 0; i < word.length(); i++) {
                        StringBuilder sb = new StringBuilder(word);
                        for (char c = 'a'; c <= 'z'; c++) {
                            sb.setCharAt(i, c);
                            String candidate = sb.toString();
                            boolean candFound = searchWord(map, candidate);
                            int candProbes = map.getLastProbeCount();
                            totalSearchProbes += candProbes;
                            maxSearchProbes = Math.max(maxSearchProbes, candProbes);
                            searchCount++;
                            if (candFound) {
                                suggestions.add(candidate);
                            }
                        }
                    }
                    System.out.print(word + ": ");
                    for (String suggestion : suggestions) {
                        System.out.print(suggestion + " ");
                    }
                    System.out.println();
                }
            }
            sc.close();

            System.out.println("------------------------Probe count Results for the searches-------------------------");
            // After all searches, print search probe statistics
            System.out.println("Total searches performed: " + searchCount);
            System.out.println("Total search probes: " + totalSearchProbes);
            System.out.println("Average probes per search: " + ((double) totalSearchProbes / searchCount));
            System.out.println("Maximum probes in a search: " + maxSearchProbes);
        } catch (Exception e) {
            System.out.println("An error occurred while reading the search file.");
            e.printStackTrace();
        }

        

    }

    public static boolean searchWord(ProbeHashMap<String, Integer> map, String word) {
        // return if the map contains the word as a key
        return map.containsKey(word);
    }
}
