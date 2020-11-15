package organizadorEco;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;


public class Calendario extends JPanel implements ActionListener, ItemListener {
    static final String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    final String[] days = {"DOM", "LUN", "MAR", "MIE", "JUE", "VIE", "SAB"};
    JLabel[] labelDia;
    JLabel labelMes;
    JPanel panelMes;
    JButton[] dias;
    JComboBox<String> month;
    JComboBox<Integer> year;
    LocalDate hoy;

    Calendario() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setBackground(new Color(0x27AE60));

        panelMes = new JPanel();
        panelMes.setLayout(new GridLayout(0, 7, 5, 5));
        panelMes.setBackground(new Color(0x27AE60));

        labelMes = new JLabel();
        labelMes.setFont(new Font(GUI.fuente, Font.BOLD, 14));
        labelMes.setPreferredSize(new Dimension(200, 30));

        labelDia = new JLabel[7];
        for (int i = 0; i < 7; i++) {
            labelDia[i] = new JLabel(days[i], JLabel.CENTER);
            labelDia[i].setPreferredSize(new Dimension(35, 20));
        }

        month = new JComboBox<>(mes);

        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = 2020 + i;
        }

        year = new JComboBox<>(a);

        month.addActionListener(this);
        month.addItemListener(this);
        year.addActionListener(this);
        year.addItemListener(this);

        dias = new JButton[31];
        for (int d = 0; d < 31; ++d) {
            dias[d] = new JButton(String.valueOf(d + 1));
            dias[d].setName(String.valueOf(d + 1));
            dias[d].setBorder(null);
            dias[d].setBackground(new Color(140, 246, 119));
            dias[d].setPreferredSize(new Dimension(40, 40));
            dias[d].setFont(new Font(GUI.fuente, Font.PLAIN, 12));
            dias[d].addActionListener(this);
        }

        hoy = LocalDate.now();
        LocalDate primerDia = LocalDate.of(hoy.getYear(), hoy.getMonth(), 1);
        int diaSemana = primerDia.getDayOfWeek().getValue();
        System.out.println(diaSemana);
        int duracion = hoy.getMonth().length(hoy.isLeapYear());
        System.out.println(duracion);

        makeCalendar(duracion, diaSemana);
        month.setSelectedIndex(hoy.getMonthValue() - 1);
        year.setSelectedItem(hoy.getYear());

        this.add(month);
        this.add(year);
        this.add(panelMes);
    }

    private void makeCalendar(int duracion, int diaSemana) {
        panelMes.removeAll();
        for (JLabel label : labelDia) {
            panelMes.add(label);
        }

        if (diaSemana != 7) {
            for (int i = 0; i < diaSemana; i++) {
                JPanel dummy = new JPanel();
                dummy.setBackground(new Color(0x27AE60));
                panelMes.add(dummy);
            }
        }

        for (int d = 0; d < duracion; ++d) {
            panelMes.add(dias[d]);
        }
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == year || e.getSource() == month) {
            int y = (Integer)year.getSelectedItem();
            int m = month.getSelectedIndex() + 1;
            LocalDate primerDia = LocalDate.of(y, m, 1);
            int diaSemana = primerDia.getDayOfWeek().getValue();
            int duracion = primerDia.getMonth().length(primerDia.isLeapYear());
            System.out.println(diaSemana);
            System.out.println(duracion);
            makeCalendar(duracion, diaSemana);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
