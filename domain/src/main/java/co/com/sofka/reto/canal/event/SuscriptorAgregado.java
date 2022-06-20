package co.com.sofka.reto.canal.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.Suscriptor;
import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.SuscriptorFecha;
import co.com.sofka.reto.canal.value.SuscriptorId;
import co.com.sofka.reto.canal.value.SuscriptorTipo;

public class SuscriptorAgregado extends DomainEvent {
    private final SuscriptorId suscriptorId;
    private final SuscriptorTipo tipo;
    private final CanalId canalId;

    public SuscriptorAgregado(SuscriptorId suscriptorId, SuscriptorTipo tipo, CanalId canalId) {
        super("sofka.canal.SuscriptorAgregado");
        this.suscriptorId = suscriptorId;
        this.tipo = tipo;
        this.canalId = canalId;
    }

    public SuscriptorId getSuscriptorId() {
        return suscriptorId;
    }

    public SuscriptorTipo getTipo() {
        return tipo;
    }

    public CanalId getCanalId() {
        return canalId;
    }
}
