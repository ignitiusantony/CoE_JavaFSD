package FirstWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ninth {
    private Set<String> keywords;

    public Ninth(Set<String> keywords) {
        this.keywords = keywords;
    }

    public void analyzeLogFile(String inputFile, String outputFile) {
        Map<String, Integer> keywordCount = new HashMap<>();
        List<String> matchingLines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                for (String keyword : keywords) {
                    if (line.contains(keyword)) {
                        matchingLines.add(line);
                        keywordCount.put(keyword, keywordCount.getOrDefault(keyword, 0) + 1);
                        break;
                    }
                }
            }

            writer.write("Log File Analysis Report\n");
            writer.write("===========================\n");
            for (String keyword : keywordCount.keySet()) {
                writer.write(keyword + ": " + keywordCount.get(keyword) + " occurrences\n");
            }
            writer.write("\nMatching Log Entries:\n");
            writer.write("===========================\n");
            for (String logLine : matchingLines) {
                writer.write(logLine + "\n");
            }
            System.out.println("Log file analysis completed. Check " + outputFile);
        } catch (IOException e) {
            System.err.println("Error processing log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Set<String> keywords = new HashSet<>(Arrays.asList("ERROR", "WARNING", "CRITICAL"));
        Ninth analyzer = new Ninth(keywords);
        analyzer.analyzeLogFile("logfile.txt", "Test2.txt");
    }
}
