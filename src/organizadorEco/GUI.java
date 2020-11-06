package organizadorEco;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    private String tituloStr = "Just do that.";

    public GUI() {

    	//Rectangulo de la aplicación
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador EcolÃ³gico");
        frame.getContentPane().setBackground(new Color(0x27AE60));
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        //Recuadro que contiene el titulo
        JPanel header = new JPanel();
        header.setBackground(new Color(0xB0FFA3));
        header.setPreferredSize(new Dimension(350, 60));
        header.setLayout(new BorderLayout(10, 10));

        //Texto del titulo
        JLabel titulo = new JLabel(tituloStr);
        titulo.setFont(new Font("Montserrat", Font.PLAIN, 20));
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.white);

        header.add(titulo);

        //Recuadro que contiene los botones en la parte de abajo
        JPanel footer = new JPanel();
        footer.setBackground(new Color(0x7EF36B));
        footer.setPreferredSize(new Dimension(350, 60));
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        //Creacion de los "Botones"
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

        //Adicion de los botones al footer
        for (JLabel imagen : imagenes) {
            footer.add(imagen);
        }

        //Adicion de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
