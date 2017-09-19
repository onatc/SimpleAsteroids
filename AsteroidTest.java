import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test Asteroids.
 *  
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class AsteroidTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;
    private Asteroid asteroid;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TestAsteroids test object.
     */
    public AsteroidTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        space = new Space(600, 600);
        asteroid = new Asteroid();
        asteroid.speed = 5;
    }


    // ----------------------------------------------------------
    /**
     * Test the constructor with parameters.
     */
    public void testConstructor()
    {
        asteroid = new Asteroid(10, 270);
        
        assertEquals(10, asteroid.getSpeed());
        assertEquals(270, asteroid.getRotation(), 0.01);
    }
    
    /**
     * Test act() method when there are no 
     * intersecting objects.
     */
    public void testAct1()
    {
        space.add(asteroid, 50, 50);
        asteroid.act();
        
        assertEquals(55, asteroid.getGridX());
        assertEquals(50, asteroid.getGridY());
        assertEquals(1, space.getObjects(Asteroid.class).size());
    }
    
    /**
     * Test act() method when the asteroid
     * intersects with a ship.
     */
    public void testAct2()
    {   
        Ship ship = new Ship();
        space.add(asteroid, 45, 50);
        space.add(ship, 50, 50);
        
        asteroid.act();
        
        assertEquals(50, asteroid.getGridX());
        assertEquals(50, asteroid.getGridY());
        assertEquals(0, space.getObjects(Asteroid.class).size());
        assertEquals(0, space.getObjects(Ship.class).size());
    }
    
    /**
     * Test act() method when the asteroid
     * intersects with a bullet.
     */
    public void testAct3()
    {
        Bullet bullet = new Bullet();
        space.add(asteroid, 45, 50);
        space.add(bullet, 50, 50);
        
        asteroid.act();
        
        assertEquals(50, asteroid.getGridX());
        assertEquals(50, asteroid.getGridY());
        assertEquals(0, space.getObjects(Asteroid.class).size());
        assertEquals(0, space.getObjects(Bullet.class).size());
    }

}
