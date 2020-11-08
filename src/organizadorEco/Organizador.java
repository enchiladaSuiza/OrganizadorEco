package organizadorEco;

import java.util.ArrayList;

public abstract class Organizador {
    static ArrayList<Pendiente> pendientes = new ArrayList<>();
    static ArrayList<Pendiente> realizados = new ArrayList<>();

    public static void agregarPendiente(String descripcion) {
        Pendiente pendiente = new Pendiente(descripcion);
        pendientes.add(pendiente);
    }

    public static void modificarPendiente(String viejaDesc, String nuevaDesc) {
        for (Pendiente pendiente : pendientes) {
            if (pendiente.getDescripcion().equals(viejaDesc)) {
                pendiente.setDescripcion(nuevaDesc);
            }
        }
    }

    public static void marcarCompletado(String descripcion) {
        for (int i = 0; i < pendientes.size(); i++) {
            if (pendientes.get(i).getDescripcion().equals(descripcion)) {
                Pendiente pend = pendientes.get(i);
                pendientes.remove(pend);
                realizados.add(pend);
                break;
            }
        }
    }
}
