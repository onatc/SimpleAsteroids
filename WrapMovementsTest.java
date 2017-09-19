import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  WrapMovements test class.
 *
 *  @author onatc6
 *  @version 2016.04.29
 */
public class WrapMovementsTest extends TestCase
{
    //~ Fields ................................................................
    
    private Ship ship;
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WrapMovementsTest test object.
     */
    public WrapMovementsTest()
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
        ship = new Ship();
        
    }


    // ----------------------------------------------------------
    
    /**
     * Test getRotationLeft() when it returns true.
     */
    public void testGetRotationLeft1()
    {
        space.add(ship, 300, 300);
        
        ship.turn(-90);
        
        assertTrue(ship.getRotationLeft());
    }
    
    /**
     * Test getRotationLeft() when the rotation is 
     * smaller than 90.
     */
    public void testGetRotationLeft2()
    {
        space.add(ship, 300, 300);
        
        ship.turn(-200);
        
        assertFalse(ship.getRotationLeft());
    }
    
    /**
     * Test getRotationLeft() when the rotation is
     * larger than 270.
     */
    public void testGetRotationLeft3()
    {
        space.add(ship, 300, 300);
        
        ship.turn(50);
        
        assertFalse(ship.getRotationLeft());
    }
    
    /**
     * Test getRotationUp() when rotation is
     * larger than 180.
     */
    public void testGetRotationUp1()
    {
        space.add(ship, 300, 300);
        
        
        assertTrue(ship.getRotationUp());
    }
    
    /**
     * Test getRotationUp() when rotation is
     * smaller than 180.
     */
    public void testGetRotationUp2()
    {
        space.add(ship, 300, 300);
        
        ship.turn(-100);
        
        assertFalse(ship.getRotationUp());
    }
    
    /**
     * Test moveWrap() when x-coordinate is 0
     * and rotation is between 90 and 270.
     */
    public void testMoveWrap1()
    {
        space.add(ship, 0, 300);
        
        ship.turn(-90);
        ship.moveWrap(0);
        
        assertEquals(599, ship.getGridX());
    }
    
    /**
     * Test moveWrap() when x-coordinate is 0
     * and rotation isn't smaller than 270.
     */
    public void testMoveWrap2()
    {
        space.add(ship, 0, 300);
        
        ship.moveWrap(5);
        
        assertEquals(0, ship.getGridX());
        assertEquals(295, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when x-coordinate isn't 0
     * and rotation is between 90 and 270.
     */
    public void testMoveWrap3()
    {
        space.add(ship, 200, 300);
        
        ship.turn(-90);
        ship.moveWrap(5);
        
        assertEquals(195, ship.getGridX());
        assertEquals(300, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when x-coordinate is width - 1
     * and rotation isn't in between 90 and 270.
     */
    public void testMoveWrap4()
    {
        space.add(ship, 599, 300);
        
        ship.moveWrap(0);
        
        assertEquals(0, ship.getGridX());
        assertEquals(300, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when x-coordinate is width - 1
     * and rotation is between 90 and 270.
     */
    public void testMoveWrap5()
    {
        space.add(ship, 599, 300);
        
        ship.turn(-90);
        ship.moveWrap(5);
        
        assertEquals(594, ship.getGridX());
        assertEquals(300, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when y-coordinate is 0
     * and rotation is larger than 180.
     */
    public void testMoveWrap6()
    {
        space.add(ship, 200, 0);
        
        ship.moveWrap(0);
        
        assertEquals(200, ship.getGridX());
        assertEquals(599, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when y-coordinate is 0
     * and rotation is smaller than 180.
     */
    public void testMoveWrap7()
    {
        space.add(ship, 200, 0);
        
        ship.turn(-180);
        ship.moveWrap(5);
        
        assertEquals(200, ship.getGridX());
        assertEquals(5, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when y-coordinate is height - 1
     * and rotation is smaller than 180.
     */
    public void testMoveWrap8()
    {
        space.add(ship, 200, 599);
        
        ship.turn(-180);
        ship.moveWrap(0);
        
        assertEquals(200, ship.getGridX());
        assertEquals(0, ship.getGridY());
    }
    
    /**
     * Test moveWrap() when y-coordinate is height - 1
     * and rotation is larger than 180.
     */
    public void testMoveWrap9()
    {
        space.add(ship, 200, 599);
        
        ship.moveWrap(5);
        
        assertEquals(200, ship.getGridX());
        assertEquals(594, ship.getGridY());
    }

}
