/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaprogramacion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
/**
 *
 * @author Jesus Romero
 */

class Estudiante {
    String nombre;
    String sede;

    public Estudiante(String nombre, String sede) {
        this.nombre = nombre;
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSede() {
        return sede;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudiante that = (Estudiante) o;

        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

public class TareaProgramacion2 {
     
    
     public static void notificar(Set<Estudiante> listaA, Set<Estudiante> listaB, Set<Estudiante> listaC) {
        // Filtrar solo los estudiantes de la sede de Málaga
        Set<Estudiante> malagaA = filtrarPorSede(listaA, "Malaga");
        Set<Estudiante> malagaB = filtrarPorSede(listaB, "Malaga");
        Set<Estudiante> malagaC = filtrarPorSede(listaC, "Malaga");

        // Usamos un Set para asegurarnos de que cada estudiante reciba solo un email
        Set<Estudiante> estudiantesNotificados = new HashSet<>();

        // Notificamos a los estudiantes en la lista C primero (Matemáticas y Francés)
        for (Estudiante estudiante : malagaC) {
            if (!estudiantesNotificados.contains(estudiante)) {
                enviarEmail(estudiante, "incidenciaMatematicasYFrances");
                estudiantesNotificados.add(estudiante);
            }
        }

        // Notificamos a los estudiantes en la lista A (Matemáticas)
        for (Estudiante estudiante : malagaA) {
            if (!estudiantesNotificados.contains(estudiante)) {
                enviarEmail(estudiante, "incidenciaMatematicas");
                estudiantesNotificados.add(estudiante);
            }
        }

        // Notificamos a los estudiantes en la lista B (Francés)
        for (Estudiante estudiante : malagaB) {
            if (!estudiantesNotificados.contains(estudiante)) {
                enviarEmail(estudiante, "incidenciaFrances");
                estudiantesNotificados.add(estudiante);
            }
        }
    }

    private static Set<Estudiante> filtrarPorSede(Set<Estudiante> lista, String sede) {
        Set<Estudiante> resultado = new HashSet<>();
        for (Estudiante estudiante : lista) {
            if (estudiante.getSede().equalsIgnoreCase(sede)) {
                resultado.add(estudiante);
            }
        }
        return resultado;
    }

    private static void enviarEmail(Estudiante estudiante, String tipoIncidencia) {
        // Aquí iría el código para enviar el email
        System.out.println("Enviando email a " + estudiante.getNombre() + " por " + tipoIncidencia);
    }

     public static void main(String[] args) {
          // Crear algunos estudiantes de ejemplo
        Scanner scanner = new Scanner(System.in);
        int opcion = 1;
        int opcion2 = 1;
        int opcion3 = 1;
       
        
        Set<Estudiante> listaA = new HashSet<>();
       // listaA.add(new Estudiante("Juan", "Málaga"));
       // listaA.add(new Estudiante("Ana", "Madrid"));

        Set<Estudiante> listaB = new HashSet<>();
       // listaB.add(new Estudiante("Pedro", "Málaga"));
      //  listaB.add(new Estudiante("Ana", "Madrid"));

        Set<Estudiante> listaC = new HashSet<>();
       // listaC.add(new Estudiante("Juan", "Málaga"));
       // listaC.add(new Estudiante("Pedro", "Málaga"));
       
        while (opcion ==  1){
            System.out.println("Lista A");
            System.out.println("Introduce Estudiante : ");
            String Estudiante = scanner.nextLine();
            System.out.println("Introduce Sede : ");
            String Sede = scanner.nextLine();
            listaA.add(new Estudiante(Estudiante, Sede));
            System.out.println("Quiere introdcir otro alumno 1 es si, 0 es no");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        
        while (opcion2 ==  1){
            System.out.println("Lista B");
            System.out.println("Introduce Estudiante : ");
            String Estudiante2 = scanner.nextLine();
            System.out.println("Introduce Sede : ");
            String Sede2 = scanner.nextLine();
            listaB.add(new Estudiante(Estudiante2, Sede2));
            System.out.println("Quiere introdcir otro alumno 1 es si, 0 es no");
            opcion2 = scanner.nextInt();
            scanner.nextLine();
        }
        
        while (opcion3 ==  1){
            System.out.println("Lista C");
            System.out.println("Introduce Estudiante : ");
            String Estudiante3 = scanner.nextLine();
            System.out.println("Introduce Sede : ");
            String Sede3 = scanner.nextLine();
            listaB.add(new Estudiante(Estudiante3, Sede3));
            System.out.println("Quiere introdcir otro alumno 1 es si, 0 es no");
            opcion3 = scanner.nextInt();
            scanner.nextLine();
        }

        // Ejecutar la notificación
        notificar(listaA, listaB, listaC);
     }
}
