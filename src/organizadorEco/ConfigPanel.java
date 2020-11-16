package organizadorEco;

import javax.swing.*;
import java.awt.*;

class ConfigPanel extends JPanel {
    final int WIDTH = 320;
    final int HEIGHT = 50;
    JPanel custom;
    JLabel cambiarFuente;
    JTextField fuenteActual;

    ConfigPanel() {
        this.setBackground(GUI.colorPrincipal);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        custom = new JPanel();
        custom.setBackground(GUI.colorSecundario);
        // custom.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        custom.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

        cambiarFuente = new JLabel("Fuente");
        cambiarFuente.setFont(new Font(GUI.fuente, Font.PLAIN, 14));

        fuenteActual = new JTextField(GUI.fuente);
        fuenteActual.setFont(new Font(GUI.fuente, Font.PLAIN, 14));
        fuenteActual.setForeground(Color.gray);
        fuenteActual.setBackground(GUI.colorSecundario);

        custom.add(cambiarFuente);
        custom.add(fuenteActual);

        this.add(custom);
    }
}
