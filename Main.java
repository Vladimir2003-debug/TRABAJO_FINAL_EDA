import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class Main extends JFrame {
    private String path = ".";
    private String[] paths;
    private JButton btnSelectDir;
    private JButton btnChecker;

    public static PlagiarismChecker pc;

    public Main() {
        setTitle("Plagiarism Checker");
        setSize(300, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);

    }

    private void createContents() {
        btnSelectDir = new JButton("Select Directory");
        btnChecker = new JButton("Checker");

        add(btnChecker);
        add(btnSelectDir);

        btnSelectDir.addActionListener(new Listener());
        btnChecker.addActionListener(new Listener());
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Select Directory")) {
                JFileChooser chooser;
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Select Directory");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = chooser.getSelectedFile().getAbsolutePath();
                    pc = new PlagiarismChecker();

                    //
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
                    pc.getTextFiles()[1].inOrder();
                    
                }
            } else if (e.getActionCommand().equals("Checker")) {
                System.out.println("fiorella");
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
