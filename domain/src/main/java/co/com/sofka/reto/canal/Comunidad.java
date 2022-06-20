package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.ComunidadId;

import java.util.HashSet;
import java.util.Set;

public class Comunidad extends Entity<ComunidadId> {
    private Set<Publicacion> publicaciones;
    public Comunidad(ComunidadId entityId) {
        super(entityId);
        this.publicaciones = new HashSet<>();
    }

    public Set<Publicacion> publicaciones() {
        return publicaciones;
    }
}
