package org.hunter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFlattener {

    public static List<String> flattenCsv(String fileName) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove brackets and split by commas
                String[] parts = line.replaceAll("[{}]", "").split(",");
                for (String part : parts) {
                    if(!part.contains("system:serviceaccount:dev:aidp-api") && !part.trim().isEmpty()){
                        result.add(part.trim());
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            List<String> flattenedList = flattenCsv("/Users/hunter.stern/devnofamily.txt");
            flattenedList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}