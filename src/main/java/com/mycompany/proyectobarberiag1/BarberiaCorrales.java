/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyectobarberiag1;

import javax.swing.JOptionPane;

/**
 *
 * @author Mercedes León
 */
public class BarberiaCorrales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String hora = "";
        int fila = 0;
        int colum = 0;
        double IVA = 0.13;
        double unaHoras = 2500;
        double unaHoraFin = 3000;
        //TAMAÑO MATRIZ AGEND.SEMANAL
        int filas = 1; // Número de filas
        int columnas = 7; // Número de columnas

        int[][] calendario = new int[filas][columnas];

        //PARA ESPACIOS DISPONIBLES
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                calendario[i][j] = 0;
            }
        }

        //MOSTRAR AGENDA
        mostrarCale(calendario);
        Cliente cli = new Cliente();
        Barbero bar = new Barbero();
        Calendario cale = new Calendario();
        Barbero barb[] = new Barbero[5];

        barb[0] = new Barbero("Luis", 11 );
        barb[1] = new Barbero("Jose", 11);
        barb[2] = new Barbero("Javier", 12);
        barb[3] = new Barbero("Alberto", 12);
        barb[4] = new Barbero("Gabriel", 13);

        System.out.println();
        for (int i = 0; i < barb.length; i++) {

            System.out.println(i + " " + barb[i]);
        }

        

        int op = 1;

        while (op != 0) {

            op = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "***Menu Barbería Corrales***\n"
                            + "1. Consultar barberos\n"
                            + "2. Consultar horarios de almuerzo\n"
                            + "3. Consultar agenda semanal\n"
                            + "4. Reservacion de cita \n"
                            + "5. Devolución de cita \n"
                            + "6. Revisión de agenda barberos \n"
                            + "0. Salir\n"
                            + "Digite su opción: ", "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            switch (op) {

                case 1:
                    //CONSULTAR BARBEROS
                    System.out.println();
                    for (int i = 0; i < barb.length; i++) {
                        System.out.println(i + " " + barb[i]);
                    }

                    break;
                    
                case 2:
                    //CONSULTAR HORARIOS DE ALMUERZO
                    System.out.println();
                    for (int i = 0; i < barb.length; i++) {
                        System.out.println(i + " " + barb[i]);
                    }
                    System.out.println();
                    break;

                case 3:
                    //CONSULTAR AGENDA SEMANAL
                    mostrarCale(calendario);
                    break;
                    
                case 4:
                    cli.setNombre(JOptionPane.showInputDialog("Indique el nombre del cliente: "));
                    cli.setTelefono(JOptionPane.showInputDialog("Indique el telefono del cliente: "));

                    //CANTIDAD DE CITAS POR RESERVAR (DIAS)
                    int cantidadCitas = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de dias que desea reservar:"));

                    //RESERVACION EN AGENDA SEMANAL
                    for (int k = 0; k < cantidadCitas; k++) {
                        fila = Integer.parseInt(JOptionPane.showInputDialog("Indique la fila del Dia " + (k + 1) + ":"));
                        colum = Integer.parseInt(JOptionPane.showInputDialog("Indique la columna del Dia " + (k + 1) + ":"));

                        //DISPONIBILIDAD: disponible (0) / reservado (1)
                        if (fila >= 0 && fila < filas && colum >= 0 && colum < columnas) {
                            if (calendario[fila][colum] == 0) {
                                calendario[fila][colum] = 1;
                                JOptionPane.showMessageDialog(null, "Reservacion del Dia " + (k + 1) + " realizada correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "El dia en la fila " + fila + ", columna " + colum + " ya está ocupado. Por favor, intente de nuevo.");
                                k--; //resta 1 a k para repetir la reserva de la cita.
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error! La fila o columna ingresada está fuera del rango válido. Por favor, intente de nuevo.");
                            k--; //resta 1 a k para repetir la reserva de la cita.
                        }
                    }

                    System.out.println("Horario de atencion:  \n"
                            + "1. 8 am a 9 am\n"
                            + "2. 9 am a 10 am\n"
                            + "3. 10 am 11 am\n"
                            + "4. 11 pm a 12 md\n"
                            + "5. 12 md a 1 pm\n"
                            + "6. 1 pm a 2 pm\n"
                            + "7. 2 pm a 3 pm\n"
                            + "8. 3 pm a 4 pm\n"
                            + "9. 4 pm a 5 pm\n"
                            + "10. 5pm a 6 pm");

                    JOptionPane.showMessageDialog(null, "Horario de atencion:  \n"
                            + "1. 8 am a 9 am\n"
                            + "2. 9 am a 10 am\n"
                            + "3. 10 am 11 am\n"
                            + "4. 11 pm a 12 md\n"
                            + "5. 12 md a 1 pm\n"
                            + "6. 1 pm a 2 pm\n"
                            + "7. 2 pm a 3 pm\n"
                            + "8. 3 pm a 4 pm\n"
                            + "9. 4 pm a 5 pm\n"
                            + "10. 5pm a 6 pm");

                    cli.setRangoHoras(Integer.parseInt(JOptionPane.showInputDialog("Indique el rango de horas de su cita: ")));

                    
                    if (fila == 0 && colum == 0) {
                        if (cli.getRangoHoras() == 1) {
                            hora = "8 am a 9 am";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));

                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n " +"Telefono del cliente: " + cli.getTelefono() + "\n " +"Hora de cita: " + hora + "\n " +"Total a pagar (con IVA): " + total + "\n " + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                        
                        } else if (cli.getRangoHoras() == 2) {
                            hora = "9 am a 10 am";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                        } else if (cli.getRangoHoras() == 3) {
                            hora = "10 am a 11 am";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n.3" + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                        } else if (cli.getRangoHoras() == 4) {
                            hora = "11 am a 12 am";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[2] + " \n2." + barb[3] + " \n3." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                        } else if (cli.getRangoHoras() == 5) {
                            hora = "12 md a 1pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] +  " \n3." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                        } else if (cli.getRangoHoras() == 6) {
                            hora = "1pm a 2pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n0." + barb[0] + " \n1." + barb[1] + " \n2." + barb[2] + " \n3." + barb[3] );
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                            
                        } else if (cli.getRangoHoras() == 7) {
                            hora= "2pm a 3 pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n" + barb[num]);
                            
                            
                        } else if (cli.getRangoHoras() == 8) {
                            hora= "3pm a 4 pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() +"\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                            
                        } else if (cli.getRangoHoras() == 9) {
                            hora= "4pm a 5pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                            
                        } else if (cli.getRangoHoras() == 10) {
                            hora= "5pm a 6pm";
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            
                            JOptionPane.showMessageDialog(null, "Los barberos disponibles son: \n1." + barb[0] + " \n2." + barb[1] + " \n3." + barb[2] + " \n4." + barb[3] + " \n5." + barb[4]);
                            int num = Integer.parseInt(JOptionPane.showInputDialog("Elija un barbero"));
                            
                            JOptionPane.showMessageDialog(null, "Nombre del cliente :" + cli.getNombre() + "\n" + "Telefono del cliente: " + cli.getTelefono() + "\n" + "Hora de cita: " + hora + "\n" + "Total a pagar:" + total + "\n" + "\n" + barb[num]);
                            System.out.print("Nombre del cliente:" + cli.getNombre() + "\nTelefono: " + cli.getTelefono() + "\n Hora: " + hora + "\n total a pagar:" + total + "\n " + barb[num]);
                        }
                        
                        //PARA DEFINIR EL PRECIO DE FIN O ENTRESEMANA (MATRIZ)
                    } else if (fila == 0 && colum == 1) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    } else if (fila == 0 && colum == 2) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    } else if (fila == 0 && colum == 3) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    } else if (fila == 0 && colum == 4) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    } else if (fila == 0 && colum == 5) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoras * IVA;
                            double total = unaHoras + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    } else if (fila == 0 && colum == 6) {
                        if (cli.getRangoHoras() == 1) {

                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 8 am a 9 am \n"
                                    + "Total a pagar =" + total);

                        } else if (cli.getRangoHoras() == 2) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 9 am a 10 am\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 3) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 10 am 11 am \n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 4) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 11 am a 12 md\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 5) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 12 md a 1 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 6) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 1 pm a 2 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 7) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 2 pm a 3 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 8) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 3 pm a 4 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 9) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 4 pm a 5 pm\n"
                                    + "Total a pagar =" + total);
                        } else if (cli.getRangoHoras() == 10) {
                            double impuesto = unaHoraFin * IVA;
                            double total = unaHoraFin + impuesto;
                            JOptionPane.showMessageDialog(null, "La hora de reservacion es 5 pm a 6 pm\n"
                                    + "Total a pagar =" + total);
                        }
                    }
                   

                    break;
                case 5:
                    //DEVOLUCION DE ESPACIOS
                    
                    
                    
                    break;
                
                case 6:
                    //REVISION DE AGENDA
                    
                    
                    
                    break;    
                    
                
                case 0:
                    System.out.println("Salir");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error, opción invalida intente de nuevo", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //MATRIZ DE AGENDA SEMANAL
    public static void mostrarCale(int[][] calendario) {
        StringBuilder caleStr = new StringBuilder();
        for (int i = 0; i < calendario.length; i++) {
            for (int j = 0; j < calendario[i].length; j++) {

                caleStr.append(calendario[i][j]).append("   ");
            }
            caleStr.append("\n");
        }
        JOptionPane.showMessageDialog(null, "Estado del calendario: \nD   L  M  MI  J  V   S \n" + caleStr.toString());
        System.out.println("Estado del calendario: \nD   L   M   MI  J   V   S \n" + caleStr.toString());

    }
}
