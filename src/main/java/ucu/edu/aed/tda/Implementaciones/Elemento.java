package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;

import ucu.edu.aed.tda.Interfaces.TDAElemento;

public class Elemento<T> implements ucu.edu.aed.tda.Interfaces.TDAElemento {

    T dato;
    Elemento<T> hijoIzquierdo;
    Elemento<T> hijoDerecho;

    public Elemento(T dato) {
        this.dato = dato;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    
    public void setHijoIzquierdo(TDAElemento hijoIzquierdo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHijoIzquierdo'");
    }

    @Override
    public void setHijoDerecho(TDAElemento hijoDerecho) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHijoDerecho'");
    }

    @Override
    public TDAElemento getHijoIzquierdo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHijoIzquierdo'");
    }

    @Override
    public TDAElemento getHijoDerecho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHijoDerecho'");
    }

    @Override
    public void setDato(Object dato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDato'");
    }

    @Override
    public Object getDato() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDato'");
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
            if (hijoIzquierdo == null) {
                hijoIzquierdo = nuevoElemento;
                return true;
            } else {
                return ((Elemento<T>) hijoIzquierdo).insertar(nuevoDato);
            }
        } else if (nuevoDato.compareTo(this.dato) > 0) {
            if (hijoDerecho == null) {
                hijoDerecho = nuevoElemento;
                return true;
            } else {
                return ((Elemento<T>) hijoDerecho).insertar(nuevoDato);
            }
        } else {
            return false;
        }
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
    
}
