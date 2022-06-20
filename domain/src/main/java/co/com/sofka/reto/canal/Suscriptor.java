package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.*;

import java.time.LocalDate;

public class Suscriptor extends Entity<SuscriptorId> {
    private SuscriptorFecha fecha;
    private SuscriptorTipo tipo;
    private CanalId canalId;
    private SuscriptorHabilitar habilitar;

    public Suscriptor(SuscriptorId entityId, SuscriptorTipo tipo, CanalId canalId) {
        super(entityId);
        this.fecha = new SuscriptorFecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.tipo = tipo;
        this.canalId = canalId;
        this.habilitar = new SuscriptorHabilitar(true);
    }

    public void eliminarSuscriptor(){
        if (habilitar.value()){
            this.habilitar= new SuscriptorHabilitar(false);
        }
    }

    public SuscriptorFecha fecha() {
        return fecha;
    }

    public SuscriptorTipo tipo() {
        return tipo;
    }

    public CanalId canalId() {
        return canalId;
    }

    public SuscriptorHabilitar habilitar() {
        return habilitar;
    }
}
