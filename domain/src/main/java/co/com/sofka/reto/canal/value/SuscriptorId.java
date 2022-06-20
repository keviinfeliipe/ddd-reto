package co.com.sofka.reto.canal.value;

import co.com.sofka.domain.generic.Identity;

public class SuscriptorId extends Identity {
    private SuscriptorId(String uuid) {
        super(uuid);
    }

    public SuscriptorId() {
    }

    public static SuscriptorId of(String id){
        return new SuscriptorId(id);
    }
}
