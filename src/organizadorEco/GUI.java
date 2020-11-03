package organizadorEco;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    private String tituloStr = "Just do that.";

    public GUI() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador Ecológico");
        frame.getContentPane().setBackground(new Color(0x27AE60));
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JPanel header = new JPanel();
        header.setBackground(new Color(0xB0FFA3));
        header.setPreferredSize(new Dimension(350, 60));
        header.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(tituloStr);
        titulo.setFont(new Font("Montserrat", Font.PLAIN, 20));
        titulo.setForeground(Color.white);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.black);

        header.add(titulo);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(0x7EF36B));
        footer.setPreferredSize(new Dimension(350, 60));
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        JLabel hechos = new JLabel();
        hechos.setIcon(new ImageIcon("imagenes/checkbox.png"));
        JLabel calendario = new JLabel();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        JLabel home = new JLabel();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        JLabel basura = new JLabel();
        basura.setIcon(new ImageIcon("imagenes/trash.png"));
        JLabel config = new JLabel();
        config.setIcon(new ImageIcon("imagenes/gear.png"));

        JLabel[] imagenes = {hechos, calendario, home, basura, config};

        for (JLabel imagen : imagenes) {
            footer.add(imagen);
        }

        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
