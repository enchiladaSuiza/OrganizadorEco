package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {
    JFrame frame;
<<<<<<< HEAD
    JPanel header, footer, principal, calendar;
    JLabel titulo;
    JButton hechos, calendario, home, basura, config;
    String tituloStr, fuente, pag;
=======
    JPanel header;
    JLabel titulo;
    JPanel footer;
    JButton hechos;
    JButton calendario;
    JButton home;
    JButton basura;
    JButton config;
    JPanel principal;

    String fuente = "Montserrat";
    String tituloStr = "Just do that.";

    TaskPanel task;
    DonePanel done;
    DeletedPanel deleted;
    ConfigPanel settings;
>>>>>>> 3fdb330b671bcdee10f4092307c4a332ffba9c28

    public GUI() {

    	//Rectangulo de la aplicación
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(null);

<<<<<<< HEAD
        //Pag Actual
        this.pag = "main";
=======
        //Panel Principal
        principal = new JPanel();
        principal.setBackground(new Color(0x27AE60));
        principal.setPreferredSize(new Dimension(300, 100));
        CardLayout pantallas = new CardLayout();
        principal.setLayout(pantallas);

        // Haciendo las cartas
        task = new TaskPanel();
        done = new DonePanel();
        deleted = new DeletedPanel();
        settings = new ConfigPanel();
        principal.add(task, "task");
        principal.add(done, "done");
        principal.add(deleted, "deleted");
        principal.add(settings, "settings");
        pantallas.show(principal, "task");
>>>>>>> 3fdb330b671bcdee10f4092307c4a332ffba9c28

        //Recuadro que contiene el titulo
        header = new JPanel();
        header.setBackground(new Color(0xB0FFA3));
        header.setPreferredSize(new Dimension(350, 60));
        header.setLayout(new BorderLayout(0, 0));

        //Texto del titulo
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
        hechos = new JButton(new ImageIcon("imagenes/checkbox.png"));
        hechos.setBackground(null);
        hechos.setBorder(null);
<<<<<<< HEAD
        hechos.addActionListener(e -> {
            this.pag = "hechos";
            System.out.println("Hola, esta es la accion del boton de hechos ao");
        });

        //Calendari0
        Calendario obj = new Calendario();
        calendario = new JButton();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(e -> {
            this.principal.setVisible(false);
            frame.add(obj, BorderLayout.CENTER);
            obj.setVisible(true);
            this.pag = "calendar";
            System.out.println("Hola, esta es la accion del boton de calendario ao x2");
        });

        /*calendar = new JPanel();
        calendar.setBackground(new Color(0x27AE60));
        calendar.setPreferredSize(new Dimension(350, 400));
        calendar.setLayout(new BorderLayout(0, 0));

        calendar.add(new Calendario(), BorderLayout.CENTER);*/

        home = new JButton();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(e -> {
            obj.setVisible(false);
            this.principal.setVisible(true);
            this.pag = "main";
            System.out.println("Hola, esta es la accion del boton de home ao x3");
        });
=======
        hechos.addActionListener(e -> pantallas.show(principal, "done"));
        
        calendario = new JButton(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(e -> System.out.println("Hola, esta es la accion del boton de calendario ao x2"));
        
        home = new JButton(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(e -> pantallas.show(principal, "task"));
>>>>>>> 3fdb330b671bcdee10f4092307c4a332ffba9c28
        
        basura = new JButton(new ImageIcon("imagenes/trash.png"));
        basura.setBackground(null);
        basura.setBorder(null);
<<<<<<< HEAD
        basura.addActionListener(e -> {
            this.pag = "trash";
            System.out.println("Hola, esta es la accion del boton de basura ao x4");
        });
=======
        basura.addActionListener(e -> pantallas.show(principal, "deleted"));
>>>>>>> 3fdb330b671bcdee10f4092307c4a332ffba9c28
        
        config = new JButton(new ImageIcon("imagenes/gear.png"));
        config.setBackground(null);
        config.setBorder(null);
<<<<<<< HEAD
        config.addActionListener(e -> {
            this.pag = "config";
            System.out.println("Hola, esta es la accion del boton de configuarcion ao x10000");
        });

        JButton[] imagenes = {hechos, calendario, home, basura, config};
=======
        config.addActionListener(e -> pantallas.show(principal, "settings"));
>>>>>>> 3fdb330b671bcdee10f4092307c4a332ffba9c28

        //Adicion de los botones al footer
        JButton[] imagenes = {hechos, calendario, home, basura, config};
        for (JButton imagen : imagenes) {
           footer.add(imagen);
        }

        //Adición de los elementos al frame
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
        switch (this.pag) {
            case "main" -> {
                frame.add(principal, BorderLayout.CENTER);
            }
            case "calendar" -> {
                frame.add(obj, BorderLayout.CENTER);
            }
        }

        frame.setVisible(true);
    }

    private class TaskPanel extends JPanel implements ActionListener {
        JButton addOne;
        JPanel escritura;
        JTextField campo;

        TaskPanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            addOne = new JButton();
            addOne.setIcon(new ImageIcon("imagenes/plus.png"));
            addOne.setBackground(null);
            addOne.setBorder(null);
            addOne.addActionListener(this);
            actualizarPaneles();
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
                this.actualizarPaneles();
            });
            escritura.add(campo);
            this.add(escritura);
            revalidate();
            repaint();
        }

        private void actualizarPaneles() {
            this.removeAll();
            for (Pendiente pend : Organizador.pendientes) {
                PendientePanel panel = new PendientePanel(pend.getDescripcion());
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
                label.setPreferredSize(new Dimension(WIDTH - 15, HEIGHT / 2));

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
                eliminar.addActionListener(e -> {
                    Organizador.modificarPendiente(descripcion, area.getText());
                    deleted.borrar(area.getText());
                    actualizarPaneles();
                });

                confirmar = new JButton();
                ImageIcon checkmark = new ImageIcon("imagenes/checkmark.png");
                confirmar.setIcon(checkmark);
                confirmar.setBackground(null);
                confirmar.setBorder(null);
                confirmar.addActionListener(e -> {
                    Organizador.modificarPendiente(descripcion, area.getText());
                    done.agregar(area.getText());
                    actualizarPaneles();
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
        JLabel puntaje;

        DonePanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            puntaje = new JLabel(Integer.toString(Organizador.realizados.size()));
            puntaje.setFont(new Font(fuente, Font.BOLD, 20));
            puntaje.setForeground(Color.white);
            actualizarPaneles();
        }

        private void actualizarPaneles() {
            this.removeAll();
            for (Pendiente pend : Organizador.realizados) {
                PendienteDone hecho = new PendienteDone(pend.getDescripcion());
                this.add(hecho);
                this.add(new JLabel(new ImageIcon("imagenes/medal.png")));
            }
            puntaje.setText(Integer.toString(Organizador.realizados.size()));
            this.add(puntaje);
            revalidate();
            repaint();
        }

        private void agregar(String desc) {
            Organizador.marcarCompletado(desc);
            actualizarPaneles();
        }

        private class PendienteDone extends JPanel implements MouseListener {
            final int WIDTH = 250;
            final int HEIGHT = 40;
            final int SIZE = 15;
            JLabel label;
            JTextArea area;
            JButton restaurar;

            PendienteDone(String descripcion) {
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setBackground(new Color(0xAFF478));

                label = new JLabel(descripcion, SwingConstants.CENTER);
                label.setFont(new Font(fuente, Font.PLAIN, SIZE));
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(WIDTH - 15, HEIGHT / 2));

                area = new JTextArea();
                area.setFont(new Font(fuente, Font.PLAIN, SIZE));
                area.setText(descripcion);
                area.setWrapStyleWord(true);
                area.setLineWrap(true);
                area.setEditable(false);
                area.setBackground(new Color(0xAFF478));
                area.setPreferredSize(new Dimension(220, 95));

                restaurar = new JButton(new ImageIcon("imagenes/refresh.png"));
                restaurar.setBackground(null);
                restaurar.setBorder(null);
                restaurar.addActionListener(e -> {
                    Organizador.marcarNoCompletado(area.getText());
                    actualizarPaneles();
                    task.actualizarPaneles();
                });

                this.addMouseListener(this);
                this.add(label);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT + 118));
                this.remove(label);
                this.add(area);
                this.add(restaurar);
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

    private class DeletedPanel extends JPanel {
        DeletedPanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setOpaque(false);
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            for (int i = 0; i < Organizador.eliminados.size(); i++) {
                String desc = Organizador.eliminados.get(i).getDescripcion();
                basura.add(new PendienteDeleted(desc));
            }
        }

        private void borrar(String desc) {
            Organizador.eliminarPendiente(desc);
            actualizarPaneles();
        }

        private void actualizarPaneles() {
            this.removeAll();
            for (Pendiente pend : Organizador.eliminados) {
                PendienteDeleted deleted = new PendienteDeleted(pend.getDescripcion());
                this.add(deleted);
            }
            revalidate();
            repaint();
        }

        private class PendienteDeleted extends JPanel implements MouseListener {
            final int WIDTH = 300;
            final int HEIGHT = 40;
            final int SIZE = 15;
            JLabel label;
            JTextArea area;
            JButton recuperar;
            JButton descartar;

            PendienteDeleted(String descripcion) {
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setBackground(new Color(0xAFF478));

                label = new JLabel(descripcion, SwingConstants.CENTER);
                label.setFont(new Font(fuente, Font.PLAIN, SIZE));
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(WIDTH - 15, HEIGHT / 2));

                area = new JTextArea();
                area.setFont(new Font(fuente, Font.PLAIN, SIZE));
                area.setText(descripcion);
                area.setWrapStyleWord(true);
                area.setLineWrap(true);
                area.setEditable(false);
                area.setBackground(new Color(0xAFF478));
                area.setPreferredSize(new Dimension(280, 95));

                recuperar = new JButton(new ImageIcon("imagenes/refresh.png"));
                recuperar.setBackground(null);
                recuperar.setBorder(null);
                recuperar.addActionListener(e -> {
                    Organizador.recuperarPendiente(area.getText());
                    actualizarPaneles();
                    task.actualizarPaneles();
                });

                descartar = new JButton(new ImageIcon("imagenes/close.png"));
                descartar.setBackground(null);
                descartar.setBorder(null);
                descartar.addActionListener(e -> {
                    Organizador.eliminarPermanente(area.getText());
                    actualizarPaneles();
                });

                this.add(label);
                this.addMouseListener(this);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT + 118));
                this.remove(label);
                this.add(area);
                this.add(recuperar);
                this.add(descartar);
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

    private class ConfigPanel extends JPanel {
        final int WIDTH = 320;
        final int HEIGHT = 50;
        JPanel custom;
        JLabel cambiarFuente;
        JTextField fuenteActual;

        ConfigPanel() {
            this.setBackground(new Color(0x27AE6A));
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

            custom = new JPanel();
            custom.setBackground(new Color(0xC2FC9E));
            // custom.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            custom.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

            cambiarFuente = new JLabel("Fuente");
            cambiarFuente.setFont(new Font(fuente, Font.PLAIN, 14));

            fuenteActual = new JTextField(fuente);
            fuenteActual.setFont(new Font(fuente, Font.PLAIN, 14));
            fuenteActual.setForeground(Color.gray);
            fuenteActual.setBackground(new Color(0xC2FC9E));

            custom.add(cambiarFuente);
            custom.add(fuenteActual);

            this.add(custom);
        }
    }

}
