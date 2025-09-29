package cooperativa.model;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String nombre;
    private String cedula;
    private List<Cuenta> cuentas;

    public Socio(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public List<Cuenta> getCuentas() { return cuentas; }

    public boolean agregarCuenta(Cuenta cuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(cuenta.getNumeroCuenta())) {
                return false;
            }
        }
        cuentas.add(cuenta);
        return true;
    }
}