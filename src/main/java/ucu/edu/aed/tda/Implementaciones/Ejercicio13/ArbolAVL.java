package ucu.edu.aed.tda.Implementaciones.Ejercicio13;

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


}
