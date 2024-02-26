package com.mycompany.script;

import java.util.Scanner;

/**
 *
 * @author JuanTHE
 */
public class Script {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        args="unam.mx".split(" ");
        
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
