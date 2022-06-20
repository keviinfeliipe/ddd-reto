package co.com.sofka.reto.canal.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.SuscriptorId;

public class QuitarSuscriptorCommand extends Command {
    private final CanalId canalId;
    private final SuscriptorId suscriptorId;

    public QuitarSuscriptorCommand(CanalId canalId, SuscriptorId suscriptorId) {
        this.canalId = canalId;
        this.suscriptorId = suscriptorId;
    }

    public CanalId getCanalId() {
        return canalId;
    }

    public SuscriptorId getSuscriptorId() {
        return suscriptorId;
    }
}
