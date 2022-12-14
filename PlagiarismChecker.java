import java.io.FileNotFoundException;
import java.io.FileReader;
import datastructures.binarytree.*;
import java.util.Scanner;

public class PlagiarismChecker {
    private BST<String>[] textFiles;
    private BST<String> textToChecker;

    /*
     * @param paths: Rutas de los archivos que forman la BD.
     * 
     * @return : Booleano informando que no hubo errores con la lectura
     */
    public boolean loadFiles(String[] paths) {
        // Llenar las estructuras (recomendado)
        // Lectura del archivo (recomendado)
        textFiles = new BST[paths.length];
        try {
            Scanner fileIn;
            for (int i = 0; i < paths.length; i++) {
                if (paths[i] == null)
                    continue;
                fileIn = new Scanner(new FileReader(paths[i]));

                textFiles[i] = inputTreeText(fileIn);
                fileIn.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar los archivos " + e);
            return false;
        }

        return false;
    }

    /*
     * @param path: Rutas del archivo donde colocaremos el texto con/plagio
     * 
     * @return : Resultados del sistema de deteccion de plagio.
     */
    public ResultChecker verifyPlagiarism(String path) {
        textToChecker = new BST<String>();
        try {
            Scanner fileIn;
            fileIn = new Scanner(new FileReader(path));
            textToChecker = inputTreeText(fileIn);
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

        ResultChecker result = new ResultChecker(textFiles.length, textFiles, textToChecker);
        // Retornar resultados del sistema (obligatorio)
        return result;
    }

    public BST<String> inputTreeText(Scanner fileIn) {
        BST<String> text = new BST<String>();
        String line;

        while (fileIn.hasNextLine()) {
            line = fileIn.nextLine();
            if (line.indexOf("<BODY>") != -1) {
                while (line.indexOf("</BODY>") == -1) {
                    line += fileIn.nextLine();
                }
                text.insert(line + " : ");
            }
        }
        return text;
    }

    public BST<String>[] getTextFiles() {
        return this.textFiles;
    }
}
