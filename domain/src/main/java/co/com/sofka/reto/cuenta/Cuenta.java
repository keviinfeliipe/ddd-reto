package co.com.sofka.reto.cuenta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.event.*;
import co.com.sofka.reto.cuenta.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cuenta extends AggregateEvent<CuentaId> {

    protected Persona persona;
    protected Set<Actividad> actividades;
    protected Set<Notificacion> notificaciones;
    protected CuentaFechaCreacion fechaCreacion;

    public Cuenta(CuentaId entityId, Persona persona) {
        super(entityId);
        subscribe(new CuentaChange(this));
        appendChange(new CuentaCreada(persona)).apply();
    }

    private Cuenta(CuentaId entityId) {
        super(entityId);
        subscribe(new CuentaChange(this));
    }

    public static Cuenta from(CuentaId id, List<DomainEvent> events){
        var cuenta = new Cuenta(id);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public Persona persona() {
        return persona;
    }

    public Set<Actividad> actividades() {
        return actividades;
    }

    public CuentaFechaCreacion fechaCreacion() {
        return fechaCreacion;
    }

    public Set<Notificacion> notificaciones() {
        return notificaciones;
    }

    public Optional<Actividad> buscarActividadPorId(ActividadId id){
        return actividades()
                .stream()
                .filter(actividad -> actividad.identity().equals(id))
                .findFirst();
    }

    public Optional<Notificacion> buscarNotificacionPorId(NotificacionId id){
        return notificaciones()
                .stream()
                .filter(notificacion -> notificacion.identity().equals(id))
                .findFirst();
    }

    public void agregarActividad(ActividadId actividadId, ActividadTipo tipo, ActividadDescripcion descripcion, ActividadVinculo vinculo){
        Objects.requireNonNull(actividadId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(descripcion);
        Objects.requireNonNull(vinculo);
        appendChange(new ActividadAgregada(actividadId,tipo,descripcion,vinculo)).apply();
    }

    public void cambiarNombreDePersona(PersonaNombre nombre){
        Objects.requireNonNull(nombre);
        appendChange(new NombreDePersonaCambiado(nombre)).apply();
    }

    public void cambiarEmailDePersona(PersonaEmail email){
        Objects.requireNonNull(email);
        appendChange(new EmailCambiado(email)).apply();
    }

    public void cambiarPasswordDePersona(PersonaEmail email, PersonaPassword password){
        Objects.requireNonNull(password);
        appendChange(new PasswordDePersonaCambiado(email,password)).apply();
    }
    public void quitarActividad(ActividadId id){
        Objects.requireNonNull(id);
        appendChange(new ActividadQuitada(id)).apply();
    }
    public void quitarNotificacion(NotificacionId id){
        Objects.requireNonNull(id);
        appendChange(new NotificacionQuitada(id)).apply();
    }

}
