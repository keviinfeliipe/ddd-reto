package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.ActividadId;
import co.com.sofka.reto.cuenta.value.CuentaId;

public class QuitarActividadCommand extends Command {
    private final CuentaId cuentaId;
    private final ActividadId actividadId;

    public QuitarActividadCommand(CuentaId cuentaId, ActividadId actividadId) {
        this.cuentaId = cuentaId;
        this.actividadId = actividadId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }
}
