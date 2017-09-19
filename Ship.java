import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  Ship class is user controlled.
 *  Moves and shoots asteroids.
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class Ship extends WrapMovements
{
    //~ Fields ................................................................
    private int sSpeed;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ship object.
     */
    public Ship()
    {
        sSpeed = 0;
        this.turn(270);
    }


    //~ Methods ...............................................................
    
    /**
     * This method determines what this actor
     * does every round.
     */
    public void act()
    {
        this.moveWrap(this.getSpeed());
    }
    
    /**
     * @return Returns the speed of the ship.
     */
    public int getSpeed()
    {
        return sSpeed;
    }
    
    /**
     * Increases the speed of the ship by one.
     */
    public void dpadNorthIsDown()
    {
        sSpeed++;
    }
    
    /**
     * Turns the ship 5 degrees to east.
     */
    public void dpadEastIsDown()
    {
        if (this.getRotation() < 360)
        {
            this.turn(5);
        }
        
        else
        {
            this.turn(-360);
            this.turn(5);
        }
    }
    
    /**
     * Decreases the speed of the ship by one.
     */
    public void dpadSouthIsDown()
    {
        if (sSpeed > 0)
        {
            sSpeed--;
        }
    }
    
    /**
     * Turns the ship 5 degrees to west.
     */
    public void dpadWestIsDown()
    {
        if (this.getRotation() > 0)
        {
            this.turn(-5);
        }
        
        else
        {
            this.turn(360);
            this.turn(-5);
        }
    }
    
    /**
     * Creates a bullet at the same location
     * the ship has with the same rotation.
     */
    public void onScreenTouchDown()
    {
        int rotation = (int)this.getRotation();
        Bullet bullet = new Bullet(10, rotation);
        int valuex = this.getGridX();
        int valuey = this.getGridY();
        this.getWorld().add(bullet, valuex, valuey);
        
    }
}
