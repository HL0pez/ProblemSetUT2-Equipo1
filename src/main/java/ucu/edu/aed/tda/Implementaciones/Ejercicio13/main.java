package ucu.edu.aed.tda.Implementaciones.Ejercicio13;

import java.util.List;

public class main {
    public static void main(String[] args) {
        ArbolAVL registro = new ArbolAVL();

        Nave[] naves = {
            new Nave(10, "Explorador", 0),
            new Nave(20, "Destructor", 90),
            new Nave(30, "Médica", 100),
            new Nave(40, "Explorador", 50),
            new Nave(50, "Carguero", 20),
            new Nave(60, "Destructor", 28),
            new Nave(70, "Explorador", 14),
            new Nave(80, "Médica", 7),
            new Nave(90, "Carguero", 23),
            new Nave(100, "Explorador", 26)
        };

        for (Nave nave : naves) {
            registro.insertar(nave);
        }

        List<Integer> exploradoras = registro.obtenerExploradoras();
        System.out.println("Exploradoras: " + exploradoras);

        double promedio = registro.calcularPromedioExploradora();
        System.out.println("Combustible promedio: " + promedio);
    }
}
