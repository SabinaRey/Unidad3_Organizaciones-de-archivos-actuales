
package modelo;
public class ModeloAgregarContacto {
    ArchivoTexto objArch;
    public void agregarContactos(String nombre,
            String apellidos,
            String telefono,
            String email){
        Contacto objCont = new Contacto();
        objCont.setNombre(nombre);
        objCont.setApellidos(apellidos);
        objCont.setTelefono(telefono);
        objCont.setEmail(email);
        
        this.objArch = new ArchivoTexto();
        this.objArch.abrirArchivoTexto('w', "contactos.csv"); //se cambia el .txt por .csv
        this.objArch.crearLinea(objCont.toString());
        this.objArch.cerrarArchivo('w');
    }  
}
