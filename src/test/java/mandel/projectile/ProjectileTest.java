package mandel.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectileTest {
    @Test
    public void getX() {
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);

        double actual = projectile.getX();

        assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);

        double actual = projectile.getY();

        assertEquals(-7.90, actual, 0.01);
    }

    @Test
    public void getApexTime() {
        Projectile projectile = new Projectile(31, 20);

        double actual = projectile.getApexTime();

        assertEquals(1.05, actual, 0.01);
    }

    @Test
    public void getPeakY() {
        Projectile projectile = new Projectile(31, 65);

        double actual = projectile.getPeakY();

        assertEquals(57.18, actual, 0.01);
    }

    @Test
    public void getInterceptX() {
        Projectile projectile = new Projectile(31, 65);

        double actual = projectile.getInterceptX();

        assertEquals(380.65, actual, 0.01);
    }
}