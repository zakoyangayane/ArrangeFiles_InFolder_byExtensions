package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CopyFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Zakoyan\\Downloads\\newText.txt");
        File moveTo = new File("C:\\Users\\Zakoyan\\Documents\\ourText.txt");

        copyFiles(file, moveTo);
    }

    private static void copyFiles(File file, File moveTo) {
        try {
            Files.copy(file.toPath(), moveTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copy done successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
