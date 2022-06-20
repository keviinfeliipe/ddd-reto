package co.com.sofka.reto.canal.service;

import co.com.sofka.reto.canal.value.CanalId;

public interface EnviarNotificacionService {
    void enviarNotificacion(CanalId canalId, String mensaje);
}
