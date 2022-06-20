package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActividadTipo implements ValueObject<ActividadTipo.Tipos> {

    private final Tipos tipo;

    public ActividadTipo(Tipos tipo) {
        Objects.requireNonNull(tipo);
        this.tipo = tipo;
    }

    @Override
    public Tipos value() {
        return tipo;
    }

    public enum Tipos {
        PUBLICACION, SUSCRIPCION
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadTipo that = (ActividadTipo) o;
        return tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
