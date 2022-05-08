
import java.awt.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class l1_2022_5_7 extends JFrame {
    l1_2022_5_7() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton zuoyi = new JButton("×óÒÆ");
        JButton youyi = new JButton("ÓÒÒÆ");
        JButton fangda = new JButton("Í¼Æ¬·Å´ó");
        panel.add(zuoyi);
        panel.add(youyi);
        panel.add(fangda);

        JButton youxiaqu = new JButton("smaller");
        ImageIcon youxiatupian = new ImageIcon(".\\img\\ÆÁÄ»½ØÍ¼ 2022-05-08 095417.jpg");
        youxiaqu.setIcon(youxiatupian);
        panel.add(youxiaqu);
        youxiaqu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ImageIcon l1 = new ImageIcon(".\\img\\ÆÁÄ»½ØÍ¼ 2022-05-08 091921.jpg");
                youxiaqu.setIcon(l1);
            }

            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ImageIcon youxiatupian = new ImageIcon(".\\img\\ÆÁÄ»½ØÍ¼ 2022-05-08 095417.jpg");
                youxiaqu.setIcon(youxiatupian);
            }
        });

        this.add(panel, BorderLayout.SOUTH);
        this.setSize(300, 300);
        this.setVisible(true);

        JTextArea string = new JTextArea("DEMO");
        string.setSize(39, 20);
        this.add(string);

        zuoyi.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                string.setLocation(string.getX() - 10, string.getY());
            }
        });
        youyi.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                string.setLocation(string.getX() + 10, string.getY());
            }
        });

        JLabel imgDiv = new JLabel();
        ImageIcon img = new ImageIcon(".\\img\\ÆÁÄ»½ØÍ¼ 2022-05-08 091921.jpg");
        Image image = img.getImage();
        image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT); // ×ÔÊÊÓ¦Ëõ·Å
        img.setImage(image);
        imgDiv.setIcon(img);
        imgDiv.setSize(100, 100);

        this.add(imgDiv, BorderLayout.CENTER);

        fangda.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int width = img.getIconWidth() + 10, height = img.getIconHeight() + 10;

                Image image = img.getImage();
                image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT); // ×ÔÊÊÓ¦Ëõ·Å
                img.setImage(image);
                imgDiv.setIcon(img);
                imgDiv.setSize(width, height);
            }
        });
    }

    public static void main(String[] args) {
        new l1_2022_5_7();
    }

}
