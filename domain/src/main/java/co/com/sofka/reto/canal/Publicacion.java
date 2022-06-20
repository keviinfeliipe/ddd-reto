package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Publicacion extends Entity<PublicacionId> {

    private PublicacionFecha fecha;
    private PublicacionCuerpo cuerpo;
    private CanalId canalId;
    private PublicacionHabilitar habilitar;
    private Set<Publicacion> publicaciones;

    public Publicacion(PublicacionId publicacionId, PublicacionCuerpo cuerpo, CanalId canalId) {
        super(publicacionId);
        this.fecha = new PublicacionFecha(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.cuerpo = cuerpo;
        this.canalId = canalId;
        this.habilitar = new PublicacionHabilitar(true);
        this.publicaciones = new HashSet<>();
    }

    public Optional<Publicacion> buscarPublicacionPorDi(PublicacionId id){
        return publicaciones()
                .stream()
                .filter(publicacion -> publicacion.identity().equals(id))
                .findFirst();
    }

    public void actualizarCuerpoPublicacion(PublicacionId id, PublicacionCuerpo cuerpo){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cuerpo);
        var publicacion = buscarPublicacionPorDi(id);
        publicacion.orElseThrow(() -> new IllegalArgumentException("No se encontró la publicacion")).actualizarCuerpo(cuerpo);
    }

    public void eliminarPublicacionPorId(PublicacionId id){
        var publicacion = buscarPublicacionPorDi(id);
        publicacion.orElseThrow(() -> new IllegalArgumentException("No se encontró la publicacion")).eliminarPublicacion();
    }

    public void actualizarCuerpo(PublicacionCuerpo cuerpo){
        Objects.requireNonNull(cuerpo);
        this.fecha = new PublicacionFecha(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.cuerpo= cuerpo;
    }

    public void eliminarPublicacion(){
        if(habilitar.value()){
            this.habilitar=new PublicacionHabilitar(false);
        }
    }

    public PublicacionFecha fecha() {
        return fecha;
    }

    public PublicacionCuerpo cuerpo() {
        return cuerpo;
    }

    public CanalId canalId() {
        return canalId;
    }

    public PublicacionHabilitar habilitar() {
        return habilitar;
    }

    public Set<Publicacion> publicaciones() {
        return publicaciones;
    }
}
