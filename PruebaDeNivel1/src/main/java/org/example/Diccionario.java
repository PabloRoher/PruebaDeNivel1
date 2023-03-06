package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Diccionario {

    private HashMap<Character, LinkedList<String>> tablaHash;

    public Diccionario() {
        tablaHash = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            tablaHash.put(c, new LinkedList<String>());
        }
    }

    public void leer() throws IOException {
        String rutaArchivo = "//PruebaDeNivel1/src/main/resources/palabras.csv";
        File archivo = new File(rutaArchivo);
        try {
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] valores = linea.split(",");
                for (String valor : valores) {
                    System.out.print(valor + "\t");
                }
                System.out.println();
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
            e.printStackTrace();
        }
    }

    private int sondeo(int posicion, int tamaño_tabla) {
        
        return (posicion + 1) % tamaño_tabla;
    }


    public void agregarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        palabrasConLetra.add(palabra);
    }

    public boolean buscarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        return palabrasConLetra.contains(palabra);
    }







    public static void main(String[] args) throws IOException {
        Diccionario diccionario = new Diccionario();

        diccionario.leer();

    }
}