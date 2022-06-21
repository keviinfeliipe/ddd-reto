package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.canal.event.*;
import co.com.sofka.reto.canal.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Canal extends AggregateEvent<CanalId> {
    protected Set<Suscriptor> suscriptores;
    protected Set<Video> videos;
    protected Comunidad comunidad;
    protected CanalDescripcion descripcion;

    public Canal(CanalId entityId, Comunidad comunidad,CanalDescripcion descripcion) {
        super(entityId);
        subscribe(new CanalChange(this));
        appendChange(new CanalCreado(comunidad,descripcion)).apply();
    }
    private Canal(CanalId canalId){
        super(canalId);
        subscribe(new CanalChange(this));
    }
    public static Canal from(CanalId id, List<DomainEvent> events){
        var canal = new Canal(id);
        events.forEach(canal::applyEvent);
        return canal;
    }

    public Optional<Video> buscarVideoPorId(VideoId id){
        return videos()
                .stream()
                .filter(video -> video.identity().equals(id))
                .findFirst();
    }

    public Optional<Suscriptor> buscarSuscriptorPorId(SuscriptorId id){
        return suscriptores()
                .stream()
                .filter(suscriptor -> suscriptor.identity().equals(id))
                .findFirst();
    }

    public Set<Suscriptor> suscriptores() {
        return suscriptores;
    }

    public Set<Video> videos() {
        return videos;
    }

    public Comunidad comunidad() {
        return comunidad;
    }

    public void agregarVideos(VideoFactory factory){
        factory.videos()
                .forEach(video ->
                        appendChange(
                                new VideoAgregado(video.identity(),video.categoria(),video.multimedia())
                        ).apply()
                );
    }

    public void quitarVideo(VideoId videoId){
        Objects.requireNonNull(videoId);
        appendChange(new VideoQuitado(videoId)).apply();
    }

    public void agregarSuscriptores(SuscriptorFactory factory){
        factory.suscriptores()
                .forEach(suscriptor ->
                        appendChange(
                                new SuscriptorAgregado( suscriptor.canalId(),suscriptor.identity(),suscriptor.tipo(),suscriptor.canalSuscriptorId())
                        ).apply());
    }

    public void quitarSuscriptor(SuscriptorId suscriptorId){
        Objects.requireNonNull(suscriptorId);
        appendChange(new SuscriptorQuitado(suscriptorId)).apply();
    }

    public void cambiarDescripcion(CanalDescripcion descripcion){
        Objects.requireNonNull(descripcion);
        appendChange(new DescripcionCambiada(descripcion)).apply();
    }

}
