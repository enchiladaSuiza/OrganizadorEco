package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    JFrame frame;
    JPanel header;
    String tituloStr;
    JLabel titulo;
    JPanel footer;
    JButton hechos;
    JButton calendario;
    JButton home;
    JButton basura;
    JButton config;
    JPanel principal;

    public GUI() {

    	//Rectangulo de la aplicación
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador");
        frame.getContentPane().setBackground(new Color(0x27AE60));
        frame.setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(null);

        //Recuadro que contiene el titulo
        header = new JPanel();
        header.setBackground(new Color(0xB0FFA3));
        header.setPreferredSize(new Dimension(350, 60));
        header.setLayout(new BorderLayout(0, 0));

        //Texto del titulo
        tituloStr = "Just do that.";
        titulo = new JLabel(tituloStr);
        titulo.setFont(new Font("Montserrat", Font.BOLD, 20));
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.white);
        header.add(titulo);

        //Recuadro que contiene los botones en la parte de abajo
        footer = new JPanel();
        footer.setBackground(new Color(0x7EF36B));
        footer.setPreferredSize(new Dimension(350, 60));
        footer.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        //Creación de los "Botones"
        hechos = new JButton();
        hechos.setIcon(new ImageIcon("imagenes/checkbox.png"));
        hechos.setBackground(null);
        hechos.setBorder(null);
        hechos.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de hechos ao");
        	}
        });
        
        calendario = new JButton();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de calendario ao x2");
        	}
        });
        
        home = new JButton();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de home ao x3");
        	}
        });
        
        basura = new JButton();
        basura.setIcon(new ImageIcon("imagenes/trash.png"));
        basura.setBackground(null);
        basura.setBorder(null);
        basura.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de basura ao x4");
        	}
        });
        
        config = new JButton();
        config.setIcon(new ImageIcon("imagenes/gear.png"));
        config.setBackground(null);
        config.setBorder(null);
        config.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de configuarcion ao x10000");
        	}
        });

        JButton[] imagenes = {hechos, calendario, home, basura, config};

        //Adicion de los botones al footer
        for (JButton imagen : imagenes) {
           footer.add(imagen);
        }

        //Panel Principal
        principal = new JPanel();
        principal.setBackground(new Color(0x27AE60));
        principal.setPreferredSize(new Dimension(300, 100));
        principal.setLayout(new CardLayout());

        //Panel Tasks
        JPanel task = new JPanel();
        task.setBackground(new Color(0x27AE6A));
        task.setSize(new Dimension(200, 100));
        task.setOpaque(false);
        task.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JPanel[] pendientes = new JPanel[2];
        for (JPanel pendiente : pendientes) {
            pendiente = new JPanel();
            // El tamaño debería ponerse según el tamaño del título, o algo así.
            pendiente.setPreferredSize(new Dimension(300, 100));
            pendiente.setBackground(new Color(0xAFF478));
            task.add(pendiente);
        }

        //Add Button
        JButton addOne = new JButton();
        addOne.setIcon(new ImageIcon("imagenes/plus.png"));
        addOne.setBackground(null);
        addOne.setBorder(null);

        addOne.addActionListener(e -> {
            System.out.println("Agregando Task...");
            principal.add(task);
        });
        //principal.add(addOne);
        task.add(addOne);

        // Adición de las "cartas" pricipal
        principal.add(task);

        //Adición de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.add(principal, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
