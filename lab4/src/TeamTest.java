import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testing Class for Team Class.
 * 
 * @author Feras Salous
 * @version 2018-09-14
 */
public class TeamTest
{
    /**
     * THIS TEST IS GIVEN TO YOU AS A REFERENCE.
     * 
     * Test that the Team sums the weight correctly. Reading is implicitly tested.
     * 
     * @throws IOException
     */
    @Test
    public void testTotalHeight() throws IOException
    {
        Team team = new Team("InputOfficial.csv");
        double expectedOutput = 29.8331;
        double output = team.computeTotalHeight();

        Assert.assertEquals("Team height incorrectly summed", expectedOutput, output, 0.001);
    }

    /**
     * Test that the Team finds the lightest player correctly. Reading is implicitly
     * tested.
     * 
     * @throws IOException
     */
    @Test
    public void testLightestPlayer() throws IOException
    {
        Team team = new Team("InputOfficial.csv");
        String Expected = "Marquise Brown";
        String actual = team.lightestPlayer().getName();
        Assert.assertEquals(Expected, actual);

        // Assert.assertEquals("Marquise Brown", team.lightestPlayer().getName());

        // TODO: test that the lightest player is found.
    }

    /**
     * Test that the Team determines if any player is from a city with a given city
     * name correctly.
     * 
     * @throws IOException
     */
    @Test
    public void testAnyPlayersFromCityName() throws IOException
    {
        Team team = new Team("InputOfficial.csv");

        // TOOD: choose a city name for which a player exists and one for which a player
        // does not exist. Test that
        // these yeild the correct result.
        Assert.assertTrue(team.anyPlayersFromCityName("Allen"));
        Assert.assertFalse(team.anyPlayersFromCityName("Oklahoma Shiity"));

    }

    /**
     * Test that the Team writes out information (toStrings) about the players
     * correctly. Reading is implicitly tested.
     * 
     * @throws IOException
     */
    @Test
    public void testWritePlayers() throws IOException
    {
        // Satisfy coverage tools:
        Team handlesException = new Team("notthere.csv");

        // Read in team and write out info:
        Team team = new Team("InputOfficial.csv");
        String outputFileName = "testWritePlayers.txt";
        team.writePlayers(outputFileName);

        // Build the expected string:
        String expected = "Name: Kyler Murray, Height: 5.83 ft, Weight: 195 lbs, Home City: Allen, Home State: Texas\n"
                + "Name: Rodney Anderson, Height: 6.08 ft, Weight: 220 lbs, Home City: Katy, Home State: Texas\n"
                + "Name: Robert Barnes, Height: 6.17 ft, Weight: 207 lbs, Home City: Southlake, Home State: Texas\n"
                + "Name: Kennedy Brooks, Height: 5.92 ft, Weight: 205 lbs, Home City: Mansfield, Home State: Texas\n"
                + "Name: Marquise Brown, Height:5.83 ft, Weight : 168 lbs, Home City: Hollywood, Home State: Florida";
        // TODO: add the players' toString to the expected String.
        expected = formatForTests(expected); // This line handles some quirks with newlines and bufferedreaders.

        // Read the string from the newly created file:
        BufferedReader br = new BufferedReader(new FileReader(outputFileName));
        String actual = "";
        String line = null;
        do
        {
            line = br.readLine();
            if (line != null)
            {
                actual += line;
            }
        }
        while (line != null);
        br.close();
        actual = formatForTests(actual);

        // Check the result:
        Assert.assertEquals("Writing to file without a given state incorrect.", expected, actual);
    }

    /**
     * Test that the Team writes out information (toStrings) about the players
     * correctly (only those who come from a specified state). Reading is implicitly
     * tested.
     * 
     * @throws IOException
     */
    @Test
    public void testWritePlayersWithState() throws IOException
    {
        // Read in team and write out info:
        Team team = new Team("InputOfficial.csv");
        String outputFileName = "testWritePlayers.txt";
        team.writePlayers(outputFileName, "Texas");

        // Build the expected string:
        String expected = "Name: Kyler Murray, Height: 5.83 ft, Weight: 195 lbs, Home City: Allen, Home State: Texas\n"
                + "Name: Rodney Anderson, Height: 6.08 ft, Weight: 220 lbs, Home City: Katy, Home State: Texas\n"
                + "Name: Robert Barnes, Height: 6.17 ft, Weight: 207 lbs, Home City: Southlake, Home State: Texas\n"
                + "Name: Kennedy Brooks, Height: 5.92 ft, Weight: 205 lbs, Home City: Mansfield, Home State: Texas";
        // TODO: get the sublist of players to be written out; add their toStrings to
        // the expected String.
        expected = formatForTests(expected); // This line handles some quirks with newlines and bufferedreaders.

        // Read the string from the newly created file:
        BufferedReader br = new BufferedReader(new FileReader(outputFileName));
        String actual = "";
        String line = null;
        do
        {
            line = br.readLine();
            if (line != null)
            {
                actual += line;
            }
        }
        while (line != null);
        br.close();
        actual = formatForTests(actual);

        // Check the result:
        Assert.assertEquals("Writing to file with a given state incorrect.", expected, actual);
    }

    /**
     * Test that the Team writes out statistics correctly. Reading is implicitly
     * tested.
     * 
     * @throws IOException
     */
    @Test
    public void testWriteStatistics() throws IOException
    {
        // Read in team and write out info:
        Team team = new Team("InputOfficial.csv");
        String outputFileName = "testWriteStats.txt";
        team.writeStatistics(outputFileName);

        // Build the expected string:
        String expected = "Total Height: 29.8331\n" + "Lightest Player: Marquise Brown\n";
        // TODO: create expected String that writeStatistics should write to the file.
        expected = formatForTests(expected); // This line handles some quirks with newlines and bufferedreaders.

        // Read the string from the newly created file:
        BufferedReader br = new BufferedReader(new FileReader(outputFileName));
        String actual = "";
        String line = null;
        do
        {
            line = br.readLine();
            if (line != null)
            {
                actual += line;
            }
        }
        while (line != null);
        br.close();
        actual = formatForTests(actual);

        // Check the result:
        Assert.assertEquals("File Writing outputs (statistics) are not the same", expected, actual);
    }

    /**
     * Function used to make our tests more tolerant to slight deviations in the
     * student's code. Removes whitespace characters and sets everything to
     * lowercase.
     * 
     * @param in
     *            The String to be formatted
     * @return The input string with whitespaces removed and converted to lowercase
     */
    private static String formatForTests(String in)
    {
        in = in.toLowerCase();
        in = in.replaceAll("[\\s]", "");
        return in;
    }
}
