package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    Font fuente;

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

        // Fuente
        fuente = new Font("Montserrat", Font.BOLD, 20);

        //Texto del titulo
        tituloStr = "Just do that.";
        titulo = new JLabel(tituloStr);
        titulo.setFont(fuente);
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

        // Panel tasks
        TaskPanel task = new TaskPanel();

        // Adición de las "cartas" principal
        principal.add(task);

        //Adición de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.add(principal, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class TaskPanel extends JPanel implements ActionListener {
        JButton addOne;
        ArrayList<JPanel> paneles;

        TaskPanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setSize(new Dimension(200, 100));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            paneles = new ArrayList<>();
            for (Pendiente pendiente : Organizador.pendientes) {
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());
                panel.setPreferredSize(new Dimension(300, 100));
                panel.setBackground(new Color(0xAFF478));
                JLabel label = new JLabel(pendiente.getDescripcion());
                label.setFont(fuente);
                panel.add(label);
                paneles.add(panel);
            }

            //Add Button
            addOne = new JButton();
            addOne.setIcon(new ImageIcon("imagenes/plus.png"));
            addOne.setBackground(null);
            addOne.setBorder(null);
            addOne.addActionListener(this);
            this.add(addOne);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel();
            // panel.setLayout(null);
            panel.setPreferredSize(new Dimension(300, 50));
            panel.setBackground(new Color(0xAFF478));
            this.remove(addOne);
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(280, 40));
            textField.addActionListener(f -> {
                String texto = textField.getText();
                Organizador.agregarPendiente(texto);
                panel.remove(textField);
                JLabel label = new JLabel();
                label.setFont(fuente);
                label.setPreferredSize(new Dimension(280, 40));
                label.setText(texto);
                panel.add(label);
                revalidate();
                repaint();
            });
            panel.add(textField);
            paneles.add(panel);
            actualizarPaneles();
        }

        private void actualizarPaneles() {
            this.removeAll();
            for (JPanel panel : paneles) {
                this.add(panel);
            }
            this.add(addOne);
            revalidate();
            repaint();
        }
    }
}
