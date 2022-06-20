package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MedioPagoFecha implements ValueObject<String> {

    private final String format;

    public MedioPagoFecha(int month, int year) {
        Objects.requireNonNull(month);
        Objects.requireNonNull(year);
        if (month<=0 && month>12){
            throw new IllegalArgumentException("Ingrese un mes valido");
        }
        if(year<LocalDate.now().getYear()){
            throw new IllegalArgumentException("Ingrese un año valido");
        }
        this.format = String.format("%02d",month)+"/"+year;
    }

    @Override
    public String value() {
        return format;
    }


}
