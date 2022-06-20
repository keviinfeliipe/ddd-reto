package co.com.sofka.reto.canal;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.canal.event.*;

import java.util.HashSet;

public class CanalChange extends EventChange {
    public CanalChange(Canal canal) {
        apply((CanalCreado event)->{
            canal.suscriptores = new HashSet<>();
            canal.videos = new HashSet<>();
            canal.comunidad = event.getComunidad();
            canal.descripcion = event.getDescripcion();
        });

        apply((VideoAgregado event)-> canal.videos.add(new Video(event.getVideoId(),event.getCategoria(),event.getMultimedia())));

        apply((SuscriptorAgregado event)-> canal.suscriptores.add(new Suscriptor(event.getSuscriptorId(),event.getTipo(),event.getCanalId())));

        apply((VideoQuitado event)->{
            var video = canal
                    .buscarVideoPorId(event.getVideoId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el video"));
            canal.videos.remove(video);
        } );

        apply((SuscriptorQuitado event)->{
            var suscriptor= canal
                    .buscarSuscriptorPorId(event.getSuscriptorId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el suscriptor"));
            canal.suscriptores.remove(suscriptor);
        });
        apply((DescripcionCambiada event)-> canal.descripcion= event.getDescripcion());
    }
}
