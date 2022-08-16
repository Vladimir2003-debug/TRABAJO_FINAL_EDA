import java.io.File;
public class Main {
    public static void main(String[] args) {

        String pathDir = "./reuters21578";
        String pathFile = "./texto.txt";

        PlagiarismChecker pc = new PlagiarismChecker();
        
        File folder = new File(pathDir);

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
        ResultChecker results = pc.verifyPlagiarism(pathFile);
        System.out.println(results);
    }
}
