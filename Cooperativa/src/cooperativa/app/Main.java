package cooperativa.app;

import cooperativa.model.*;
import cooperativa.transacciones.*;

public class Main {
    public static void main(String[] args) {
        Cooperativa coop = new Cooperativa();

        // Crear socios
        Socio s1 = new Socio("Juan Perez", "123");
        Socio s2 = new Socio("María Rodriguez", "456");
        coop.registrarSocio(s1);
        coop.registrarSocio(s2);

        // Abrir cuentas de ahorro
        s1.agregarCuenta(new CuentaAhorros("001", 0.02));
        s1.agregarCuenta(new CuentaAhorros("002", 0.03));
        s2.agregarCuenta(new CuentaAhorros("003", 0.02));

        // Depositar y retirar
        CuentaAhorros c1 = (CuentaAhorros) s1.getCuentas().get(0);
        Deposito dep = new Deposito(c1, 600000);
        dep.ejecutar();

        Retiro ret = new Retiro(c1, 100000);
        try {
            ret.ejecutar();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Aplicar interés
        c1.aplicarInteres();

        //Listar nombres de socios
        System.out.println("Socios registrados:");
        coop.getSocios().stream()
                .map(Socio::getNombre)
                .forEach(System.out::println);

        // Filtrar y mostrar cuentas con saldo > 500,000
        System.out.println("\nCuentas con saldo mayor a $500,000:");
        coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .filter(c -> c.getSaldo() > 500000)
                .forEach(c -> System.out.println("Cuenta: " + c.getNumeroCuenta() + ", Saldo: " + c.getSaldo()));

        // Sumar total de dinero en la cooperativa
        double total = coop.getSocios().stream()
                .flatMap(s -> s.getCuentas().stream())
                .map(Cuenta::getSaldo)
                .reduce(0.0, Double::sum);

        System.out.println("\nTotal dinero en la cooperativa: $" + total);
    }
}