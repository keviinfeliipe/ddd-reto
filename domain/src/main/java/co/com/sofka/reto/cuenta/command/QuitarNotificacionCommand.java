package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.CuentaId;
import co.com.sofka.reto.cuenta.value.NotificacionId;

public class QuitarNotificacionCommand extends Command {
    private final CuentaId cuentaId;
    private final NotificacionId notificacionId;

    public QuitarNotificacionCommand(CuentaId cuentaId, NotificacionId notificacionId) {
        this.cuentaId = cuentaId;
        this.notificacionId = notificacionId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public NotificacionId getNotificacionId() {
        return notificacionId;
    }
}
