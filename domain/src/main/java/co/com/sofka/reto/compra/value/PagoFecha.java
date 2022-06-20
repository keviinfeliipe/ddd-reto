package co.com.sofka.reto.compra.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PagoFecha implements ValueObject<String> {
    private final LocalDate date;
    private final String format;

    public PagoFecha(int day, int month, int year) {//(2)
        try {
            date = LocalDate.of(year, month, day);
            if(date.isAfter(LocalDate.now())){
                throw new IllegalArgumentException("Fecha no valida");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generateFormat();
    }

    private String generateFormat(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {//(3)
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoFecha pagoFecha = (PagoFecha) o;
        return Objects.equals(date, pagoFecha.date) && Objects.equals(format, pagoFecha.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, format);
    }
}
