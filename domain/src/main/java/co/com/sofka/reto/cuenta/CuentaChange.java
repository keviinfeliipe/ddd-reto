package co.com.sofka.reto.cuenta;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.cuenta.event.*;
import co.com.sofka.reto.cuenta.value.CuentaCreada;
import co.com.sofka.reto.cuenta.value.CuentaFechaCreacion;

import java.time.LocalDate;
import java.util.HashSet;

public class CuentaChange extends EventChange {
    public CuentaChange(Cuenta cuenta) {
        apply((CuentaCreada event)->{
            cuenta.persona = event.getPersona();
            cuenta.actividades = new HashSet<>();
            cuenta.notificaciones = new HashSet<>();
            cuenta.fechaCreacion = new CuentaFechaCreacion(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        });

        apply((ActividadAgregada event)->{
            cuenta.actividades().add(new Actividad(event.getActividadId(),event.getTipo(),event.getDescripcion(), event.getVinculo()));
        });
        apply((NombreDePersonaCambiado event)->{
            cuenta.persona.actualizarNombre(event.getNombre());
        });
        apply((EmailCambiado event)->{
            cuenta.persona.actualizarEmail(event.getEmail());
        });
        apply((PasswordDePersonaCambiado event)->{
            cuenta.persona.actualizarPassword(event.getPassword());
        });
        apply((ActividadQuitada event)->{
            var actividad = cuenta
                    .buscarActividadPorId(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró la actividad"));
            cuenta.actividades().remove(actividad);
        });
        apply((NotificacionQuitada event)->{
            var notificacion = cuenta
                    .buscarNotificacionPorId(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró la notificacion"));
            cuenta.notificaciones().remove(notificacion);
        });
    }
}
