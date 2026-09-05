import java.util.Scanner;

public class FilePathSplitter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String originalPath;

        IO.print("Enter full file path: ");
        originalPath = sc.nextLine().trim();

        if (originalPath.isBlank()) {

            IO.println("Invalid path.");
            sc.close();
            return;
        }

        boolean hasBackslash = originalPath.contains("\\");

        String normalizedPath = originalPath.replace('\\', '/');

        int slashIndex = normalizedPath.lastIndexOf('/');

        String folder;
        String fileName;

        if (slashIndex != -1) {

            folder = normalizedPath.substring(0, slashIndex);
            fileName = normalizedPath.substring(slashIndex + 1);

        } else {

            folder = "none";
            fileName = normalizedPath;
        }

        String extension = getExtension(fileName);

        String pathStyle;

        if (hasBackslash) {

            pathStyle = "Windows Path";

        } else {

            pathStyle = "Unix Path";
        }

        IO.println("\n========== PATH INFORMATION ==========");
        IO.println("Original Path: " + originalPath);
        IO.println("Folder: " + folder);
        IO.println("File Name: " + fileName);
        IO.println("Extension: " + extension);
        IO.println("Path Style: " + pathStyle);

        sc.close();
    }
}
