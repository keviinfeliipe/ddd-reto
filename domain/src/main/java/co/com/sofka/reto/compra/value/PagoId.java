package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.Identity;

public class PagoId extends Identity {
    private PagoId(String uuid) {
        super(uuid);
    }

    public PagoId() {
    }

    public static PagoId of(String id){
        return new PagoId(id);
    }
}
