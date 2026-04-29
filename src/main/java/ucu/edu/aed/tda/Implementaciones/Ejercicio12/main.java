package ucu.edu.aed.tda.Implementaciones.Ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class main {
    
    //construir el grimorio insertando lo siguiente: (42, "Fireball"), (17, "Ice Lance"), (58, "Thunder"),
 //(9, "Invisibility"), (31, "Levitate"), (73, "Summon"),
 //(25, "Heal"), (50, "Teleport"), (65, "Shield"), (88, "Curse")

    public static void main(String[] args) {
        NodoGrimorio grimorio = new NodoGrimorio(new Hechizo(42, "Fireball"));
        grimorio.insertar(new Hechizo(17, "Ice Lance"));
        grimorio.insertar(new Hechizo(58, "Thunder"));
        grimorio.insertar(new Hechizo(9, "Invisibility"));
        grimorio.insertar(new Hechizo(31, "Levitate"));
        grimorio.insertar(new Hechizo(73, "Summon"));
        grimorio.insertar(new Hechizo(25, "Heal"));
        grimorio.insertar(new Hechizo(50, "Teleport"));
        grimorio.insertar(new Hechizo(65, "Shield"));
        grimorio.insertar(new Hechizo(88, "Curse"));

        List<Hechizo> prohibidos = new ArrayList<>();
        grimorio.hechizosProhibidos(prohibidos);

        System.out.println("Hechizos prohibidos:");
        for (Hechizo h : prohibidos) {
            System.out.println(h.getId() + " - " + h.getNombre());
        }

        System.out.println("Cántico: " + grimorio.generarCantico());

    }
}
