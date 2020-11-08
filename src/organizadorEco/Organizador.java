package organizadorEco;

import java.util.ArrayList;

public abstract class Organizador {
    static ArrayList<Pendiente> pendientes = new ArrayList<>();

    public static void agregarPendiente(String descripcion) {
        Pendiente pendiente = new Pendiente(descripcion);
        pendientes.add(pendiente);
    }
}
