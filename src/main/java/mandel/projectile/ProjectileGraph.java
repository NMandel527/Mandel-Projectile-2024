package mandel.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent
{
    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0,0, getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i <= getWidth(); i += 30) {
            g.drawLine(i, 0, i, getHeight());
        }

        for (int i = 0; i <= getHeight(); i += 30) {
            g.drawLine(0, i, getWidth(), i);
        }

        g.setColor(Color.BLACK);
        g.drawLine(0, getHeight() - 30, getWidth(), getHeight() - 30);
        g.drawLine(30, 0, 30, getHeight());


        g.translate(30, getHeight() - 30);
        g.setColor(Color.BLUE);
        g.fillOval((int) (projectile.getInterceptX() / 2) - 5, (int) (-projectile.getPeakY()) - 5, 10, 10);
        g.drawString("(" + FORMAT.format(projectile.getInterceptX() / 2) + ", " + (FORMAT.format(projectile.getPeakY()) + ")"),
                (int) (projectile.getInterceptX() / 2) - 30, (int) (-projectile.getPeakY()) - 10);

        Projectile copy = new Projectile(projectile);
        g.setColor(Color.RED);
        double copyX = copy.getX();
        double copyY = copy.getY();
        g.fillOval((int)(copyX) - 5, (int)(-copyY) - 5, 10, 10);
        g.drawString("(" + FORMAT.format(copyX) + ", " + (FORMAT.format(copyY) + ")"),
                (int) copyX - 30, (int)-copyY - 10);

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