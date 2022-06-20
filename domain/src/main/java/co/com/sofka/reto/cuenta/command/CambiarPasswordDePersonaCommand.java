package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.CuentaId;
import co.com.sofka.reto.cuenta.value.PersonaPassword;

public class CambiarPasswordDePersonaCommand extends Command {
    private final CuentaId cuentaId;
    private final PersonaPassword password;

    public CambiarPasswordDePersonaCommand(CuentaId cuentaId, PersonaPassword password) {
        this.cuentaId = cuentaId;
        this.password = password;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public PersonaPassword getPassword() {
        return password;
    }
}
