package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MembresiaValor implements ValueObject<Integer> {

    private final Integer value;

    public MembresiaValor(Integer value) {
        Objects.requireNonNull(value);
        if (value<0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembresiaValor valor = (MembresiaValor) o;
        return Objects.equals(value, valor.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
