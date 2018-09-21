import org.junit.Assert;
import org.junit.Test;
import junit.framework.*;

/**
 * Testing class for the Zoo class
 * 
 * @author Feras Salous
 * @version 2018-09-14
 */
public class ZooTest
{
    /**
     * Test the empty constructor
     */
    @Test
    public void emptyConstructorTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        Assert.assertEquals(0, zoo.getTotalWeight(), 0.01);
        Assert.assertEquals(0, zoo.getAverageAge());
        Assert.assertEquals(0, zoo.getSize());
    }

    /**
     * Test adding an product to the zoo
     */
    @Test
    public void addAnimalTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        // TODO: Create animals to add to the zoo
        Animal a = new Animal("Rabbit", "Feras", 250.1, 22);
        Animal b = new Animal("Lion", "Julius", 200, 21);

        // TODO: Add the animals to the Inventory;
        zoo.addAnimal(a);
        zoo.addAnimal(b);

        // TODO: test that the number of animals added (currentIndex) is updated
        // correctly.
        Assert.assertEquals(2, zoo.getSize());

        /*
         * The animals should be in the array and in the order added above.
         */
        Assert.assertEquals(a, zoo.getAnimals()[0]);
        Assert.assertEquals(b, zoo.getAnimals()[1]);
    }

    /**
     * DUE TO HIGHER COMPLEXITY, THIS TEST IS GIVEN TO YOU. YOU SHOULD NOT MODIFY
     * IT.
     * 
     * Test the zoo's ability to expand and meet the need of having adequate space
     * to add more animals when needed.
     */
    @Test
    public void extendArrayAndGetSizeTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        /*
         * Attempt to force the animal array to expand. Fails when the array doesn't
         * realize it should get bigger and tries to add an product or when it tries to
         * insert an product in a non-existent position in the array,
         */
        try
        {
            for (int i = 0; i < 10; i++)
            {
                zoo.addAnimal(new Animal()); // Add empty Products to array
            }
        }
        catch (NullPointerException e) // Catch any point the array goes wrong
        {
            Assert.fail("The Product array attempted to access a non-existent " + "position in the product array.");
        }

        // Test the size of the new array
        Assert.assertEquals("Not all animals added as expected.", 10, zoo.getSize());
        Assert.assertEquals("animals array not expanded correctly.", 11, zoo.getAnimals().length);
    }

    /**
     * Tests the total weight calculation.
     */
    @Test
    public void getTotalWeightTest()
    {
        // TODO: set up zoo
        Zoo zoo = new Zoo();

        // TODO: Create at least 3 animals to add to the zoo
        Animal a = new Animal("Rabbit", "Feras", 250.1, 22);
        Animal b = new Animal("Lion", "Julius", 200.0, 21);
        Animal c = new Animal("Tiger", "Lion", 200.1, 21);

        // TODO: add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // TODO: test that sum of animal weights matches function return
        Assert.assertEquals(650.2, zoo.getTotalWeight(), 0.01);

    }

    /**
     * Tests the average age calculation.
     */
    @Test
    public void getAverageAgeTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();
        Animal a = new Animal("Rabbit", "Feras", 250.1, 22);
        Animal b = new Animal("Lion", "Julius", 200.0, 21);
        Animal c = new Animal("Tiger", "Lion", 200.1, 21);
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);
        Assert.assertEquals(21, zoo.getAverageAge(), 0.01);

    }

    /**
     * Tests the sum age for animals with a given name calculation.
     */
    @Test
    public void totalAgeWithNameTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();
        Animal a = new Animal("Rabbit", "Feras", 250.1, 22);
        Animal b = new Animal("Lion", "Julius", 200.0, 21);
        Animal c = new Animal("Tiger", "Julius", 200.1, 21);
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        Assert.assertEquals(42, zoo.totalAgeWithName("Julius"));

    }

    /**
     * Tests the number of animals for a species calculation
     */
    @Test
    public void numberAnimalsOfSpeciesTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();
        Animal a = new Animal("Tiger", "Feras", 250.1, 22);
        Animal b = new Animal("Tiger", "Julius", 200.0, 21);
        Animal c = new Animal("Tiger", "Julius", 200.1, 21);
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);
        Assert.assertEquals(3, zoo.numberAnimalsOfSpecies("Tiger"));

    }

    /**
     * Test the string representation of the Inventory
     */
    @Test
    public void zooToStringTest()
    {
        // TODO: set up the zoo
        Zoo zoo = new Zoo();

        // TODO: Create animals to add to the zoo
        Animal a = new Animal("Tiger", "Feras", 250.1, 22);
        Animal b = new Animal("Tiger", "Julius", 200.0, 21);
        Animal c = new Animal("Tiger", "Julius", 200.1, 21);

        // TODO: Add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);
        // TODO: Create the expected string
        String expected = "The following animals currently reside in the zoo: \n"
                + "Feras, a Tiger. 250.1 pounds, 22 years old\n" + "Julius, a Tiger. 200.0 pounds, 21 years old\n"
                + "Julius, a Tiger. 200.1 pounds, 21 years old\n";
        Assert.assertEquals(expected, zoo.toString());

        // TODO: Test the string output produced by toString
        Assert.assertEquals(expected, zoo.toString());
    }
}