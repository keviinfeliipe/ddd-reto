package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SuscriptorTipo implements ValueObject<SuscriptorTipo.Tipos> {
    private final Tipos tipo;

    public SuscriptorTipo(Tipos tipo) {
        Objects.requireNonNull(tipo);
        this.tipo = tipo;
    }

    @Override
    public Tipos value() {
        return tipo;
    }

    public enum Tipos {
        BASIC, PREMIUN
    }
}
