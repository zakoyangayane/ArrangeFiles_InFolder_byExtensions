package arranging;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArrangeDirectory {
    static File file = new File("C:\\Users\\Zakoyan\\Desktop\\arrangeThis");

    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        arrangeFiles(listAllFiles(file, files));
    }

    private static List<File> listAllFiles(File file, List<File> files) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file1 : listFiles) {

                    /*if it is a file, add it to the list*/
                    if (file1.isFile()) {
                        files.add(file1);
                    }

                    /*if it is a directory, call again this function*/
                    else if (file.isDirectory()) {
                        listAllFiles(file1, files);
                    }
                }
            }
        }
        return files;
    }

    private static void arrangeFiles(List<File> allFiles) {
        new File(file + "\\images").mkdir();
        new File(file + "\\presentations").mkdir();
        new File(file + "\\PDFs").mkdir();
        new File(file + "\\zips").mkdir();
        new File(file + "\\docs").mkdir();

        File f = file;
        for (File file1 : allFiles) {
            if (file1.getAbsolutePath().endsWith(".jpg") ||
                    file1.getAbsolutePath().endsWith(".jfif") ||
                    file1.getAbsolutePath().endsWith(".PNG")) {
                f = new File(file + "\\images");
            } else if (file1.getAbsolutePath().endsWith(".pptx")) {
                f = new File(file + "\\presentations");
            } else if (file1.getAbsolutePath().endsWith(".pdf")) {
                f = new File(file + "\\PDFs");
            } else if (file1.getAbsolutePath().endsWith(".zip")) {
                f = new File(file + "\\zips");
            } else if (file1.getAbsolutePath().endsWith(".docx")) {
                f = new File(file + "\\docs");
            }
            move(f, file1);
        }
        f = file;
        deleteEmptyDirectories(f);

        System.out.println("Arranged all files successfully!");
    }

    private static void move(File f, File file1) {
        file1.renameTo(new File(f + "\\" + file1.getName()));
    }

    static List<File> parentDirectories = new ArrayList<>();

    private static void deleteEmptyDirectories(File f) {
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file1 : listFiles) {
                if (file1.isDirectory()) {
                    File[] listFiles2 = file1.listFiles();
                    if (listFiles2.length == 0) {
                        file1.delete();
                        for (int i = parentDirectories.size() - 1; i >= 0; i--) {
                            if (parentDirectories.get(i).length() == 0) {
                                parentDirectories.get(i).delete();
                            }
                        }
                    } else {
                        parentDirectories.add(file1);
                        deleteEmptyDirectories(file1);
                    }
                }
            }
        }
    }
}
