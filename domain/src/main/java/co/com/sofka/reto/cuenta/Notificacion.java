package co.com.sofka.reto.cuenta;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.cuenta.value.NotificacionDescripcion;
import co.com.sofka.reto.cuenta.value.NotificacionFecha;
import co.com.sofka.reto.cuenta.value.NotificacionId;

import java.util.Objects;

public class Notificacion extends Entity<NotificacionId> {

    private NotificacionDescripcion descripcion;
    private NotificacionFecha fecha;

    public Notificacion(NotificacionId entityId, NotificacionDescripcion descripcion, NotificacionFecha fecha) {
        super(entityId);
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public NotificacionDescripcion descripcion() {
        return descripcion;
    }

    public NotificacionFecha fecha() {
        return fecha;
    }

}
