package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.value.CanalId;

public class SuscriptorNuevoNotificado extends DomainEvent {
    private final CanalId canalId;

    public SuscriptorNuevoNotificado(CanalId canalId) {
        super("sofka.canal.SuscriptorNuevoNotificado");
        this.canalId = canalId;
    }

    public CanalId getCanalId() {
        return canalId;
    }
}
