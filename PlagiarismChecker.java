import java.io.FileNotFoundException;
import java.io.FileReader;
import datastructures.queue.*;
import datastructures.binarytree.*;
import java.util.Scanner;
public class PlagiarismChecker {
    public QueueLink<BinaryTree<String>> textFiles; 
    public BST<String> textToChecker;
    
    /*
     * @param paths: Rutas de los archivos que forman la BD.
     * 
     * @return : Booleano informando que no hubo errores con la lectura
     */
    public boolean loadFiles(String[] paths) {
        // Llenar las estructuras (recomendado)
        // Lectura del archivo (recomendado)
        textFiles = new QueueLink<BinaryTree<String>>();
        try{
            Scanner fileIn;
            for(String path : paths) {
                fileIn = new Scanner(new FileReader(path));
                
                textFiles.add(inputTreeText(fileIn));
                fileIn.close();
            }
        } catch(FileNotFoundException e){ 
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
            textToChecker= inputTreeText(fileIn);
            fileIn.close();
        } catch(FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        
        ResultChecker result = new ResultChecker();
        // Retornar resultados del sistema (obligatorio)
        return result;
    }
    public BST<String> inputTreeText(Scanner fileIn) {
        BST<String> text = new BST<String>();
        while(fileIn.hasNextLine()){
            text.insert(fileIn.nextLine());
        }
        return text;
    }

    public QueueLink<BinaryTree<String>> getTextFiles() {
        return this.textFiles;
    }
}
