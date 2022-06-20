package co.com.sofka.reto.compra.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.compra.value.MembresiaId;
import co.com.sofka.reto.compra.value.MembresiaTipo;
import co.com.sofka.reto.compra.value.MembresiaValor;

public class MembresiaAgregada extends DomainEvent {

    private final MembresiaId id;
    private final MembresiaTipo tipo;
    private final MembresiaValor valor;

    public MembresiaAgregada(MembresiaId id, MembresiaTipo tipo, MembresiaValor valor) {
        super("sofka.compra.MembresiaAgregada");
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public MembresiaId getId() {
        return id;
    }

    public MembresiaTipo getTipo() {
        return tipo;
    }

    public MembresiaValor getValor() {
        return valor;
    }
}
