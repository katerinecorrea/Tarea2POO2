package cooperativa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cooperativa {
    private List<Socio> socios;

    public Cooperativa() {
        socios = new ArrayList<>();
    }

    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public Optional<Socio> buscarSocio(String cedula) {
        return socios.stream().filter(s -> s.getCedula().equals(cedula)).findFirst();
    }
}
