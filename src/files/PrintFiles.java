package files;

import java.io.File;

public class PrintFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Zakoyan\\IdeaProjects\\testepam");
        printFiles(file);
    }

    private static void printFiles(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {

                    /*if it is a file, print it*/
                    if (file1.isFile()) {
                        System.out.println(file1);
                    }

                    /*if it is a directory, call again this function*/
                    else if (file.isDirectory()) {
                        printFiles(file1);
                    }
                }
            }
        }
    }
}