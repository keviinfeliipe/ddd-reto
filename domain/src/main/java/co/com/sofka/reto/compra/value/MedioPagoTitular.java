package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedioPagoTitular implements ValueObject<String> {
    private final String value;

    public MedioPagoTitular(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedioPagoTitular titular = (MedioPagoTitular) o;
        return Objects.equals(value, titular.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
