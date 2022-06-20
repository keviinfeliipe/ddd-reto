package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActividadDescripcion implements ValueObject<String> {
    private final String value;

    public ActividadDescripcion(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadDescripcion that = (ActividadDescripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
