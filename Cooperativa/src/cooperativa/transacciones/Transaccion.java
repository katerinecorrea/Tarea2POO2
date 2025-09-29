package cooperativa.transacciones;

public interface Transaccion {
    void ejecutar();
    double getMonto();
}