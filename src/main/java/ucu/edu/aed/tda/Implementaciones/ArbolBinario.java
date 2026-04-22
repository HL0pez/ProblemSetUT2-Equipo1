
package ucu.edu.aed.tda.Implementaciones;

import java.util.function.Consumer;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerRaiz'");
    }

    @Override
    public boolean eliminar(Comparable criterioBusqueda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
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
