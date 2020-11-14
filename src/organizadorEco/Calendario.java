package organizadorEco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Calendario extends JPanel implements ActionListener, ItemListener {
    static final String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final JLabel[] labelMeses;
    private final JLabel[] labelDias;
    private final JButton[] dias;
    private final JPanel panelMes, panelNomM;
    private final JComboBox<String> month;
    private String op = "";
    private int pos = 0;

    Calendario() {
        this.labelMeses = new JLabel[12];
        this.labelDias = new JLabel[7];
        this.dias = new JButton[31];
        this.month = new JComboBox<>();
        this.month.addActionListener(this);

        this.panelMes = new JPanel(new GridLayout(6, 7));
        this.panelMes.setBackground(new Color(0x27AE60));

        this.panelNomM = new JPanel(new BorderLayout());
        this.panelNomM.setBackground(new Color(0x27AE60));


        setLayout(null);
        setBackground(new Color(0x27AE60));

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        for(int x = 0; x < 12; ++x) {
            this.labelMeses[x] = new JLabel(mes[x] + " " + localDate.getYear());
            this.labelMeses[x].setFont(new Font("ComicSansMS", Font.BOLD, 14));
            this.labelMeses[x].setForeground(Color.BLACK);
            this.labelMeses[x].setPreferredSize(new Dimension(200, 30));
        }

        for(int n = 0; n < 7; ++n) {
            String[] days = {" DOM"," LUN"," MAR"," MIE"," JUE"," VIE"," SAB"};
            this.labelDias[n] = new JLabel(days[n]);
            this.labelDias[n].setFont(new Font("ComicSansMS", Font.BOLD, 14));
            this.labelDias[n].setForeground(Color.BLACK);
        }

        for(int d = 0; d < 31; ++d) {
            this.dias[d] = new JButton(String.valueOf(d+1));
            this.dias[d].setName(String.valueOf(d+1));
            this.dias[d].addActionListener(this);
            this.dias[d].setBorder(new BevelBorder(BevelBorder.RAISED));
            this.dias[d].setBackground(new Color(140, 246, 119));
            this.dias[d].setFont(new Font("ComicSansMS", Font.BOLD, 11));
            this.dias[d].setForeground(Color.BLACK);
        }

        for(int w = 0; w < 12; ++w) {
            this.month.addItem(mes[w]);
        }
        this.month.addItemListener(this);

        this.makeCalendar();
    }

    private void makeCalendar() {
        this.fillPanelNombreM();
        this.fillPanelMes();

        add(this.panelMes);
        add(this.panelNomM);
        add(this.month);

        this.panelNomM.setBounds(20, 30, 130, 30);
        this.panelMes.setBounds(20, 70, 300, 300);
        this.month.setBounds(160, 30, 150, 30);
    }

    private void fillPanelNombreM() {
        this.panelNomM.removeAll();

        for(int x = 0; x < 12; ++x) {
            if(this.op.equals(mes[x])) this.pos = x;
        }

        this.panelNomM.add(this.labelMeses[this.pos], BorderLayout.CENTER);
    }

    private void fillPanelMes() {
        this.panelMes.removeAll();

        for (JLabel x : this.labelDias) {
            this.panelMes.add(x);
        }

        if(this.pos == 1) {
            for(int p = 0; p < 28; ++p) {
                this.panelMes.add(this.dias[p]);
            }
        } else if(this.pos == 3 || this.pos == 5 || this.pos == 8 || this.pos == 10) {
            for(int p = 0; p < 30; ++p) {
                this.panelMes.add(this.dias[p]);
            }
        } else {
            for(int p = 0; p < 31; ++p) {
                this.panelMes.add(this.dias[p]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println(e.getActionCommand());

        this.remove(this.panelMes);
        this.remove(this.panelNomM);
        repaint();
        // System.out.println("SE eliminaron paneles");

        this.makeCalendar();

        repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == this.month) {
            this.op = (String) this.month.getSelectedItem();
        }
    }
}
