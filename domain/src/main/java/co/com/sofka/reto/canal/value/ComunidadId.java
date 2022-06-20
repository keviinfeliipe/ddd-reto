package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.Identity;

public class ComunidadId extends Identity {
    private ComunidadId(String uuid) {
        super(uuid);
    }

    public ComunidadId() {
    }

    public static ComunidadId of(String id){
        return new ComunidadId(id);
    }
}
