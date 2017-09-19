import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Space test. 
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class SpaceTest extends TestCase
{
    //~ Fields ................................................................
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SpaceTest test object.
     */
    public SpaceTest()
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
    }


    // ----------------------------------------------------------
    
    /**
     * Tests the default constructor while also
     * testing populate() method.
     */
    public void testConstructor()
    {
        space = new Space();
        
        assertEquals(800, space.getHeight());
        assertEquals(800, space.getWidth());
        assertEquals(5, space.getObjects(Asteroid.class).size());
        assertEquals(1, space.getObjects(Ship.class).size());
    }
    

}
