package co.com.sofka.reto.cuenta;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.cuenta.value.*;

import java.time.LocalDate;

public class Actividad extends Entity<ActividadId> {
    private ActividadTipo tipo;
    private ActividadDescripcion descripcion;
    private ActividadVinculo vinculo;
    private ActividadFecha fecha;
    private ActividadHabilitar habilitar;

    public Actividad(ActividadId entityId, ActividadTipo tipo, ActividadDescripcion descripcion, ActividadVinculo vinculo) {
        super(entityId);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.vinculo = vinculo;
        this.fecha = new ActividadFecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.habilitar = new ActividadHabilitar(true);
    }


    public ActividadTipo tipo() {
        return tipo;
    }

    public ActividadDescripcion descripcion() {
        return descripcion;
    }

    public ActividadVinculo vinculo() {
        return vinculo;
    }

    public ActividadFecha fecha() {
        return fecha;
    }

    public ActividadHabilitar habilitar() {
        return habilitar;
    }

    public void eliminarActividad(){
        if (!habilitar.value()){
            throw new IllegalArgumentException("La activiadad ya se eliminó");
        }
        habilitar=new ActividadHabilitar(false);
    }
}
