package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PagoServicio implements ValueObject<PagoServicio.Servicios> {
    private final Servicios servicios;

    public PagoServicio(Servicios servicios) {
        this.servicios = servicios;
    }

    @Override
    public Servicios value() {
        Objects.requireNonNull(value());
        return servicios;
    }

    public enum Servicios {
        MENBRESIA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoServicio servicio = (PagoServicio) o;
        return servicios == servicio.servicios;
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicios);
    }
}
