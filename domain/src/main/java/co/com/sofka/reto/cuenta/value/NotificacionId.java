package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.Identity;

public class NotificacionId extends Identity {
    private NotificacionId(String uuid) {
        super(uuid);
    }

    public NotificacionId() {
    }

    public static NotificacionId of(String id){
        return new NotificacionId(id);
    }

}
