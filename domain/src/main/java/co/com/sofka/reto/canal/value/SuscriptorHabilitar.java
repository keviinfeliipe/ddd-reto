package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SuscriptorHabilitar implements ValueObject<Boolean> {
    private final Boolean value;

    public SuscriptorHabilitar(Boolean value) {
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
        SuscriptorHabilitar that = (SuscriptorHabilitar) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
