
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tareaprogramacion;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jesus Romero
 */
public class TareaProgramacion {
    public static boolean sePuedeEscribirNota(String nota, String revista) {
        // Map para contar la frecuencia de caracteres en la nota
        Map<Character, Integer> frecuenciaNota = new HashMap<>();
        
        // Contamos la frecuencia de cada carácter en la nota
        for (char c : nota.toCharArray()) {
            frecuenciaNota.put(c, frecuenciaNota.getOrDefault(c, 0) + 1);
        }
        
        // Map para contar la frecuencia de caracteres en la revista
        Map<Character, Integer> frecuenciaRevista = new HashMap<>();
        
        // Contamos la frecuencia de cada carácter en la revista
        for (char c : revista.toCharArray()) {
            frecuenciaRevista.put(c, frecuenciaRevista.getOrDefault(c, 0) + 1);
        }
        
        // Verificamos si podemos formar la nota con la revista
        for (Map.Entry<Character, Integer> entry : frecuenciaNota.entrySet()) {
            char c = entry.getKey();
            int cantidadNecesaria = entry.getValue();
            
            if (frecuenciaRevista.getOrDefault(c, 0) < cantidadNecesaria) {
                return false; // No se puede formar la nota
            }
        }
        
        return true; // Se puede formar la nota
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la Nota: ");
        String nota = scanner.nextLine();
        
        System.out.print("Introduce la Revista: ");
        String revista = scanner.nextLine();

        if (sePuedeEscribirNota(nota, revista)) {
            System.out.println("Sí, es posible escribir la nota con la revista.");
        } else {
            System.out.println("No, no es posible escribir la nota con la revista.");
        }
    }
}


/*
import java.util.HashMap;
import java.util.Map;

public class RevistaYNota {

    public static boolean sePuedeEscribirNota(String nota, String revista) {
        // Map para contar la frecuencia de caracteres en la nota
        Map<Character, Integer> frecuenciaNota = new HashMap<>();
        
        // Contamos la frecuencia de cada carácter en la nota
        for (char c : nota.toCharArray()) {
            frecuenciaNota.put(c, frecuenciaNota.getOrDefault(c, 0) + 1);
        }
        
        // Map para contar la frecuencia de caracteres en la revista
        Map<Character, Integer> frecuenciaRevista = new HashMap<>();
        
        // Contamos la frecuencia de cada carácter en la revista
        for (char c : revista.toCharArray()) {
            frecuenciaRevista.put(c, frecuenciaRevista.getOrDefault(c, 0) + 1);
        }
        
        // Verificamos si podemos formar la nota con la revista
        for (Map.Entry<Character, Integer> entry : frecuenciaNota.entrySet()) {
            char c = entry.getKey();
            int cantidadNecesaria = entry.getValue();
            
            if (frecuenciaRevista.getOrDefault(c, 0) < cantidadNecesaria) {
                return false; // No se puede formar la nota
            }
        }
        
        return true; // Se puede formar la nota
    }

    public static void main(String[] args) {
        String nota = "hola";
        String revista = "hlaoaooolw";

        if (sePuedeEscribirNota(nota, revista)) {
            System.out.println("Sí, es posible escribir la nota con la revista.");
        } else {
            System.out.println("No, no es posible escribir la nota con la revista.");
        }
    }
}

*/