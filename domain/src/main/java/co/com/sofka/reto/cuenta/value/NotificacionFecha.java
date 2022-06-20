package co.com.sofka.reto.cuenta.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class NotificacionFecha implements ValueObject<String> {
    private final LocalDate date;
    private final String format;

    public NotificacionFecha(int day, int month, int year) {
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
    public String value() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificacionFecha that = (NotificacionFecha) o;
        return Objects.equals(date, that.date) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, format);
    }
}
