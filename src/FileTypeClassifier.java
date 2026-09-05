import java.util.ArrayList;
import java.util.List;

public class FileTypeClassifier {

    public static void main(String[] args) {

        List<String> fileNames = new ArrayList<>();

        fileNames.add("report.pdf");
        fileNames.add("notes.txt");
        fileNames.add("photo.jpg");
        fileNames.add("logo.png");
        fileNames.add("Main.java");
        fileNames.add("script.py");
        fileNames.add("website.js");
        fileNames.add("README");
        fileNames.add("music.mp3");

        int documentCount = 0;
        int imageCount = 0;
        int codeCount = 0;
        int otherCount = 0;

        IO.println("========== FILE TYPE CLASSIFIER ==========");

        for (String fileName : fileNames) {

            String extension = getExtension(fileName);
            String type = classifyFile(extension);

            IO.println(fileName + " -> " + type);

            if (type.equals("Document")) {

                documentCount++;

            } else if (type.equals("Image")) {

                imageCount++;

            } else if (type.equals("Code")) {

                codeCount++;

            } else {

                otherCount++;
            }
        }

        IO.println("\n========== SUMMARY ==========");
        IO.println("Total Files: " + fileNames.size());
        IO.println("Documents: " + documentCount);
        IO.println("Images: " + imageCount);
        IO.println("Code Files: " + codeCount);
        IO.println("Other Files: " + otherCount);
    }
}
