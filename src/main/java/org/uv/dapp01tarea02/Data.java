/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01tarea02;

/**
 *
 * @author ian
 */
public class Data {
    private String clave;
    private String nombre;
    private String descirpcion;

    public Data(String clave, String nombre, String descirpcion) {
        this.clave = clave;
        this.nombre = nombre;
        this.descirpcion = descirpcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescirpcion() {
        return descirpcion;
    }

    public void setDescirpcion(String descirpcion) {
        this.descirpcion = descirpcion;
    }
    
    
}
