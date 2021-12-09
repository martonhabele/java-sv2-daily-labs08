package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static void main(String[] args) {
        int min = new FileReader().findMinimumTemperatureSpread("weather.dat");
        System.out.println(min);
    }

    public int findMinimumTemperatureSpread(String filename) {
        try {
            int day, maxTemp, minTemp, spread;
            int minSpread = 1000;
            int minDay = 0;

            List<String> lines = Files.readAllLines(Paths.get("src/main/java/day04/resources/weather.dat"));

            for (int i = 2; i < lines.size() - 1; i++) {
                day = Integer.parseInt(lines.get(i).substring(2, 4).trim());
                maxTemp = Integer.parseInt(lines.get(i).substring(6, 8).trim());
                minTemp = Integer.parseInt(lines.get(i).substring(12, 14).trim());
                spread = maxTemp - minTemp;
                if (minSpread > spread) {
                    minSpread = spread;
                    minDay = day;
                }
            }
            return minDay;
        } catch (IOException e) {
            throw new IllegalStateException("File cannot be read!", e);
        }
    }
}