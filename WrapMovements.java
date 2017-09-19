import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  A class that Asteroid and Ship classes extend in order
 *  for clearer code.
 *
 *  @author onatc6
 *  @version 2016.04.29
 */
public class WrapMovements extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WrapMovements object.
     */
    public WrapMovements()
    {
        /*# Do any work to initialize your class here. */
    }


    //~ Methods ...............................................................
    
    /**
     * Basically the move() method for actors but
     * if the actors reach to the end, they wrap around
     * and come over from the other side.
     * 
     * @param distance Distance to move.
     */
    public void moveWrap(int distance)
    {
        int width = this.getWorld().getWidth();
        int height = this.getWorld().getHeight();
        if (this.getGridX() == 0 && this.getRotationLeft())
        {
            this.setGridX(width);
        }
        
        if (this.getGridX() == width - 1 && !this.getRotationLeft())
        {
            this.setGridX(0);
        }
        
        if (this.getGridY() == 0 && this.getRotationUp())
        {
            this.setGridY(height);
        }
        
        if (this.getGridY() == height - 1 && !this.getRotationUp())
        {
            this.setGridY(0);
        }
        this.move(distance);
    }
    
    /**
     * @return Returns true if the actor is facing at least 1
     * degrees to the west.
     * 
     * Returns false if not.
     */
    public boolean getRotationLeft()
    {
        return this.getRotation() > 90 && this.getRotation() < 270;
    }
    
    /**
     * @return Returns true if the actor is facing at least 1
     * degrees to north.
     * 
     * Returns false if not.
     */
    public boolean getRotationUp()
    {
        return this.getRotation() > 180;
    }
    

}
