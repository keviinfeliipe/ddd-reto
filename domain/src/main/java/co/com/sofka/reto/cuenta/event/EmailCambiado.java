package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.PersonaEmail;

public class EmailCambiado extends DomainEvent {
    private final PersonaEmail email;

    public EmailCambiado(PersonaEmail email) {
        super("sofka.cuenta.EmailCambiado");
        this.email = email;
    }

    public PersonaEmail getEmail() {
        return email;
    }
}
