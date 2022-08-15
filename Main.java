import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
public class Main extends JFrame {
    public String path = ".";
    public String[] paths;
    public PlagiarismChecker pc;
    public Main(){
        setTitle("Plagiarism Checker");
        setSize(300,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);

    }
    private void createContents(){
        JButton button = new JButton("Select Directory");
        
        Listener listener = new Listener();
        add(button);
        button.addActionListener(listener);
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser;
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Select Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                path = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("No Selection ");
            }
        }
    }

    public static void main(String[] args) {
        new Main();


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

    }
}
