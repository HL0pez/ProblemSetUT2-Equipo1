package ucu.edu.aed.tda.Implementaciones;

import java.awt.im.InputMethodRequests;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

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
        if (criterioBusqueda.compareTo(this.dato) == 0) return this;
        
        if (criterioBusqueda.compareTo(this.dato) < 0) {
            if (hijoIzq == null) return null;
            return hijoIzq.buscar(criterioBusqueda);
        } else {
            if (hijoDer == null) return null;
            return hijoDer.buscar(criterioBusqueda);
        }
    }

    @Override
    public TDAElemento eliminar(Comparable criterioBusqueda) {
        if (criterioBusqueda.compareTo(this.dato) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(criterioBusqueda);
            }
        } else if (criterioBusqueda.compareTo(this.dato) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(criterioBusqueda);
            }
        } else {
            if (hijoIzq == null) return hijoDer;
            if (hijoDer == null) return hijoIzq;

            Elemento<T> sucesor = (Elemento<T>) hijoDer;
            while (sucesor.hijoIzq != null) {
                sucesor = (Elemento<T>) sucesor.hijoIzq;
            }
            this.dato = sucesor.dato;
            hijoDer = hijoDer.eliminar(sucesor.dato);
        }
        return this;
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
    public String inOrdenString() {
        String recorrido = "";
        if (hijoIzq != null) recorrido += hijoIzq.inOrdenString();
        recorrido += this.dato.toString() + " ";

        if (hijoDer != null) recorrido += hijoDer.inOrdenString();
        return recorrido;
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
        return hijoIzq == null && hijoDer == null;
    }

    @Override
    public int cantidadHojas() {
        if (esHoja()) return 1;
        int hojasIzq = (hijoIzq != null) ? hijoIzq.cantidadHojas() : 0;
        int hojasDer = (hijoDer != null) ? hijoDer.cantidadHojas() : 0;
        return hojasIzq + hojasDer;
    }

    @Override
    public int cantidadNodosInternos() {
        if (esHoja()) return 0;
        int nodosInternosIzq = (hijoIzq != null) ? hijoIzq.cantidadNodosInternos() : 0;
        int nodosInternosDer = (hijoDer != null) ? hijoDer.cantidadNodosInternos() : 0;
        return 1 + nodosInternosIzq + nodosInternosDer;
    }

    @Override
    public int cantidadNodos() {
        int izq = (hijoIzq != null) ? hijoIzq.cantidadNodos() : 0;
        int der = (hijoDer != null) ? hijoDer.cantidadNodos() : 0;
        return 1 + izq + der;
    }

    @Override
    public int altura() {
        int altIzq = (hijoIzq != null) ? hijoIzq.altura() : -1;
        int altDer = (hijoDer != null) ? hijoDer.altura() : -1;
        return Math.max(altIzq, altDer) + 1;
    }

    @Override
    public int obtenerNivel(Comparable criterioBusqueda) {
    if (criterioBusqueda.compareTo(this.dato) == 0) return 0;
    
    if (criterioBusqueda.compareTo(this.dato) < 0) {
        if (hijoIzq == null) return -1;
        int nivel = hijoIzq.obtenerNivel(criterioBusqueda);
        if (nivel == -1) return -1;
        return nivel + 1;
    } else {
        if (hijoDer == null) return -1;
        int nivel = hijoDer.obtenerNivel(criterioBusqueda);
        if (nivel == -1) return -1;
        return nivel + 1;
    }  
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    public List<TDAElemento<T>> completos() {
    List<TDAElemento<T>> lista = new ArrayList<>();
    if (hijoIzq != null) {
        if (hijoDer != null) {
            lista.add(this);
        }
    }
    if (hijoIzq != null) {
        lista.addAll(((Elemento<T>) hijoIzq).completos());
    }
    if (hijoDer != null) {
        lista.addAll(((Elemento<T>) hijoDer).completos());
    }
    return lista;
}

    public List<TDAElemento<T>> enNivel(int nivel) {
        List<TDAElemento<T>> lista = new ArrayList<>();
        if (nivel == 0) {
            lista.add(this);
            return lista;
        }
        if (hijoIzq != null) lista.addAll(((Elemento<T>) hijoIzq).enNivel(nivel - 1));
        if (hijoDer != null) lista.addAll(((Elemento<T>) hijoDer).enNivel(nivel - 1));
        return lista;
    }
}