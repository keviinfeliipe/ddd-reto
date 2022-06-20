package co.com.sofka.reto.cuenta.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cuenta.value.*;

public class AgregarActividadCommand extends Command {
    private final CuentaId cuentaId;
    private final ActividadId actividadId;
    private final ActividadTipo tipo;
    private final ActividadDescripcion descripcion;
    private final ActividadVinculo vinculo;

    public AgregarActividadCommand(CuentaId cuentaId, ActividadId actividadId, ActividadTipo tipo, ActividadDescripcion descripcion, ActividadVinculo vinculo) {
        this.cuentaId = cuentaId;
        this.actividadId = actividadId;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.vinculo = vinculo;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public ActividadId getActividadId() {
        return actividadId;
    }

    public ActividadTipo getTipo() {
        return tipo;
    }

    public ActividadDescripcion getDescripcion() {
        return descripcion;
    }

    public ActividadVinculo getVinculo() {
        return vinculo;
    }
}
