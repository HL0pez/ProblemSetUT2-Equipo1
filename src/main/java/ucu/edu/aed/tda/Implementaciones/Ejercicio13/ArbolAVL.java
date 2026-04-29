package ucu.edu.aed.tda.Implementaciones.Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public void insertar(Nave nave) {
        raiz = insertarRec(raiz, nave);
    }

    private NodoAVL insertarRec(NodoAVL nodo, Nave nave) {
        if (nodo == null) {
            return new NodoAVL(nave);
        }

        if (nave.getCodigo() < nodo.getNave().getCodigo()) {
            nodo.setIzquierda(insertarRec(nodo.getIzquierda(), nave));
        } else if (nave.getCodigo() > nodo.getNave().getCodigo()) {
            nodo.setDerecha(insertarRec(nodo.getDerecha(), nave));
        } else {
            return nodo;
        }

        nodo.setAltura(1 + Math.max(obtenerAltura(nodo.getIzquierda()), obtenerAltura(nodo.getDerecha())));

        int balance = obtenerBalance(nodo);
        if (balance > 1 && nave.getCodigo() < nodo.getIzquierda().getNave().getCodigo()) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && nave.getCodigo() > nodo.getDerecha().getNave().getCodigo()) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && nave.getCodigo() > nodo.getIzquierda().getNave().getCodigo()) {
            nodo.setIzquierda(rotarIzquierda(nodo.getIzquierda()));
            return rotarDerecha(nodo);
        }

        if (balance < -1 && nave.getCodigo() < nodo.getDerecha().getNave().getCodigo()) {
            nodo.setDerecha(rotarDerecha(nodo.getDerecha()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private int obtenerAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.getIzquierda()) - obtenerAltura(nodo.getDerecha());
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierda();
        NodoAVL t2 = x.getDerecha();

        x.setDerecha(y);
        y.setIzquierda(t2);

        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierda()), obtenerAltura(y.getDerecha())));
        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierda()), obtenerAltura(x.getDerecha())));

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecha();
        NodoAVL t2 = y.getIzquierda();

        y.setIzquierda(x);
        x.setDerecha(t2);

        x.setAltura(1 + Math.max(obtenerAltura(x.getIzquierda()), obtenerAltura(x.getDerecha())));
        y.setAltura(1 + Math.max(obtenerAltura(y.getIzquierda()), obtenerAltura(y.getDerecha())));

        return y;
    }

    public List<Integer> obtenerExploradoras() {
        List<Integer> lista = new ArrayList<>();
        obtenerExploradorasRec(raiz, lista);
        return lista;
    }

    private void obtenerExploradorasRec(NodoAVL nodo, List<Integer> lista) {
        if (nodo == null) return;
        obtenerExploradorasRec(nodo.getIzquierda(), lista);
        if (nodo.getNave().getClase().equals("Explorador")) {
            lista.add(nodo.getNave().getCodigo());
        }
        obtenerExploradorasRec(nodo.getDerecha(), lista);
    }

    public double calcularPromedioExploradora() {
        int[] datos = {0, 0}; // datos[0] = total combustible, datos[1] = cantidad
        calcularPromedioRec(raiz, datos);
        if (datos[1] == 0) return 0;
        return (double) datos[0] / datos[1];
    }

    private void calcularPromedioRec(NodoAVL nodo, int[] datos) {
        if (nodo == null) return;
        calcularPromedioRec(nodo.getIzquierda(), datos);
        if (nodo.getNave().getClase().equals("Explorador")) {
            datos[0] += nodo.getNave().getCombustible();
            datos[1]++;
        }
        calcularPromedioRec(nodo.getDerecha(), datos);
    }
}
