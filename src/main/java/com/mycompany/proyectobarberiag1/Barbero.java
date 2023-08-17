/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobarberiag1;

/**
 *
 * @author Daniela 
 */
public class Barbero {
    private String nombre;
    private int horaAlmuerzo;

    public Barbero() {
    }

    
    public Barbero(String nombre, int horaAlmuerzo) {
        this.nombre = nombre;
        this.horaAlmuerzo = horaAlmuerzo;
    }

   

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the horaAlmuerzo
     */
    public int getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    /**
     * @param horaAlmuerzo the horaAlmuerzo to set
     */
    public void setHoraAlmuerzo(int horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }

    @Override
    public String toString() {
        return "Nombre:  " + nombre + " , " + "Hora de almuerzo:  " + horaAlmuerzo;
    }
    
    
}
