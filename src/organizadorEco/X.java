package organizadorEco;

import javax.swing.*;
import java.awt.*;

public class X {
    public static void main(String [] arr) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame x = new JFrame("Priueba");
                x.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                x.setVisible(true);
                x.setSize(new Dimension(350, 600));
                x.getContentPane().setBackground(new Color(0x27AE60));
                x.setLayout(new BorderLayout(0, 0));
                x.setLocationRelativeTo(null);

                x.add(new Calendario(), BorderLayout.CENTER);
            }
        });


    }
}
