package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PagoHabilitar implements ValueObject<Boolean> {
    private final Boolean value;

    public PagoHabilitar(Boolean value) {
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
        PagoHabilitar that = (PagoHabilitar) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
