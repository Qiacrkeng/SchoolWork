import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class l2_2022_5_8 extends JFrame {
    l2_2022_5_8() {
        this.setBounds(200, 200, 300, 300);
        this.setVisible(true);

        this.setLayout(new GridLayout(3, 2));
        // µ¥Ñ¡¿ò
        JRadioButton c1 = new JRadioButton("²¤ÂÜ");
        JCheckBox c2 = new JCheckBox("²¤ÂÜ");
        JRadioButton c3 = new JRadioButton("²ÝÝ®");
        JCheckBox c4 = new JCheckBox("²ÝÝ®");
        JRadioButton c5 = new JRadioButton("ÆÏÌÑ");
        JCheckBox c6 = new JCheckBox("ÆÏÌÑ");

        this.add(c1);
        this.add(c2);
        this.add(c3);
        this.add(c4);
        this.add(c5);
        this.add(c6);

        ImageIcon boluo = new ImageIcon("./img/ÆÁÄ»½ØÍ¼ 2022-05-08 121904.jpg");
        ImageIcon caomei = new ImageIcon("./img/ÆÁÄ»½ØÍ¼ 2022-05-08 122010.jpg");
        ImageIcon putao = new ImageIcon("./img/ÆÁÄ»½ØÍ¼ 2022-05-08 122020.jpg");

        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c1.isSelected();
                if (!result) {
                    c1.setIcon(boluo);
                } else {
                    c1.setIcon(null);
                }
            }
        });
        c2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c2.isSelected();
                if (!result) {
                    c2.setIcon(boluo);
                } else {
                    c2.setIcon(null);
                }
            }
        });
        c3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c3.isSelected();
                if (!result) {
                    c3.setIcon(caomei);
                } else {
                    c3.setIcon(null);
                }
            }
        });
        c4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c4.isSelected();
                if (!result) {
                    c4.setIcon(caomei);
                } else {
                    c4.setIcon(null);
                }
            }
        });
        c5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c5.isSelected();
                if (!result) {
                    c5.setIcon(putao);
                } else {
                    c5.setIcon(null);
                }
            }
        });
        c6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean result = c6.isSelected();
                if (!result) {
                    c6.setIcon(putao);
                } else {
                    c6.setIcon(null);
                }
            }
        });
    }

    public static void main(String[] args) {
        new l2_2022_5_8();
    }
}
