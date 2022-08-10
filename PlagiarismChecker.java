import java.io.FileNotFoundException;
import java.io.FileReader;
import datastructures.*;
import java.util.Scanner;
public class PlagiarismChecker {
    public QueueLink<String> textFiles = new QueueLink<String>();
 
    /*
     * @param paths: Rutas de los archivos que forman la BD.
     * 
     * @return : Booleano informando que no hubo errores con la lectura
     */
    public boolean loadFiles(String[] paths) {
        // Llenar las estructuras (recomendado)
        // Lectura del archivo (recomendado)
        String text = "";
        try{
            Scanner fileIn;
            for(String path : paths) {
                fileIn = new Scanner(new FileReader(path));
                
                while(fileIn.hasNextLine()) {
                    text += fileIn.nextLine() + "\n";
                }
                textFiles.add(text);
                text = "";
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
        ResultChecker result = null;
        // Retornar resultados del sistema (obligatorio)
        return result;
    }
}
