package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.Identity;

public class CompraId extends Identity {
    private CompraId(String uuid) {
        super(uuid);
    }

    public CompraId() {
    }

    public static CompraId of(String id){
        return new CompraId(id);
    }
}
