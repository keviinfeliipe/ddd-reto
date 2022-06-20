package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MembresiaTipo implements ValueObject<MembresiaTipo.Membresias> {

    private final Membresias membresias;

    public MembresiaTipo(Membresias membresias) {
        Objects.requireNonNull(membresias);
        this.membresias = membresias;
    }

    @Override
    public Membresias value() {
        return membresias;
    }

    public enum Membresias {
        PREMIUN, CANAL, SUPERCHAT
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembresiaTipo tipo = (MembresiaTipo) o;
        return membresias == tipo.membresias;
    }

    @Override
    public int hashCode() {
        return Objects.hash(membresias);
    }
}
