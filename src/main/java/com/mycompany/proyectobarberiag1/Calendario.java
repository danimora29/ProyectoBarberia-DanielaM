/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobarberiag1;

/**
 *
 * @author Mercedes León
 */
public class Calendario {
    private String mes;
    private String semana;
    private int dias;
    private int horas;

    public Calendario() {
    }

    public Calendario(String mes, String semana, int dias, int horas) {
        this.mes = mes;
        this.semana = semana;
        this.dias = dias;
        this.horas = horas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Calendario" + "mes=" + mes + ", semana=" + semana + ", dias=" + dias + ", horas=" + horas;
    }
    
    
}
