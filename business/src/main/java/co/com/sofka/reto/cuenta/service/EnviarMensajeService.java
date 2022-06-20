package co.com.sofka.reto.cuenta.service;

import co.com.sofka.reto.cuenta.value.PersonaEmail;

public interface EnviarMensajeService {
    void enviarMenaje(PersonaEmail email, String mensaje);
}
