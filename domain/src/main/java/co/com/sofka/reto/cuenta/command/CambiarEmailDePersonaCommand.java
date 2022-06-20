package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.CuentaId;
import co.com.sofka.reto.cuenta.value.PersonaEmail;

public class CambiarEmailDePersonaCommand extends Command {
    private final CuentaId cuentaId;
    private final PersonaEmail email;

    public CambiarEmailDePersonaCommand(CuentaId cuentaId, PersonaEmail email) {
        this.cuentaId = cuentaId;
        this.email = email;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public PersonaEmail getEmail() {
        return email;
    }
}
