package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NotificacionDescripcion implements ValueObject<String> {
    private final String id;

    public NotificacionDescripcion(String id) {
        this.id = id;
    }

    @Override
    public String value() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificacionDescripcion that = (NotificacionDescripcion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
