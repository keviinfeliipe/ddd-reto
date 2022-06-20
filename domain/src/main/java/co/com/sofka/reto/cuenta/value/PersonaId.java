package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.Identity;

public class PersonaId extends Identity {
    private PersonaId(String uuid) {
        super(uuid);
    }

    public PersonaId() {
    }

    public static PersonaId of(String id){
        return new PersonaId(id);
    }
}
