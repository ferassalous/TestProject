import static org.junit.Assert.*;
/** Testing Class for Player Class Object
 * @author Feras salous
 * 2018-09-15
 */

import org.junit.Test;

import junit.framework.Assert;

/**
 * Tests the Player Constructor
 * 
 *
 */
public class PlayerTest
{
    @Test
    public void testMyPlayer()
    {
        Player myPlayer = new Player("Feras Salous,6.00,180,OklahomaCity/Oklahoma");
        Assert.assertEquals("Feras Salous", myPlayer.getName());
        Assert.assertEquals(6.00, myPlayer.getHeight());
        Assert.assertEquals(180, myPlayer.getWeight());
        Assert.assertEquals("OklahomaCity", myPlayer.getHomeCity());
        Assert.assertEquals("Oklahoma", myPlayer.getHomeState());
    }

    @Test
    public void testPlayerToString()
    {
        Player myPlayer = new Player("Feras Salous,6.00,180,OklahomaCity/Oklahoma");
        String expected = "Name: Feras Salous, Height: 6.00 ft, Weight: 180 lbs, Home City: OklahomaCity, Home State: Oklahoma\n"
                .replaceAll("\\s", "");
        String actual = myPlayer.toString().replaceAll("\\s", "");
        Assert.assertEquals(expected, actual);

    }

}
