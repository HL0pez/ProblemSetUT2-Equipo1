package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;

import ucu.edu.aed.tda.Interfaces.TDAElemento;

public class Elemento<T> implements ucu.edu.aed.tda.Interfaces.TDAElemento<T> {

    private T dato;
    private TDAElemento<T> hijoIzq;
    private TDAElemento<T> hijoDer;

    public Elemento(T dato) {
        this.dato = dato;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
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
        Elemento<T> nuevoElemento = new Elemento<>(nuevoDato);

        if (nuevoDato.compareTo(this.dato) < 0) {
            if (hijoIzq == null) {
                hijoIzq = nuevoElemento;
                return true;
            } else {
                return ((Elemento<T>) hijoIzq).insertar(nuevoDato);
            }
        } else if (nuevoDato.compareTo(this.dato) > 0) {
            if (hijoDer == null) {
                hijoDer = nuevoElemento;
                return true;
            } else {
                return ((Elemento<T>) hijoDer).insertar(nuevoDato);
            }
        } else {
            return false;
        }
    }

    @Override
    public void inOrder(Consumer consumidor) {
        if (hijoIzq != null) hijoIzq.inOrder(consumidor);
        consumidor.accept(this);
        if (hijoDer != null) hijoDer.inOrder(consumidor);
    }
    @Override
    public void preOrder(Consumer consumidor) {
        consumidor.accept(this);
        if (hijoIzq != null) hijoIzq.preOrder(consumidor);
        if (hijoDer != null) hijoDer.preOrder(consumidor);
    }

    @Override
    public void postOrder(Consumer consumidor) {
        if (hijoIzq != null) hijoIzq.postOrder(consumidor);
        if (hijoDer != null) hijoDer.postOrder(consumidor);
        consumidor.accept(this);
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
