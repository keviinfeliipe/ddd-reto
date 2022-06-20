package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.CuentaId;
import co.com.sofka.reto.cuenta.value.PersonaNombre;

public class CambiarNombreDePersonaCommand extends Command {
    private final CuentaId cuentaId;
    private final PersonaNombre nombre;

    public CambiarNombreDePersonaCommand(CuentaId cuentaId, PersonaNombre nombre) {
        this.cuentaId = cuentaId;
        this.nombre = nombre;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public PersonaNombre getNombre() {
        return nombre;
    }
}
