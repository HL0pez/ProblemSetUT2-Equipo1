package ucu.edu.aed.tda.Implementaciones.Ejercicio13;

public class Nave {
    private int codigo;
    private String clase;
    private int combustible;

    public Nave(int codigo, String clase, int combustible) {
        this.codigo = codigo;
        this.clase = clase;
        this.combustible = combustible;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getClase() {
        return clase;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "codigo=" + codigo +
                ", clase='" + clase + '\'' +
                ", combustible=" + combustible +
                '}';
    }
}
