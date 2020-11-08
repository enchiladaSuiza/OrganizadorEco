package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    String fuente;

    TaskPanel task;
    DonePanel done;

    public GUI() {

    	//Rectangulo de la aplicación
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador");
        frame.getContentPane().setBackground(new Color(0x27AE60));
        frame.setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(null);

        //Panel Principal
        principal = new JPanel();
        principal.setBackground(new Color(0x27AE60));
        principal.setPreferredSize(new Dimension(300, 100));
        CardLayout pantallas = new CardLayout();
        principal.setLayout(pantallas);

        // Haciedno las cartas
        task = new TaskPanel();
        done = new DonePanel();
        principal.add(task, "task");
        principal.add(done, "done");

        pantallas.show(principal, "task");

        //Recuadro que contiene el titulo
        header = new JPanel();
        header.setBackground(new Color(0xB0FFA3));
        header.setPreferredSize(new Dimension(350, 60));
        header.setLayout(new BorderLayout(0, 0));

        // Fuente
        fuente = "Montserrat";

        //Texto del titulo
        tituloStr = "Just do that.";
        titulo = new JLabel(tituloStr);
        titulo.setFont(new Font(fuente, Font.BOLD, 20));
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
        hechos.addActionListener(e -> pantallas.show(principal, "done"));
        
        calendario = new JButton();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(e -> System.out.println("Hola, esta es la accion del boton de calendario ao x2"));
        
        home = new JButton();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(e -> pantallas.show(principal, "task"));
        
        basura = new JButton();
        basura.setIcon(new ImageIcon("imagenes/trash.png"));
        basura.setBackground(null);
        basura.setBorder(null);
        basura.addActionListener(e -> System.out.println("Hola, esta es la accion del boton de basura ao x4"));
        
        config = new JButton();
        config.setIcon(new ImageIcon("imagenes/gear.png"));
        config.setBackground(null);
        config.setBorder(null);
        config.addActionListener(e -> System.out.println("Hola, esta es la accion del boton de configuarcion ao x10000"));

        JButton[] imagenes = {hechos, calendario, home, basura, config};

        //Adicion de los botones al footer
        for (JButton imagen : imagenes) {
           footer.add(imagen);
        }

        //Adición de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        frame.add(principal, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class TaskPanel extends JPanel implements ActionListener {
        ArrayList<PendientePanel> paneles;
        JButton addOne;
        JPanel escritura;
        JTextField campo;

        TaskPanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            paneles = new ArrayList<>();
            for (int i = 0; i < Organizador.pendientes.size(); i++) {
                String desc = Organizador.pendientes.get(i).getDescripcion();
                paneles.add(new PendientePanel(desc));
            }
            addOne = new JButton();
            addOne.setIcon(new ImageIcon("imagenes/plus.png"));
            addOne.setBackground(null);
            addOne.setBorder(null);
            addOne.addActionListener(this);
            this.add(addOne);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.remove(addOne);
            escritura = new JPanel();
            escritura.setPreferredSize(new Dimension(300, 40));
            escritura.setBackground(new Color(0xAFF478));
            campo = new JTextField();
            campo.setPreferredSize(new Dimension(280, 30));
            campo.setFont(new Font(fuente, Font.PLAIN, 12));
            campo.addActionListener(f -> {
                String texto = campo.getText();
                Organizador.agregarPendiente(texto);
                int indice = Organizador.pendientes.size() - 1;
                PendientePanel pendiente = new PendientePanel(texto);
                paneles.add(pendiente);
                actualizarPaneles();
            });
            escritura.add(campo);
            this.add(escritura);
            revalidate();
            repaint();
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

        private class PendientePanel extends JPanel implements MouseListener {
            final int WIDTH = 300;
            final int HEIGHT = 40;
            final int SIZE = 15;
            JLabel label;
            JTextArea area;
            JButton eliminar;
            JButton confirmar;
            JButton guardar;

            PendientePanel(String descripcion) {
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setBackground(new Color(0xAFF478));

                label = new JLabel(descripcion, SwingConstants.CENTER);
                label.setFont(new Font(fuente, Font.PLAIN, SIZE));
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(285, 20));

                area = new JTextArea();
                area.setFont(new Font(fuente, Font.PLAIN, SIZE));
                area.setText(descripcion);
                area.setWrapStyleWord(true);
                area.setLineWrap(true);
                area.setPreferredSize(new Dimension(280, 95));

                eliminar = new JButton();
                ImageIcon remove = new ImageIcon("imagenes/remove.png");
                eliminar.setIcon(remove);
                eliminar.setBackground(null);
                eliminar.setBorder(null);

                confirmar = new JButton();
                ImageIcon checkmark = new ImageIcon("imagenes/checkmark.png");
                confirmar.setIcon(checkmark);
                confirmar.setBackground(null);
                confirmar.setBorder(null);
                confirmar.addActionListener(e -> {
                    done.agregar(area.getText());
                    paneles.remove(this);
                    task.actualizarPaneles();
                });

                guardar = new JButton();
                ImageIcon save = new ImageIcon("imagenes/save.png");
                guardar.setIcon(save);
                guardar.setBackground(null);
                guardar.setBorder(null);
                guardar.addActionListener(e -> {
                    this.remove(area);
                    this.remove(confirmar);
                    this.remove(eliminar);
                    this.remove(guardar);
                    this.add(label);
                    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                    label.setText(area.getText());
                    Organizador.modificarPendiente(descripcion, area.getText());
                    revalidate();
                    repaint();
                });

                this.add(label);
                this.addMouseListener(this);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT + 118));
                this.remove(label);
                this.add(area);
                this.add(eliminar);
                this.add(confirmar);
                this.add(guardar);
                revalidate();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        }
    }

    private class DonePanel extends JPanel {
        ArrayList<PendienteDone> hechos;
        JLabel puntaje;
        // JLabel icono;

        DonePanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            // icono = new JLabel();
            // icono.setIcon(new ImageIcon("imagenes/checkmark.png"));
            // icono.setPreferredSize(new Dimension(200, 32));
            // this.add(icono);
            hechos = new ArrayList<>();
            puntaje = new JLabel(Integer.toString(hechos.size()));
            puntaje.setFont(new Font(fuente, Font.BOLD, 18));
            puntaje.setForeground(Color.white);
            for (int i = 0; i < Organizador.realizados.size(); i++) {
                String desc = Organizador.realizados.get(i).getDescripcion();
                hechos.add(new PendienteDone(desc));
                actualizarPaneles();
            }
            this.add(puntaje);
        }

        private void actualizarPaneles() {
            this.removeAll();
            // this.add(icono);
            for (JPanel panel : hechos) {
                this.add(panel);
                this.add(new JLabel(new ImageIcon("imagenes/medal.png")));
            }
            puntaje.setText(Integer.toString(hechos.size()));
            this.add(puntaje);
            revalidate();
            repaint();
        }

        private void agregar(String desc) {
            PendienteDone hecho = new PendienteDone(desc);
            hechos.add(hecho);
            actualizarPaneles();
        }

        private class PendienteDone extends JPanel {
            final int WIDTH = 250;
            final int HEIGHT = 40;
            final int SIZE = 15;
            JLabel label;

            PendienteDone(String descripcion) {
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setBackground(new Color(0xAFF478));
                label = new JLabel(descripcion, SwingConstants.CENTER);
                label.setFont(new Font(fuente, Font.PLAIN, SIZE));
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(285, 20));
                this.add(label);
            }
        }
    }
}
