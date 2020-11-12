package organizadorEco;

import java.time.LocalDate;

public class Pendiente {
    private String descripcion;
    private LocalDate fechaLimite;

    Pendiente(String descripcion) { this.descripcion = descripcion; }

    Pendiente(String descripcion, int año, int mes, int dia) {
        this.descripcion = descripcion;
        this.fechaLimite = LocalDate.of(año, mes, dia);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getAño() { return fechaLimite.getYear(); }

    public int getMes() { return fechaLimite.getMonthValue(); }

    public int getDia() { return fechaLimite.getDayOfMonth(); }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setFechaLimite(int año, int mes, int dia) { fechaLimite = LocalDate.of(año, mes, dia); }
}
