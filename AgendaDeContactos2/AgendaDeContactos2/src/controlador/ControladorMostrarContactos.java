
package controlador;

import modelo.ModeloMostrarContacto;

public class ControladorMostrarContactos {
    ModeloMostrarContacto objModelo;
    
    public ControladorMostrarContactos(){
        objModelo = new ModeloMostrarContacto();
    }
    
    public String mostrarContactos(){
        return objModelo.mostrarContactos();
    }
}
