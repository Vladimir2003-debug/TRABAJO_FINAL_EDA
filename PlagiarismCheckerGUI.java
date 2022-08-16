import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class PlagiarismCheckerGUI extends JFrame {
    private String path = "./reuters21578";
    private String[] paths;
    private String pathFile = "./texto.txt";
    private JButton btnSelectDir;
    private JButton btnChecker;
    private JButton btnSelectFile;
    private JTextField pathTextField;
    private JTextField pathDataBase;

    public static PlagiarismChecker pc;

    public PlagiarismCheckerGUI() {
        setTitle("Plagiarism Checker");
        setSize(1200, 300);
        setLayout(new GridLayout(2, 2, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);

    }

    private void createContents() {
        btnSelectDir = new JButton("Select Directory");
        btnChecker = new JButton("Checker");
        btnSelectFile = new JButton("Select File");
        JTextArea instrucciones = new JTextArea("La forma de uso de este programa es la siguiente:\n" +
                "- Select Dir : Para seleccionar un directorio\n" +
                "- Select File : Para la ubicacion del archivo para comprobacion\n" +
                "- Checker : Para evaluar y comparar los archivos y evaluar si hubo plagio o no\n");
        instrucciones.setEditable(false);
        JTextArea descripcion = new JTextArea("En este programa se comparara\n" +
                "un archivo con las distintas bases de datos para evaluar si hubo plagio o no en ellas\n" +
                "el programa se realizo mediante el uso de arboles binarios");
        descripcion.setEditable(false);

        pathTextField = new JTextField(pathFile, 24);
        pathDataBase = new JTextField(path, 24);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2, 5, 5));
        JPanel sub1p2 = new JPanel();
        JPanel sub2p2 = new JPanel();

        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        Listener listener = new Listener();

        p1.add(instrucciones);

        p4.add(btnChecker);

        sub1p2.add(pathDataBase);
        sub1p2.add(btnSelectDir);

        sub2p2.add(pathTextField);
        sub2p2.add(btnSelectFile);

        p2.add(sub1p2);
        p2.add(sub2p2);

        p3.add(descripcion);
        add(p1);
        add(p2);
        add(p3);
        add(p4);

        btnSelectFile.addActionListener(listener);
        btnSelectDir.addActionListener(listener);
        btnChecker.addActionListener(listener);
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
                    pathDataBase.setText(chooser.getSelectedFile().getAbsolutePath());
                    path = pathDataBase.getText();

                }
            } else if (e.getActionCommand().equals("Select File")) {
                JFileChooser chooser;
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Select File");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    pathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
                    pathFile = pathTextField.getText();
                }

            } else if (e.getActionCommand().equals("Checker")) {

                pc = new PlagiarismChecker();

                File folder = new File(path);

                File[] listOfFiles = folder.listFiles();
                paths = new String[listOfFiles.length];
                int i = 0;
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        paths[i] = file.getPath();
                    }
                    i++;
                }

                pc.loadFiles(paths);
                System.out.println(pc.getTextFiles()[10].inOrder());
                ResultChecker results = pc.verifyPlagiarism(pathFile);
                
                int size = results.getResult().length; 
                i = 0;
                while(i < size) {
                    add(new JLabel(i + " Resultado :" + results.getResult()[i]));
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new PlagiarismCheckerGUI();
        /* 
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
        System.out.println(pc.getTextFiles()[10].inOrder());

        */
    }
}
