import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Ship test.
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class ShipTest extends TestCase
{
    //~ Fields ................................................................
    private Ship ship;
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ShipTest test object.
     */
    public ShipTest()
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
        ship = new Ship();
        space = new Space(600, 600);
        space.add(ship, 50, 50);
    }


    // ----------------------------------------------------------
    
    /**
     * Test dpadNorthIsDown() method.
     */
    public void testDPadNorthIsDown()
    {
        
        ship.dpadNorthIsDown();
        
        assertEquals(1, ship.getSpeed());
        
    }
    
    /**
     * Test dpadEastIsDown() method when rotation
     * is larger than 360.
     */
    public void testDpadEastIsDown1()
    {
        ship.turn(100);
        
        ship.dpadEastIsDown();
        
        assertEquals(15, ship.getRotation(), 0.01);
    }
    
     /**
     * Test dpadEastIsDown() method when rotation
     * is smaller than 360.
     */
    public void testDpadEastIsDown2()
    {
        ship.dpadEastIsDown();
        
        assertEquals(275, ship.getRotation(), 0.01);
    }
    
     /**
     * Test dpadSouthIsDown() method when
     * speed is 0.
     */
    public void testDpadSouthIsDown1()
    {
        ship.dpadSouthIsDown();
        
        assertEquals(0, ship.getSpeed());
    }
    
    /**
     * Test dpadSouthIsDown() method when
     * speed is larger than 0.
     */
    public void testDpadSouthIsDown2()
    {
        ship.dpadNorthIsDown();
        ship.dpadNorthIsDown();
        
        ship.dpadSouthIsDown();
        
        assertEquals(1, ship.getSpeed());
    }
    
    /**
     * Test dpadWestIsDown() method when rotation
     * is 0.
     */
    public void testDpadWestIsDown1()
    {
        ship.turn(-270);
        
        ship.dpadWestIsDown();
        
        assertEquals(355, ship.getRotation(), 0.01);
    }
    
    /**
     * Test dpadWestIsDown() method when rotation
     * is larger than 0.
     */
    public void testDpadWestIsDown2()
    {
        ship.dpadWestIsDown();
        
        assertEquals(265, ship.getRotation(), 0.01);
    }
    
    /**
     * Test onScreenTouchDown() method.
     */
    public void testOnScreenTouchDown()
    {
        ship.onScreenTouchDown();
        Bullet bullet = ship.getOneIntersectingObject(Bullet.class);
        
        assertEquals(1, space.getObjects(Bullet.class).size());
        assertEquals(ship.getRotation(), bullet.getRotation(), 0.01);
        assertEquals(ship.getGridX(), bullet.getGridX());
        assertEquals(ship.getGridY(), bullet.getGridY());
    }
    
    /**
     * Test act() method.
     */
    public void testAct()
    {
        ship.dpadNorthIsDown();
        
        ship.act();
        
        assertEquals(50, ship.getGridX());
        assertEquals(49, ship.getGridY());
    }
}
