package ucu.edu.aed.tda.Implementaciones.Ejercicio7pt1;

public class ArbolExpresion {
    private NodoExpresion raiz;
    public ArbolExpresion(NodoExpresion raiz) {
        this.raiz = raiz;
    }

    public void sustituirVariables(String variable, String valor) {
        sustituirVariables(raiz, variable, valor);
    }

    private void sustituirVariables(NodoExpresion nodo, String variable, String valor) {
        if (nodo == null) return;
        if (nodo.getValor().equals(variable)) {
            nodo.setValor(valor);
        }
        sustituirVariables(nodo.getHijoIzquierdo(), variable, valor);
        sustituirVariables(nodo.getHijoDerecho(), variable, valor);
    }

    public double evaluar() {
        return evaluar(raiz);
    }

    private double evaluar(NodoExpresion nodo) {
        if (nodo.esHoja()) {
            return Double.parseDouble(nodo.getValor());
        }
        double izq = evaluar(nodo.getHijoIzquierdo());
        double der = evaluar(nodo.getHijoDerecho());
       
        if (nodo.getValor().equals("+")) return izq + der;
        if (nodo.getValor().equals("-")) return izq - der;
        if (nodo.getValor().equals("*")) return izq * der;
        if (nodo.getValor().equals("/")) return izq / der;
        return 0;
    }
}