package ucu.edu.aed.tda.Implementaciones;
import java.util.List;

public class NodoGrimorio {
    Hechizo dato;
    NodoGrimorio izq;
    NodoGrimorio der;

    public NodoGrimorio(Hechizo dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public void insertar(Hechizo hechizo) {
        if (hechizo.getId() < dato.getId()) {
            if (izq == null) {
                izq = new NodoGrimorio(hechizo);
            } else {
                izq.insertar(hechizo);
            }
        } else if (hechizo.getId() > dato.getId()) {
            if (der == null) {
                der = new NodoGrimorio(hechizo);
            } else {
                der.insertar(hechizo);
            }
        }
    }

    public void hechizosProhibidos(List<Hechizo> lista) {
        if (izq != null) {
            izq.hechizosProhibidos(lista);
        }
        if (this.dato.getId() % 2 != 0) {
            lista.add(this.dato);
        }
        if (der != null) {
            der.hechizosProhibidos(lista);
        }
    }
}
