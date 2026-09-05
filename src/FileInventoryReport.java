public class FileInventoryReport {

    public static void main(String[] args) {

        String[] records = {
                "report.pdf,120",
                "photo.png,340",
                "song.mp3,5200",
                "app.java,8",
                "notes.txt,25",
                "archive.zip,900",
                "script.py,15"
        };

        int totalFiles = 0;

        double totalSize = 0;

        int documentCount = 0;
        int imageCount = 0;
        int audioCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        String largestFile = "";
        double largestSize = 0;

        IO.println("========== FILE INVENTORY ==========\n");

        for (String record : records) {

            String[] fields = record.split(",");

            if (fields.length != 2) {

                IO.println(
                        "Skipping malformed record: " + record
                );

                continue;
            }

            String fileName = fields[0].trim();
            String sizeText = fields[1].trim();

            double size;

            try {

                size = Double.parseDouble(sizeText);

            } catch (NumberFormatException e) {

                IO.println(
                        "Skipping invalid size: " + record
                );

                continue;
            }

            String extension = getExtension(fileName);

            String type = classifyFile(extension);

            totalSize += size;
            totalFiles++;

            if (type.equals("Document")) {

                documentCount++;

            } else if (type.equals("Image")) {

                imageCount++;

            } else if (type.equals("Audio")) {

                audioCount++;

            } else if (type.equals("Code")) {

                codeCount++;

            } else {

                otherCount++;
            }

            if (size > largestSize) {

                largestSize = size;
                largestFile = fileName;
            }

            IO.println(
                    "Name: " + fileName
                            + " | Extension: " + extension
                            + " | Type: " + type
                            + " | Size: " + size + " KB"
            );
        }

        IO.println("\n========== INVENTORY SUMMARY ==========");
        IO.println("Total Files: " + totalFiles);
        IO.println("Total Size: " + totalSize + " KB");

        IO.println("\nFile Categories:");
        IO.println("Documents: " + documentCount);
        IO.println("Images: " + imageCount);
        IO.println("Audio: " + audioCount);
        IO.println("Code: " + codeCount);
        IO.println("Other: " + otherCount);

        IO.println("\nLargest File:");
        IO.println(
                largestFile + " (" + largestSize + " KB)"
        );
    }
}
