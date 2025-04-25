import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileScan {
    public static void main(String[] args) {
        File file = null;

        if (args.length > 0) {
            // Use the command-line argument as the file path
            file = new File(args[0]);
        } else {
            // Launch JFileChooser to let the user pick a file
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }
        }

        if (file != null && file.exists()) {
            try {
                System.out.println("Scanning file: " + file.getName());
                Files.lines(Paths.get(file.getAbsolutePath())).forEach(System.out::println);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.err.println("No file selected or file does not exist.");
        }
    }
}