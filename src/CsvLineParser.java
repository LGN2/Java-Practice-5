import java.util.Scanner;

public class CsvLineParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String record;

        IO.print("Enter CSV record (Name,Age,City): ");
        record = sc.nextLine();

        String[] fields = record.split(",");

        if (fields.length != 3) {

            IO.println("Invalid record.");
            sc.close();
            return;
        }

        String name = fields[0].trim();
        String ageText = fields[1].trim();
        String city = fields[2].trim();

        int age;

        try {

            age = Integer.parseInt(ageText);

        } catch (NumberFormatException e) {

            IO.println("Invalid record.");
            sc.close();
            return;
        }

        String ageGroup = classifyAge(age);

        IO.println("\n========== PERSON INFORMATION ==========");
        IO.println("Name: " + name);
        IO.println("Age: " + age);
        IO.println("City: " + city);
        IO.println("Age Group: " + ageGroup);

        sc.close();
    }
}
