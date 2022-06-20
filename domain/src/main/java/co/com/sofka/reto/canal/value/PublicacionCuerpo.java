package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PublicacionCuerpo implements ValueObject<String> {
    private final String value;

    public PublicacionCuerpo(String value) {
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
        PublicacionCuerpo that = (PublicacionCuerpo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
