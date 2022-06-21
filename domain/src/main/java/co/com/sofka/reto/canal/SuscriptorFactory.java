package co.com.sofka.reto.canal;

import co.com.sofka.reto.canal.value.CanalId;
import co.com.sofka.reto.canal.value.SuscriptorId;
import co.com.sofka.reto.canal.value.SuscriptorTipo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SuscriptorFactory {
    public static SuscriptorFactory instance;
    private final Set<Suscriptor> suscriptores;

    private SuscriptorFactory() {
        this.suscriptores = new HashSet<>();
    }

    public static SuscriptorFactory getInstance(){
        if (Objects.isNull(instance)){
            instance = new SuscriptorFactory();
            return instance;
        }
        return instance;
    }

    public SuscriptorFactory add(CanalId canalId,SuscriptorId suscriptorId, SuscriptorTipo tipo, CanalId canalSuscriptorId){
        suscriptores.add(new Suscriptor(canalId,suscriptorId,tipo,canalSuscriptorId));
        return this;
    }

    public Set<Suscriptor> suscriptores() {
        return suscriptores;
    }
}
