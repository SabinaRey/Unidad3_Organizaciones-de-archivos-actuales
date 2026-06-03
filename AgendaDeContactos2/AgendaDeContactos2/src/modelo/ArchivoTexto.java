
package modelo;

/*import vista.VistaListarContactos;*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoTexto {
    File fichero;
    FileWriter writer;
    PrintWriter pw;
    FileReader reader;
    BufferedReader buffer;
    
    public ArchivoTexto(){        
        this.fichero=null;
        this.writer=null;
        this.pw=null;
        this.reader=null;
        this.buffer=null;
    }
    
    private boolean establecerFlujo(String nombreArchivo){
        fichero = new File(nombreArchivo);
        return fichero.exists();
    }
    
    public boolean abrirArchivoTexto(char modo, String nombreArchivo){
        try {
            boolean existe= this.establecerFlujo(nombreArchivo);
            switch(modo){
                case 'w': this.writer = new FileWriter(this.fichero,true); //caso de escritura
                          this.pw = new PrintWriter(this.writer);
                          break;
                case 'r': //caso de lectura                        
                        if (!existe) return false;
                          this.reader = new FileReader(this.fichero);
                          this.buffer = new BufferedReader(this.reader); 
                          break;
            }                        
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void crearLinea(String linea){ //guarda nuestros registros dentro de nuestro archivo
        this.pw.println(linea);
    }
    
    public void cerrarArchivo(char modo){ //
        try {
            switch(modo){
                case 'w':this.pw.close();
                         this.writer.close();   
                         break;
                case 'r':this.buffer.close();
                         this.reader.close();
                         break;
            }
                     
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String obtenerLineas() {  //hacemos público el método para leer todas las lineas
        String lineas="";
        try {
            String linea=null;
            linea = buffer.readLine();
            while(linea!=null){
                lineas+=linea+"\n";
                linea = buffer.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineas;
    }
    
    /*protected Object[][] obtenerDatos() {            
        // Datos
        /*Object[][] datos = {
                {"Juan", "Pérez López", "52 55 1234 5678","juanperez123@correo.mx"},//México
                {"María", "García Ruiz","34 912 345 678","maria.garcia@ejcorre.es"},//España
                {"Carlos", "Hernández Soto", "1 202 555 0199", "robert.smith@samplemail.com"}//Estados Unidos
        };       
        return datos;    
    }*/
        
    
    /*public Object[][] obtenerMatrizLineas(int numColumnas){
        ArrayList<String> lineas= new ArrayList<> ();        
        try {
            String linea=null;
            linea = buffer.readLine();
            while(linea!=null){
                lineas.add(linea); 
                linea = buffer.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(ArchivoTexto.class.getName()).log(Level.SEVERE, null, ex);
        }                  
        Object[][] matrizDatos = new Object[lineas.size()][numColumnas];        
        for(int f=0;f<lineas.size();f++){
            String[] datos= lineas.get(f).split(",");
            for(int c=0; c<numColumnas;c++){
                matrizDatos[f][c]=datos[c];
            }            
        }                
        return matrizDatos;
    }*/                  
    
}
