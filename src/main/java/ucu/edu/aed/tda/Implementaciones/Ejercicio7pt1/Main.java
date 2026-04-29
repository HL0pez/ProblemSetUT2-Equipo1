package ucu.edu.aed.tda.Implementaciones.Ejercicio7pt1;


public class Main {
    public static void main(String[] args) {
        NodoExpresion raiz = new NodoExpresion("*");

        NodoExpresion suma = new NodoExpresion("+");
        suma.setHijoIzquierdo(new NodoExpresion("a"));
        suma.setHijoDerecho(new NodoExpresion("b"));

        raiz.setHijoIzquierdo(suma);
        raiz.setHijoDerecho(new NodoExpresion("c"));

        ArbolExpresion arbol = new ArbolExpresion(raiz);

        arbol.sustituirVariables("a", "3.0");
        arbol.sustituirVariables("b", "7.0");
        arbol.sustituirVariables("c", "2.0");

        System.out.println("Resultado: " + arbol.evaluar());
    }
}
