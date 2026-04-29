
package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;
import ucu.edu.aed.tda.Interfaces.TDAElemento;

public class ArbolBinario<T> implements ucu.edu.aed.tda.Interfaces.TDAArbolBinario<T> {

    private static int contador = 0;
    private Elemento<T> raiz;

    @Override
    public T buscar(Comparable predicate) {
        if (raiz != null) {
            TDAElemento<T> resultado = raiz.buscar(predicate);
            if (resultado == null)
                return null;
            return resultado.getDato();
        }
        return null;

    }

    @Override
    public Elemento<T> obtenerRaiz() {
        return raiz;
    }

    @Override
    public boolean eliminar(Comparable criterioBusqueda) {
        if (raiz == null) return false;
        if (criterioBusqueda.compareTo(raiz.getDato()) == 0) {
            raiz = (Elemento<T>) raiz.eliminar(criterioBusqueda);
            return true;
        }
        return raiz.eliminar(criterioBusqueda) != null;
    }

    @Override
    public boolean insertar(Comparable dato) {


        if (raiz == null) {
            ++contador;
            Elemento<T> nuevoElemento = new Elemento<>(dato);
            raiz = nuevoElemento;
        }
        else 
        {
            if(raiz.insertar(dato)) {
                ++contador;
            }else {
                return false;
            }
        }

        System.out.println("Contador insertar desde árbol: " + contador);
        return true;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public String inOrdenString() {
        if (raiz != null) {
            return raiz.inOrdenString();
        }
        return "El árbol está vacío.";
    }

    @Override
    public void inOrder(Consumer consumidor) {
        if (raiz != null) raiz.inOrder(consumidor);
    }

    @Override
    public void preOrder(Consumer consumidor) {
        if (raiz != null) raiz.preOrder(consumidor);
    }

    @Override
    public void postOrder(Consumer consumidor) {
        if (raiz != null) raiz.postOrder(consumidor);
    }

    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    @Override
    public int cantidadNodos() {
        if (raiz == null) return 0;
        return raiz.cantidadNodos();
    }

    @Override
    public int cantidadHojas() {
        if (raiz == null) return 0;
        return raiz.cantidadHojas();
    }

    @Override
    public int cantidadNodosInternos() {
        if (raiz == null) return 0;
        return raiz.cantidadNodosInternos();
    }

    public List<TDAElemento<T>> completos() {
        if (raiz == null) return new ArrayList<>();
        return raiz.completos();
    }

    public List<TDAElemento<T>> enNivel(int nivel) {
        if (raiz == null) return new ArrayList<>();
        return raiz.enNivel(nivel);
    }

    public int altura() {
        if (raiz == null) return -1;
        return raiz.altura();
    }
}