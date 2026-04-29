package ucu.edu.aed.tda.Implementaciones.Ejercicio13;

public class NodoAVL {
    private Nave nave;
    private NodoAVL izquierda;
    private NodoAVL derecha;
    private int altura;

    public NodoAVL(Nave nave) {
        this.nave = nave;
        this.izquierda = null;
        this.derecha = null;
        this.altura = 1;
    }

    public Nave getNave() {
        return nave;
    }

    public NodoAVL getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAVL getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAVL derecha) {
        this.derecha = derecha;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
