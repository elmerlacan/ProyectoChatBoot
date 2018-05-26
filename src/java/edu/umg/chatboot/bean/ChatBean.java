/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.umg.chatboot.bean;

import edu.umg.chatboot.chat.Main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author elmer
 */
@SessionScoped
@ManagedBean
public class ChatBean implements Serializable{
    
    private String mensaje;
    private String nombre;
    private boolean enable;
    private List<String[]> mensajes;
    private Main main;
    
    public ChatBean(){
        mensajes = new ArrayList<>();
        mensaje = "";
        nombre = "";
        enable = true;
        main = new Main();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String[]> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String[]> mensajes) {
        this.mensajes = mensajes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    public void agregarNombre(){
        String[] msg = new String[3];
        msg[0] = "soport.png";
        msg[1] = "- JUAN -";
        msg[2] = "HOLA "+nombre.toUpperCase();
        
        enable = false;
        
        mensajes.add(msg);
        mensaje="";
    }
    
    public void agregarMensaje(){
        
        String[] msg = new String[3];
        
        msg[0] = "client.png";
        msg[1] = "- "+nombre.toUpperCase()+" -";
        msg[2] = mensaje;
        mensajes.add(msg);
        agregarRespuesta(mensaje);
        
        
        mensaje="";
    }
    
    public void agregarRespuesta(String msg){
        String[] msga = new String[3];
        msga[0] = "soport.png";
        msga[1] = "- JUAN -";
        msga[2] = main.executeSentence(msg);
        mensajes.add(msga);
    }
    
}
