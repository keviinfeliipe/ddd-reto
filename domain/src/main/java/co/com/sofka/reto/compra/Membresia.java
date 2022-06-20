package co.com.sofka.reto.compra;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.compra.value.MembresiaId;
import co.com.sofka.reto.compra.value.MembresiaTipo;
import co.com.sofka.reto.compra.value.MembresiaValor;

public class Membresia extends Entity<MembresiaId> {

    private MembresiaTipo tipo;
    private MembresiaValor valor;

    public Membresia(MembresiaId entityId, MembresiaTipo tipo, MembresiaValor valor) {
        super(entityId);
        this.tipo = tipo;
        this.valor = valor;
    }

    public void actualizarValor(MembresiaValor valor){
        this.valor=valor;
    }

    public MembresiaTipo tipo() {
        return tipo;
    }

    public MembresiaValor valor() {
        return valor;
    }
}
