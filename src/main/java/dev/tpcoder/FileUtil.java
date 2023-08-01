package dev.tpcoder;

import net.datafaker.Faker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static String FILE_PATH = "data.csv";

    public static void writingFile() {
        Faker faker = new Faker();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (long i = 0; i < 100_000_000L; i++) {
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = faker.internet().emailAddress();
                writer.write(firstName + "," + lastName + "," + email + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileFull() {
        try {
            var data = Files.readAllLines(Paths.get(FILE_PATH));
            data.forEach(line -> {
                String[] values = line.split(",");
                System.out.println("First name: " + values[0]);
                System.out.println("Last name: " + values[1]);
                System.out.println("Email: " + values[2]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("First name: " + values[0]);
                System.out.println("Last name: " + values[1]);
                System.out.println("Email: " + values[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
