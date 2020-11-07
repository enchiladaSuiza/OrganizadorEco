package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {


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
        String tituloStr = "Just do that.";
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
        JButton hechos = new JButton();
        hechos.setIcon(new ImageIcon("imagenes/checkbox.png"));
        hechos.setBackground(null);
        hechos.setBorder(null);
        hechos.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de hechos ao");
        	}
        });
        
        JButton calendario = new JButton();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de calendario ao x2");
        	}
        });
        
        JButton home = new JButton();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de home ao x3");
        	}
        });
        
        JButton basura = new JButton();
        basura.setIcon(new ImageIcon("imagenes/trash.png"));
        basura.setBackground(null);
        basura.setBorder(null);
        basura.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Hola, esta es la accion del boton de basura ao x4");
        	}
        });
        
        JButton config = new JButton();
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
        JPanel principal = new JPanel();
        principal.setBackground(Color.YELLOW);
        principal.setPreferredSize(new Dimension(350, 480));
        principal.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Panel Tasks
        JPanel task = new JPanel();
        task.setBackground(new Color(0, 194, 0));
        task.setPreferredSize(new Dimension(300, 80));
        task.setLayout(new BorderLayout());

        //Add Button
        JButton addOne = new JButton();
        addOne.setIcon(new ImageIcon("images/anadir.png"));
        addOne.setBackground(null);
        addOne.setBorder(null);

        addOne.addActionListener(e -> {
            System.out.println("Agregando Task...");
            principal.add(task);
        });
        principal.add(addOne);

        //Adicion de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.add(principal, BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
