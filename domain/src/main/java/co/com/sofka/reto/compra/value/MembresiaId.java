package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.Identity;

public class MembresiaId extends Identity {
    private MembresiaId(String uuid) {
        super(uuid);
    }

    public MembresiaId() {
    }

    public static MembresiaId of(String id){
        return new MembresiaId(id);
    }
}
