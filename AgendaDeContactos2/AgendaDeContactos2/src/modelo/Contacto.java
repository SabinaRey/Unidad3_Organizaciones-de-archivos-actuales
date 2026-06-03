package modelo;
public class Contacto {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    
    public Contacto ( String nombre, String apellidos, String telefono, String email) {        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public Contacto() {
        this("","","","");
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
    
     @Override
    public String toString(){
        return this.getNombre()+ ","+
                this.getApellidos()+"," +
                this.getTelefono()+ "," +
                this.getEmail();
    }
}
