package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.*;

import java.time.LocalDate;

public class Suscriptor extends Entity<SuscriptorId> {

    private CanalId canalId;
    private SuscriptorFecha fecha;
    private SuscriptorTipo tipo;
    private CanalId canalSuscriptorId;
    private SuscriptorHabilitar habilitar;

    public Suscriptor(CanalId canalId,SuscriptorId entityId, SuscriptorTipo tipo, CanalId canalSuscriptorId) {
        super(entityId);
        this.canalId = canalId;
        this.fecha = new SuscriptorFecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.tipo = tipo;
        this.canalSuscriptorId = canalSuscriptorId;
        this.habilitar = new SuscriptorHabilitar(true);
    }

    public void eliminarSuscriptor(){
        if (habilitar.value()){
            this.habilitar= new SuscriptorHabilitar(false);
        }
    }

    public CanalId canalId() {
        return canalId;
    }

    public SuscriptorFecha fecha() {
        return fecha;
    }

    public SuscriptorTipo tipo() {
        return tipo;
    }

    public CanalId canalSuscriptorId() {
        return canalSuscriptorId;
    }

    public SuscriptorHabilitar habilitar() {
        return habilitar;
    }
}
