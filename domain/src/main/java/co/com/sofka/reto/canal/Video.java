package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.canal.value.*;

import java.time.LocalDate;

public class Video extends Entity<VideoId> {

    private VideoFecha fecha;
    private VideoCategoria categoria;
    private VideoMultimedia multimedia;

    public Video(VideoId entityId, VideoCategoria categoria, VideoMultimedia multimedia) {
        super(entityId);
        this.fecha = new VideoFecha(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonth().getValue(),LocalDate.now().getYear());
        this.categoria = categoria;
        this.multimedia = multimedia;
    }

    public void actualizarCategoria(VideoCategoria categoria){
        this.categoria = categoria;
    }

    public VideoFecha fecha() {
        return fecha;
    }

    public VideoCategoria categoria() {
        return categoria;
    }

    public VideoMultimedia multimedia() {
        return multimedia;
    }

}
