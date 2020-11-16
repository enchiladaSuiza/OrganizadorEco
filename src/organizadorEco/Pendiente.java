package organizadorEco;

import java.time.LocalDate;

public class Pendiente {
    private String descripcion;
    private LocalDate fechaLimite;

    Pendiente(String descripcion) {
        this.descripcion = descripcion;
        this.fechaLimite = LocalDate.now();
    }

    Pendiente(String descripcion, int year, int month, int day) {
        this.descripcion = descripcion;
        this.fechaLimite = LocalDate.of(year, month, day);
    }

    Pendiente(String descripcion, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getYear() { return fechaLimite.getYear(); }

    public int getMonth() { return fechaLimite.getMonthValue(); }

    public int getDay() { return fechaLimite.getDayOfMonth(); }

    public String getFechaStr() {
        return fechaLimite.toString();
    }

    public LocalDate getFecha() {
        return fechaLimite;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setFechaLimite(int year, int month, int day) {
        fechaLimite = LocalDate.of(year, month, day);
    }
}
