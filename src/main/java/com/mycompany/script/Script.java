package com.mycompany.script;

import java.util.Scanner;

/**
 * Criptografía y Seguridad 2024-2
 * Prof. José de Jesús Galaviz Casas
 * Ayud. Alejandro Tadeo Meza Ferat
 * Ayud. Lab. María Ximena Lezama Hérnandez
 * 
 * Clase principal Script
 * 
 * @author Juan Manuel Lucio Rangel
 * @author Oscar Emilio Caballero Jim ́enez
 * @version 1.0
 *
 */
public class Script {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if(args.length == 0){
            System.out.println("Ingresa el dominio o direccion IP a analizar: ");
            String algo = sc.nextLine();
            args = algo.split(" ");
        }
        
        Comandos cmd = new Comandos();
        System.out.println("Prueba Ejecucion.");
        cmd.EjecutarCMD(args[0]);
        
    }
}
