import java.util.Scanner;

public class FileNameAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fileName;

        IO.print("Enter file name: ");
        fileName = sc.nextLine().trim();

        int dotIndex = fileName.lastIndexOf('.');

        if (fileName.isBlank()
                || dotIndex == -1
                || dotIndex == 0
                || dotIndex == fileName.length() - 1) {

            IO.println("Invalid file name.");
            sc.close();
            return;
        }

        String baseName = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex + 1).toLowerCase();

        String type = classifyFile(extension);

        IO.println("\n========== FILE INFORMATION ==========");
        IO.println("File Name: " + fileName);
        IO.println("Base Name: " + baseName);
        IO.println("Extension: " + extension);
        IO.println("Type: " + type);

        sc.close();
    }
    public static String classifyFile(String extension) {

        if (extension.equals("txt")
                || extension.equals("pdf")
                || extension.equals("docx")) {

            return "Document";

        } else if (extension.equals("jpg")
                || extension.equals("png")
                || extension.equals("gif")) {

            return "Image";

        } else if (extension.equals("mp3")
                || extension.equals("wav")) {

            return "Audio";

        } else {

            return "Other";
        }
    }
}
