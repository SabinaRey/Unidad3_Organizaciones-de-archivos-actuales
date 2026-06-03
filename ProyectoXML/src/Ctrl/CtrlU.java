/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ctrl;

import Modelo.ArchivoXML;
import Modelo.Usuario;
import Vista.UIVista;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CtrlU {

    ArchivoXML objArch;
    UIVista objVista;

    List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public CtrlU(UIVista objVista) {
        this.objVista = objVista;
    }

    public void registrar() {
        try {

            int id = Integer.parseInt(objVista.txtID.getText());
            String nombre = objVista.txtNombre.getText();
            String telefono = objVista.txtTelefono.getText();

            if (objVista.txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(objVista, "Ingresa un id");
            }
            if (nombre.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(objVista, "Rellena todos los campos");
                return;
            }

            Usuario nuevoUsuario = new Usuario(id, nombre, telefono);
            listaUsuarios.add(nuevoUsuario);

            ArchivoXML.crearXML("usuarios", listaUsuarios);
            JOptionPane.showMessageDialog(objVista, "Registro guardado");
            limpiarCampos();
        } catch (NumberFormatException e) {

        } catch (Exception e) {

        }
    }

    public String listar() {
        try {
            String datos = "";
            objVista.txtAreaRegistros.setText("");

            File archivo = new File("usuarios.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivo);

            NodeList listaUsuarios = document.getElementsByTagName("USUARIO"); // Obtiene todos los elementos "USUARIO"

            for (int i = 0; i < listaUsuarios.getLength(); i++) {

                Node nodo = listaUsuarios.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodo;

                    String id = element.getElementsByTagName("ID").item(0).getTextContent();
                    String nombre = element.getElementsByTagName("NOMBRE").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("TELEFONO").item(0).getTextContent();

                    datos = datos + id + " | " + nombre + " | " + telefono + "\n";
                }

            }

            if (listaUsuarios.getLength() == 0) {
                objVista.txtAreaRegistros.setText("No hay usuarios registrados");
            }
            return datos;
        } catch (Exception e) {
            e.printStackTrace();
        return "Error al listar ";
        }
       
         
    }

    public void limpiarCampos() {
        objVista.txtID.setText("");
        objVista.txtNombre.setText("");
        objVista.txtTelefono.setText("");
        objVista.txtID.requestFocus();
    }
}
