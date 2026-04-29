package ucu.edu.aed.tda.Implementaciones;

public class NodoExpresion {

    private String valor;
    private NodoExpresion hijoIzq;
    private NodoExpresion hijoDer;

    public NodoExpresion(String valor) {
        this.valor = valor;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoExpresion getHijoIzquierdo() {
        return hijoIzq;
    }

    public void setHijoIzquierdo(NodoExpresion hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoExpresion getHijoDerecho() {
        return hijoDer;
    }

    public void setHijoDerecho(NodoExpresion hijoDer) {
        this.hijoDer = hijoDer;
    }

    public boolean esHoja() {
        if (hijoIzq == null) {
            if (hijoDer == null) {
                return true;
            }
        }
        return false;
    }

    public boolean esOperador() {
        if (valor.equals("+")) return true;
        if (valor.equals("-")) return true;
        if (valor.equals("*")) return true;
        if (valor.equals("/")) return true;
        return false;
    }
}