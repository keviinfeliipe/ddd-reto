package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.Persona;
import co.com.sofka.reto.cuenta.value.CuentaId;

public class CrearCuentaCommand extends Command {
    private final CuentaId entityId;
    private final Persona persona;

    public CrearCuentaCommand(CuentaId entityId, Persona persona) {
        this.entityId = entityId;
        this.persona = persona;
    }

    public CuentaId getEntityId() {
        return entityId;
    }

    public Persona getPersona() {
        return persona;
    }
}
