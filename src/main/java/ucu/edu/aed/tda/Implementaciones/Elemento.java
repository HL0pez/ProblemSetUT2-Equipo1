package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;

import ucu.edu.aed.tda.Interfaces.TDAElemento;

public class Elemento<T> implements ucu.edu.aed.tda.Interfaces.TDAElemento<T> {

    private T dato;
    private TDAElemento<T> hijoIzq;
    private TDAElemento<T> hijoDer;

    @Override
    public void setHijoIzquierdo(TDAElemento hijoIzquierdo) {

        this.hijoIzq = hijoIzquierdo;
    }

    @Override
    public void setHijoDerecho(TDAElemento hijoDerecho) {
        this.hijoDer = hijoDerecho;
    }

    @Override
    public TDAElemento getHijoIzquierdo() {
        return this.hijoIzq;
    }

    @Override
    public TDAElemento getHijoDerecho() {
        return this.hijoDer;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public TDAElemento buscar(Comparable criterioBusqueda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public TDAElemento eliminar(Comparable criterioBusqueda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public boolean insertar(Comparable nuevoDato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public void inOrder(Consumer consumidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrder'");
    }

    @Override
    public void preOrder(Consumer consumidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'preOrder'");
    }

    @Override
    public void postOrder(Consumer consumidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postOrder'");
    }

    @Override
    public boolean esHoja() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esHoja'");
    }

    @Override
    public int cantidadHojas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadHojas'");
    }

    @Override
    public int cantidadNodosInternos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadNodosInternos'");
    }

    @Override
    public int cantidadNodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadNodos'");
    }

    @Override
    public int altura() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'altura'");
    }

    @Override
    public int obtenerNivel(Comparable criterioBusqueda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNivel'");
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

}
