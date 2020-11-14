package organizadorEco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("ALL")
public class GUI {
    JFrame frame;
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
    Calendario calendar;

    public GUI() {
    	//Rectangulo de la aplicación
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 600);
        frame.setTitle("Organizador");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(null);

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
        calendar = new Calendario();
        principal.add(task, "task");
        principal.add(done, "done");
        principal.add(deleted, "deleted");
        principal.add(settings, "settings");
        principal.add(calendar, "calendar");
        pantallas.show(principal, "task");

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
        hechos.addActionListener(e -> pantallas.show(principal, "done"));

        //Calendari0
        calendario = new JButton();
        calendario.setIcon(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(e -> {});

        home = new JButton();
        home.setIcon(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);

        calendario = new JButton(new ImageIcon("imagenes/calendar.png"));
        calendario.setBackground(null);
        calendario.setBorder(null);
        calendario.addActionListener(e -> pantallas.show(principal, "calendar"));
        
        home = new JButton(new ImageIcon("imagenes/home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.addActionListener(e -> pantallas.show(principal, "task"));

        basura = new JButton(new ImageIcon("imagenes/trash.png"));
        basura.setBackground(null);
        basura.setBorder(null);
        basura.addActionListener(e -> pantallas.show(principal, "deleted"));

        config = new JButton(new ImageIcon("imagenes/gear.png"));
        config.setBackground(null);
        config.setBorder(null);
        config.addActionListener(e -> pantallas.show(principal, "settings"));

        JButton[] imagenes = {hechos, calendario, home, basura, config};
        //Adicion de los botones al footer
        for (JButton imagen : imagenes) {
           footer.add(imagen);
        }

        //Adición de los elementos al frame
        frame.add(principal, BorderLayout.CENTER);
        frame.add(header, BorderLayout.NORTH);
        frame.add(footer, BorderLayout.SOUTH);
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
                String texto = pend.getDescripcion();
                int a = pend.getYear();
                int m = pend.getMonth();
                int d = pend.getDay();
                PendientePanel panel = new PendientePanel(texto, a, m, d);
                this.add(panel);
            }
            this.add(addOne);
            revalidate();
            repaint();
        }

        private class PendientePanel extends JPanel implements MouseListener, ItemListener {
            final int WIDTH = 300;
            final int HEIGHT = 40;
            final int SIZE = 15;
            int day, month, year;
            JLabel label;
            JTextArea area;
            JButton eliminar;
            JButton confirmar;
            JButton guardar;
            JComboBox<Integer> days;
            JComboBox<Integer> months;
            JComboBox<Integer> years;

            PendientePanel(String descripcion, int a, int m, int d) {
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                this.setBackground(new Color(0xAFF478));

                this.days = new JComboBox<>();
                this.months = new JComboBox<>();
                this.years = new JComboBox<>();
                for (int i = 1; i <= 31; i++) {
                    if (i <= 12) this.months.addItem(i);
                    if (i <= 10) this.years.addItem((2019 + i));
                    this.days.addItem(i);
                }
                this.days.addItemListener(this);
                this.months.addItemListener(this);
                this.years.addItemListener(this);

                day = d;
                month = m;
                year = a;

                days.setSelectedItem(day);
                months.setSelectedItem(month);
                years.setSelectedItem(year);

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
                    Organizador.modificarPendiente(descripcion, area.getText(), year, month, day);
                    deleted.borrar(area.getText());
                    actualizarPaneles();
                });

                confirmar = new JButton();
                ImageIcon checkmark = new ImageIcon("imagenes/checkmark.png");
                confirmar.setIcon(checkmark);
                confirmar.setBackground(null);
                confirmar.setBorder(null);
                confirmar.addActionListener(e -> {
                    Organizador.modificarPendiente(descripcion, area.getText(), year, month, day);
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
                    this.remove(days);
                    this.remove(months);
                    this.remove(years);
                    this.remove(confirmar);
                    this.remove(eliminar);
                    this.remove(guardar);
                    this.add(label);
                    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
                    label.setText(area.getText());
                    Organizador.modificarPendiente(descripcion, area.getText(), year, month, day);
                    revalidate();
                    repaint();
                });

                this.add(label);
                this.addMouseListener(this);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.setPreferredSize(new Dimension(WIDTH, HEIGHT + 155));
                this.remove(label);
                this.add(area);
                this.add(days);
                this.add(months);
                this.add(years);
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

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == this.days) this.day = (Integer) this.days.getSelectedItem();
                if (e.getSource() == this.months) this.month = (Integer)this.months.getSelectedItem();
                if (e.getSource() == this.years) this.year = (Integer)this.years.getSelectedItem();
            }
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
                PendienteDone hecho = new PendienteDone(pend.getDescripcion(), pend.getFecha());
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
            JLabel date;
            JTextArea area;
            JButton restaurar;

            PendienteDone(String descripcion, String fecha) {
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

                date = new JLabel(fecha, SwingConstants.CENTER);
                date.setFont(new Font(fuente, Font.PLAIN, SIZE));
                date.setVerticalAlignment(SwingConstants.CENTER);

                restaurar = new JButton(new ImageIcon("imagenes/refresh.png"));
                restaurar.setBackground(null);
                restaurar.setBorder(null);
                restaurar.addActionListener(e -> {
                    Organizador.marcarNoCompletado(descripcion);
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
                this.add(date);
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
                String fecha = Organizador.eliminados.get(i).getFecha();
                basura.add(new PendienteDeleted(desc, fecha));
            }
        }

        private void borrar(String desc) {
            Organizador.eliminarPendiente(desc);
            actualizarPaneles();
        }

        private void actualizarPaneles() {
            this.removeAll();
            for (Pendiente pend : Organizador.eliminados) {
                PendienteDeleted deleted = new PendienteDeleted(
                        pend.getDescripcion(),
                        pend.getFecha());
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
            JLabel date;
            JTextArea area;
            JButton recuperar;
            JButton descartar;

            PendienteDeleted(String descripcion, String fecha) {
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
                area.setPreferredSize(new Dimension(280, 95));

                date = new JLabel(fecha);
                date.setFont(new Font(fuente, Font.PLAIN, SIZE));
                date.setVerticalAlignment(SwingConstants.CENTER);
                date.setBackground(new Color(0xF8DB15));

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
                this.add(date);
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
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

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
