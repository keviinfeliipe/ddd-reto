package co.com.sofka.reto.cuenta.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cuenta.value.PersonaEmail;
import co.com.sofka.reto.cuenta.value.PersonaPassword;

public class PasswordDePersonaCambiado extends DomainEvent {
    private final PersonaEmail email;
    private final PersonaPassword password;

    public PasswordDePersonaCambiado(PersonaEmail email, PersonaPassword password) {
        super("sofka.cuenta.PasswordDePersonaCambiado");
        this.email = email;
        this.password = password;
    }

    public PersonaEmail getEmail() {
        return email;
    }

    public PersonaPassword getPassword() {
        return password;
    }
}
