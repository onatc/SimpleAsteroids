import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Bullets are shot from the ship.
 *  If they hit an asteroid, asteroid is destroyed.
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class Bullet extends Actor
{
    //~ Fields ................................................................
    private int bSpeed;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bullet object.
     */
    public Bullet()
    {
        /*# Do any work to initialize your class here. */
    }

    /**
     * Creates a new Bullet with a specified 
     * speed and rotation.
     * 
     * @param speed The speed of the bullet.
     * @param rotation The rotation of the bullet.
     */
    public Bullet(int speed, int rotation)
    {
        bSpeed = speed;
        this.turn(rotation);
    }
    
    //~ Methods ...............................................................
    
    /**
     * @return Returns the speed of the bullet.
     */
    public int getSpeed()
    {
        return bSpeed;
    }
    
    /**
     * Asteroid moves until hits any of the edges.
     */
    public void moveUntilCollide()
    {
        int width = this.getWorld().getWidth();
        int height = this.getWorld().getHeight();
        if (this.getGridX() == 0 || this.getGridX() == width - 1 
            || this.getGridY() == 0 || this.getGridY() == height - 1)
        {
            this.remove();
        }
        
        else
        {
            this.move(this.getSpeed());
        }
    }
    
    /**
     * This method determines what this actor
     * does every round.
     */
    public void act()
    {
        this.moveUntilCollide();
    }
}
