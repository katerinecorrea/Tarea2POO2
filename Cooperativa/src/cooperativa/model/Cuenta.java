package cooperativa.model;

public class Cuenta {
    protected String numeroCuenta;
    protected double saldo;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }

    public double depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            return saldo;
        } else {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente o monto inválido.");
        }
    }
}