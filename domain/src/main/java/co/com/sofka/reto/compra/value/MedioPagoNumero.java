package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedioPagoNumero implements ValueObject<String> {
    private final String value;

    public MedioPagoNumero(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        Objects.requireNonNull(value);
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedioPagoNumero numero = (MedioPagoNumero) o;
        return Objects.equals(value, numero.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
