package com.mycompany.script;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Criptografía y Seguridad 2024-2
 * Prof. José de Jesús Galaviz Casas
 * Ayud. Alejandro Tadeo Meza Ferat
 * Ayud. Lab. María Ximena Lezama Hérnandez
 * 
 * Clase Comandos
 * 
 * @author Juan Manuel Lucio Rangel
 * @author Oscar Emilio Caballero Jim ́enez
 * @version 1.0
 *
 */
public class Comandos {
    private String direcc;
    private ArrayList<String> pinginfo = new ArrayList<>();
    private ArrayList<String> nslookupinfo = new ArrayList<>();
    private ArrayList<String> tracerouteinfo = new ArrayList<>();
    private ArrayList<String> whoisinfo = new ArrayList<>();
    private ArrayList<String> dnsmapinfo = new ArrayList<>();
    private ArrayList<String> dnsreconinfo = new ArrayList<>();
    
    public void EjecutarCMD(String direcc) {
        this.setDirecc(direcc);
        this.crearArchivo();
        this.ping();
        this.nslookup();
        this.traceroute();
        this.whois();
        this.dnsmap();
        this.dnsrecon();
        
    }
    
    /**
     * Metodo crearArchivo.- Crea el archivo en donde añadiremos toda la informacion relevante
     * pre procesada que obtendremos para su posterior analisis.
     */
    private void crearArchivo(){
        try{ 
            String inf = "Nombre del dominio o IP analizado: "+ this.getDirecc();
            
            //Escribir para crear el archivo
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "echo Informacion obtenida > Informacion.txt");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor(); 
            
            //Salto de linea
            builder = new ProcessBuilder("cmd.exe", "/c", "echo . >> Informacion.txt");
            builder.redirectErrorStream(true);
            process = builder.start();
            process.waitFor();
            
            //Anadir informacion inicial (Nombre/IP)
            builder = new ProcessBuilder("cmd.exe", "/c", "echo "+ inf +" >> Informacion.txt");
            builder.redirectErrorStream(true);
            process = builder.start();
            process.waitFor(); 
            
            //Salto de linea
            builder = new ProcessBuilder("cmd.exe", "/c", "echo . >> Informacion.txt");
            builder.redirectErrorStream(true);
            process = builder.start();
            process.waitFor();
            
        } catch(IOException e){
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo ping.- Ejecutar el comando ping, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void ping(){
        try {
            String comando = "ping "+ this.getDirecc() + " > ping.txt";
            
            System.out.println(comando);
            ProcessBuilder escribir;
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", comando);
            builder.redirectErrorStream(true);
            Process process = builder.start();
            
            System.out.println("Comando ejecutado de forma exitosa.");
            process.waitFor(); // Esperar a que el proceso termine
            
            BufferedReader br = new BufferedReader(new FileReader("ping.txt"));
            String line;

            while ((line = br.readLine()) != null) {
               pinginfo.add(line);
            }

            if(pinginfo.size() > 2){
                for(byte i = 7; i < pinginfo.size(); i++){
                   comando = "echo "+pinginfo.get(i)+" >> Informacion.txt";
                   escribir = new ProcessBuilder("cmd.exe", "/c", comando);
                   builder.redirectErrorStream(true);
                   process = escribir.start();
                   System.out.println("Linea escrita exitosamente.");
                   process.waitFor(); // Esperar a que el proceso termine
                }
            }else{
                for(byte i = 0; i < pinginfo.size(); i++){
                   comando = "echo "+pinginfo.get(i)+" >> Informacion.txt";
                   escribir = new ProcessBuilder("cmd.exe", "/c", comando);
                   builder.redirectErrorStream(true);
                   process = escribir.start();
                   System.out.println("Linea escrita exitosamente.");
                   process.waitFor(); // Esperar a que el proceso termine
                }
            }                          
        } catch (IOException e) {
            System.out.println("Algo salió mal, intentalo mas tarde.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo nslookup.- Ejecutar el comando nslookup, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void nslookup(){
        //En proceso de implementacion
    }

    /**
     * Metodo traceroute.- Ejecutar el comando traceroute, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void traceroute(){
        //En proceso de implementacion
    }

    /**
     * Metodo whois.- Ejecutar el comando whois, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void whois(){
        //En proceso de implementacion
    }

    /**
     * Metodo dnsmap.- Ejecutar el comando dnsmap, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void dnsmap(){
        //En proceso de implementacion
    }

    /**
     * Metodo dnsrecon.- Ejecutar el comando dnsrecon, obtiene la informacion correspondiente
     * y la escribe en el arhcivo para su posterior analisis.
     */
    private void dnsrecon(){
        //En proceso de implementacion
    }
    
    /**
    * Metodo setDirecc.- Establece la direccion a analizar
    * @param direcc .- Direccion a analizar
    */
    private void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    /**
    * Metodo getDirecc.- Regresa la direccion a analizar
    */
    private String getDirecc() {
        return this.direcc;
    }

}
