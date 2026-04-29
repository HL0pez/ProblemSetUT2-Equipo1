package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;

import ucu.edu.aed.tda.Interfaces.TDAElemento;

public class ArbolBinario<T> implements ucu.edu.aed.tda.Interfaces.TDAArbolBinario {

    private TDAElemento<T> raiz;

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
    public TDAElemento<T> obtenerRaiz() {
        return this.raiz;
    }

    @Override
    public boolean eliminar(Comparable criterioBusqueda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public boolean insertar(Comparable dato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public boolean insertar(Object dato) {
        if (dato instanceof Comparable) {
            return insertar((Comparable) dato);
        }
        throw new IllegalArgumentException("El dato debe ser Comparable");
    }

    @Override
    public void inOrder(Consumer consumidor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inOrder'");
    }

    @Override
    public String inOrdenString() {
        // Minimal implementation to satisfy interface; detailed traversal may be added later
        return "";
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
    public boolean esVacio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacio'");
    }

    @Override
    public int cantidadNodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cantidadNodos'");
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

}
