import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        PlagiarismChecker pc = new PlagiarismChecker();

        File folder = new File("./reuters21578");
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
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());
        System.out.println(pc.textFiles.poll().inOrder());

    }
}
