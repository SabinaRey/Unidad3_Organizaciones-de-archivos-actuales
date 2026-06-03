
package modelo; //agregamos un nuevo modelo que nos mostrara los registros realizados

public class ModeloMostrarContacto {
    ArchivoTexto objArchivo;
    
    public String mostrarContactos() {
        objArchivo = new ArchivoTexto();
        objArchivo.abrirArchivoTexto('r', "contactos.csv");
        String datos = objArchivo.obtenerLineas();
        objArchivo.cerrarArchivo('r');
        return datos;
    }
}
