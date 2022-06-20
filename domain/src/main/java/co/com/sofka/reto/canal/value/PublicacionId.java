package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.Identity;

public class PublicacionId extends Identity {
    private PublicacionId(String uuid) {
        super(uuid);
    }

    public PublicacionId() {
    }

    public static PublicacionId of(String id){
        return new PublicacionId(id);
    }
}
