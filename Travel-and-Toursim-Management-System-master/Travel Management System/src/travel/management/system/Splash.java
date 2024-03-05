package travel.management.system;
import travel.management.system.Login;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash {
    public static void main(String[] args) {

        SplashFrame f1 = new SplashFrame();
        f1.setVisible(true);
        int i;
        int x=1;
        for (i = 2; i <= 800; i += 10, x += 7) {
            int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
            int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

            int frameWidth = i + x;
            int frameHeight = i;

            int frameX = (screenWidth - frameWidth) / 2;
            int frameY = (screenHeight - frameHeight) / 2;

            f1.setSize(frameWidth, frameHeight);
            f1.setLocation(frameX, frameY);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

class SplashFrame extends JFrame implements Runnable {
    Thread t1;

    SplashFrame() {
        setLayout(new BorderLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/splash.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1450, 850, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        JLabel l1 = new JLabel(i2);
        add(l1);

        setUndecorated(true);
        pack(); // Pack the frame to its preferred size

        // Center the frame on the screen
        setLocationRelativeTo(null);

        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            this.setVisible(false);

            Login l = new Login();
            l.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
