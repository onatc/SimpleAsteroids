import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Asteroids move randomly across the world. Waiting to 
 *  be destroyed.
 *  
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class Asteroid extends WrapMovements
{
    //~ Fields ................................................................
    
    /**
     * The speed of the asteroid.
     */
    public int speed;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Asteroid object.
     */
    public Asteroid()
    {
        /*# Do any work to initialize your class here. */
    }
    
    /**
     * Creates a new Asteroid object at a specified speed and
     * rotation.
     * 
     * @param aSpeed The speed of the asteroid.
     * @param rotation The rotation of the asteroid.
     */
    public Asteroid(int aSpeed, int rotation)
    {
        speed = aSpeed;
        this.turn(rotation);
    }

    //~ Methods ...............................................................
    
    /**
     * @return Returns the speed of the asteroid.
     */
    public int getSpeed()
    {
        return speed;
    }
    
    /**
     * This method determines what this actor
     * does every round.
     */
    public void act()
    {
        this.moveWrap(this.getSpeed());
        
        Bullet bullet = this.getOneIntersectingObject(Bullet.class);
        Ship ship = this.getOneIntersectingObject(Ship.class);
        if (ship != null)
        {
            this.remove();
            ship.remove();
        }
        
        if (bullet != null)
        {
            this.remove();
            bullet.remove();
        }
    }

   
}
