package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActividadHabilitar implements ValueObject<Boolean> {
    private final Boolean value;

    public ActividadHabilitar(Boolean value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadHabilitar that = (ActividadHabilitar) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
