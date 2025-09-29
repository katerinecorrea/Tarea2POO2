package cooperativa.model;

public class CuentaAhorros extends Cuenta {
    private double interes;

    public CuentaAhorros(String numeroCuenta, double interes) {
        super(numeroCuenta);
        this.interes = interes;
    }

    public double getInteres() { return interes; }

    public void aplicarInteres() {
        saldo += saldo * interes;
    }
}