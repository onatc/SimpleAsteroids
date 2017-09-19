import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  Test Bullet class.
 *
 *  @author onatc6
 *  @version 2016.04.28
 */
public class BulletTest extends TestCase
{
    //~ Fields ................................................................
    private Bullet bullet;
    private Space space;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new BulletTest test object.
     */
    public BulletTest()
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
        bullet = new Bullet();
        space = new Space(600, 600);
    }


    // ----------------------------------------------------------
    
    /**
     * Tests the constructor with parameters.
     */
    public void testConstructor()
    {
        bullet = new Bullet(50, 90);
        
        assertEquals(50, bullet.getSpeed());
        assertEquals(90.0, bullet.getRotation(), 0.01);
    }
    
    /**
     * Test moveUntilCollide() method when the bullet 
     * is at the left edge.
     */
    public void testMoveUntilCollide1()
    {
        space.add(bullet, 0, 50);
        bullet.moveUntilCollide();
        
        assertEquals(0, space.getObjects(Bullet.class).size());
    }
    
    /**
     * Test moveUntilCollide() method when the bullet 
     * is at the right edge.
     */
    public void testMoveUntilCollide2()
    {
        space.add(bullet, 600, 50);
        bullet.moveUntilCollide();
        
        assertEquals(0, space.getObjects(Bullet.class).size());
    }
    
    /**
     * Test moveUntilCollide() method when the bullet 
     * is at the upper edge.
     */
    public void testMoveUntilCollide3()
    {
        space.add(bullet, 50, 0);
        bullet.moveUntilCollide();
        
        assertEquals(0, space.getObjects(Bullet.class).size());
    }
    
    /**
     * Test moveUntilCollide() method when the bullet 
     * is at the lower edge.
     */
    public void testMoveUntilCollide4()
    {
        space.add(bullet, 50, 600);
        bullet.moveUntilCollide();
        
        assertEquals(0, space.getObjects(Bullet.class).size());
    }
    
    /**
     * Test moveUntilCollide() method when the bullet 
     * isn't at the left edge.
     */
    public void testMoveUntilCollide5()
    {
        space.add(bullet, 50, 50);
        
        run(space, 15);
        
        assertEquals(1, space.getObjects(Bullet.class).size());
    }

}
