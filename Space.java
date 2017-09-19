import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  Our world for the asteroids game. 
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class Space extends World
{
    //~ Fields ................................................................

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Space object.
     */
    public Space()
    {
        super(800, 800, 1);
        this.populate();
    }
    
    /**
     * Creates a new Space object with a
     * specified width and height.
     * 
     * @param width Width of the object.
     * @param height Height of the object.
     */
    public Space(int width, int height)
    {
        super(width, height, 1);
    }

    //~ Methods ...............................................................
    
    /**
     * Adds a new ship at the middle of the world and
     * adds 5 randomly placed asteroids with random
     * rotations and speeds.
     */
    public void populate()
    {
        Ship ship = new Ship();
        this.add(ship, this.getWidth() / 2, this.getHeight() / 2);
        
        for (int i = 0; i < 5; i++)
        {
            Asteroid asteroid = new Asteroid();
            this.add(asteroid,
                Random.generator().nextInt(this.getWidth()),
                Random.generator().nextInt(this.getHeight()));
            asteroid.turn(Random.generator().nextInt(360));
            asteroid.speed = Random.generator().nextInt(5) + 1;
        }
    }

}
