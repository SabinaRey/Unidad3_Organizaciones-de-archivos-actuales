
package controlador;
import modelo.ModeloAgregarContacto;
public class ControladorAgregarContactos {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    ModeloAgregarContacto objModeloAgregarCont;
    
    public ControladorAgregarContactos(){
        this.objModeloAgregarCont = new ModeloAgregarContacto();
    }
    
    public void agregarContactos(String nombre,
            String apellidos,
            String telefono,
            String email){
        
        this.objModeloAgregarCont.agregarContactos(nombre, apellidos, telefono, email);
    } 
}
