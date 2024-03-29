package mandel.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent
{
    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());
        g.setColor(Color.BLUE);
        g.fillOval((int) (projectile.getInterceptX() / 2) - 5, (int) (-projectile.getPeakY()) - 5, 10, 10);

        int x;
        int y;

        g.setColor(Color.BLACK);
        projectile.setSeconds(0);

        for (int i = 0; i <= (projectile.getApexTime() * 2) + 1; i++)
        {
            x = (int) projectile.getX();
            y = (int) projectile.getY();
            projectile.setSeconds(i);
            g.drawLine(x, -y, (int) projectile.getX(), (int) (-projectile.getY()));
        }
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //tells the operating system to call paintComponent() again
        repaint();
    }
}