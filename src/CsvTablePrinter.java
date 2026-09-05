public class CsvTablePrinter {

    public static void main(String[] args) {

        String[] csvRows = {
                "Name,Age,City",
                "Ali,25,Muscat",
                "Sara,30,Nizwa",
                "Ahmed,22,Salalah",
                "Maha,28,Sohar",
                "Invalid,Row"
        };

        String[] headers = csvRows[0].split(",");

        int shownRows = 0;

        IO.println("========== CSV TABLE ==========\n");

        String format = "%-15s %-10s %-15s%n";

        System.out.printf(
                format,
                headers[0].trim(),
                headers[1].trim(),
                headers[2].trim()
        );

        IO.println("-".repeat(40));

        for (int i = 1; i < csvRows.length; i++) {

            String[] fields = csvRows[i].split(",");

            if (fields.length != headers.length) {

                IO.println(
                        "Skipping malformed row: " + csvRows[i]
                );

                continue;
            }

            System.out.printf(
                    format,
                    fields[0].trim(),
                    fields[1].trim(),
                    fields[2].trim()
            );

            shownRows++;
        }

        IO.println("-".repeat(40));

        IO.println("Data rows shown: " + shownRows);
    }
}
