import java.awt.*;
import java.io.File;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String path = "./reuters21578";
        
        
        JFileChooser chooser;
        String choosertitle = "Select Directory";
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No Selection ");
        }

        PlagiarismChecker pc = new PlagiarismChecker();

        File folder = new File(path);

        File[] listOfFiles = folder.listFiles();
        String[] paths = new String[listOfFiles.length];
        int i = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                paths[i] = file.getPath();
            }
            i++;
        }

        pc.loadFiles(paths);
        System.out.println(pc.textFiles.size());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println();
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());

    }
}
