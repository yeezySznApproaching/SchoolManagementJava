package datamodel;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class SchoolManagement {
    public static void main(String[] args) {
        String filePath = "/Users/jee/Downloads/FileFolder/students.csv";

        try {
            // Read data from the CSV file
            FileReader fileReader = new FileReader(filePath);
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader());

            List<Students> students = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("Name");
                int age = Integer.parseInt(csvRecord.get("Age"));
                int year = Integer.parseInt(csvRecord.get("Year"));
                students.add(new Students());
            }

            // Sort by age
            Collections.sort(students, Comparator.comparingInt(student -> student.age));

            System.out.println("Sorted by Age:");
            for (Students student : students) {
                System.out.println(student);
            }

            // Sort by year
            Collections.sort(students, Comparator.comparingInt(student -> student.year));

            System.out.println("\nSorted by Year:");
            for (Students student : students) {
                System.out.println(student);
            }

            // Close the CSV parser
            csvParser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
