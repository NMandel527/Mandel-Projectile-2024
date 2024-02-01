package mandel.projectile;

public class Projectile
{
    private double angle;
    private final double velocity;
    private final double radians;
    private double seconds;

    public Projectile(double angle, double velocity)
    {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds)
    {
        this.seconds = seconds;
    }

    public double getX()
    {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY()
    {
        return Math.sin(radians) * velocity * seconds - (0.5 * 9.8 * seconds * seconds);
    }

    /**
     * @return time when projectile is at its highest point
     */
    public double getApexTime()
    {
        return (velocity * Math.sin(radians))/9.8;
    }
}