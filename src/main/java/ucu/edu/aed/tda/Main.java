package ucu.edu.aed.tda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ucu.edu.aed.tda.Implementaciones.ArbolBinario;

public class Main {
    public static void main(String[] args) {

        try {
            BufferedReader entrada = new BufferedReader(
                new FileReader("../../../../../resources/claves1.txt")
            );

            BufferedWriter salida = new BufferedWriter(
                new FileWriter("../../../../../resources/claves1Salida.txt")
            );

            ArbolBinario<Integer> arbol = new ArbolBinario<>();

            String linea;

            while ((linea = entrada.readLine()) != null) {

                int clave = Integer.parseInt(linea);

                arbol.insertar(clave);

                salida.write(clave + " " + arbol.getContador());
                salida.newLine();
            }

            entrada.close();
            salida.close();

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
