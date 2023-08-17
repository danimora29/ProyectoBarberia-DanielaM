/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobarberiag1;

/**
 *
 * @author Mercedes León
 */
public class Cliente {
    private String nombre;
    private String telefono;
   
    private int rangoHoras;

    public Cliente() {
    }

    
    public Cliente(String nombre, String telefono, int rangoHoras) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.rangoHoras = rangoHoras;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRangoHoras() {
        return rangoHoras;
    }

    public void setRangoHoras(int rangoHoras) {
        this.rangoHoras = rangoHoras;
    }
    
    
}

