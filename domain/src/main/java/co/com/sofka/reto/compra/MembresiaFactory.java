package co.com.sofka.reto.compra;

import co.com.sofka.reto.compra.value.MembresiaId;
import co.com.sofka.reto.compra.value.MembresiaTipo;
import co.com.sofka.reto.compra.value.MembresiaValor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MembresiaFactory {

    public static MembresiaFactory instance;
    private Set<Membresia> membresias;

    private MembresiaFactory() {
        this.membresias = new HashSet<>();
    }

    public static MembresiaFactory getInstance(){
        if (Objects.isNull(instance)){
            instance = new MembresiaFactory();
            return instance;
        }
        return instance;
    }

    public MembresiaFactory add(MembresiaId id, MembresiaTipo tipo, MembresiaValor valor){
        membresias.add(new Membresia(id,tipo,valor));
        return this;
    }

    public Set<Membresia> membresias() {
        return membresias;
    }
}
