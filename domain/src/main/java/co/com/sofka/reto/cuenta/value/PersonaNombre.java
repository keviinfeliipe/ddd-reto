package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PersonaNombre implements ValueObject<String> {
    private final String value;

    public PersonaNombre(String value) {
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
        PersonaNombre that = (PersonaNombre) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
