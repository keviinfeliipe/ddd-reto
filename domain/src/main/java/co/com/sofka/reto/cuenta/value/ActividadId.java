package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.Identity;

public class ActividadId extends Identity {
    private ActividadId(String uuid) {
        super(uuid);
    }

    public ActividadId() {
    }

    public static ActividadId of(String id){
        return new ActividadId(id);
    }
}
