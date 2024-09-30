import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test SandwichShop methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author 
 */
public class SandwichShopTest {

    // TODO: Javadoc all methods to pass checkstyle tool. Reminder that magic numbers are allowed
    // in test program

    @Test
    public void testIsValidTimeAfternoonValid() {

        assertTrue(SandwichShop.isValidTime(2, 20), "SandwichShop.isValidTime(2, 20)");

    }

    @Test
    public void testIsValidTimeEveningInvalid() {

        assertFalse(SandwichShop.isValidTime(7, 4), "SandwichShop.isValidTime(7, 4)");

    }


    @Test
    public void testIsValidTimeMorningBorderValid() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertTrue(SandwichShop.isValidTime(11, 0), "SandwichShop.isValidTime(11, 0)");
        

    }

    @Test
    public void testIsValidTimeMorningBorderInvalid() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isValidTime(10, 59), "SandwichShop.isValidTime(10, 59)");
        

    }

    @Test
    public void testIsValidTimeNegativeMinute() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isValidTime(3, -5), "SandwichShop.isValidTime(3, -5)");

    }    
    

    @Test
    public void testIsValidDateOctoberValid() {

        assertTrue(SandwichShop.isValidDate(10, 20), "SandwichShop.isValidDate(10, 20)");

    }

    @Test
    public void testIsValidDateDecember() {

        assertTrue(SandwichShop.isValidDate(12, 4), "SandwichShop.isValidDate(12, 4)");

    }


    @Test
    public void testIsValidDateOctoberInvalid() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isValidDate(10, 2), "SandwichShop.isValidDate(10, 2)");

    }

    @Test
    public void testIsValidDateDecemberBorderValid() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertTrue(SandwichShop.isValidDate(12, 31), "SandwichShop.isValidDate(12, 31)");

    }

    @Test
    public void testIsValidDateNovemberInvalidDay() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isValidDate(11, 33), "SandwichShop.isValidDate(11, 33)");

    }    

    @Test
    public void testIsWeekdayDecemberThursday() {

        assertTrue(SandwichShop.isWeekday(12, 5), "SandwichShop.isWeekday(12, 5)");

    }

    @Test
    public void testIsWeekdayOctoberSaturday() {

        assertFalse(SandwichShop.isWeekday(10, 26), "SandwichShop.isWeekday(10, 26)");

    }


    @Test
    public void testIsWeekdayNovemberFriday() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isWeekday(11, 8), "SandwichShop.isWeekday(11, 8)");

    }

    @Test
    public void testIsWeekdayNovemberMonday() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertTrue(SandwichShop.isWeekday(11, 4), "SandwichShop.isWeekday(11, 4)"); 

    }

    @Test
    public void testIsWeekdayDecemberSundayValid() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertFalse(SandwichShop.isWeekday(12, 8), "SandwichShop.isWeekday(12, 8)");

    }    

    @Test
    public void testGetOrderCostOneChicken() {
        assertEquals(525, SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0),
                     "SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0)");

    }


    @Test
    public void testGetOrderCostTwoBurgers() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(1100, SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0), "SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0)");

    }

    @Test
    public void testGetOrderCostOneVeggieOneWater() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(645, SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0), "SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0)");

    }

    @Test
    public void testGetOrderCostThreeCoffees() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(585, SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0), "SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0)");
        

    }    


    @Test
    public void testGetOrderCostOneShake() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(355, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1), "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1)");
 

    }

    @Test
    public void testGetOrderCostNothing() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(0, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0), "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0)");
 

    }

    @Test
    public void testGetOrderCostOneOfEverything() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals(2270, SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1), "SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1)");
 

    }    

    @Test
    public void testGetPickupTimeWeekdayEvening() {
        assertEquals("6:25", SandwichShop.getPickupTime(10, 23, 6, 5),
                     "SandwichShop.getDeliveryTime(10, 23, 6, 5)");

    }


    @Test
    public void testGetPickupTimeWeekdayLatestOrderTime() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals("7:19", SandwichShop.getPickupTime(12, 11, 6, 59), "SandwichShop.getPickupTime(12, 11, 6, 59)");

    }

    @Test
    public void testGetPickupTimeWeekendTwelveThirtyOrderTime() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals("1:00", SandwichShop.getPickupTime(12, 14, 12, 30), "SandwichShop.getPickupTime(12, 14, 12, 30)");

    }

    @Test
    public void testGetPickupTimeWeekendMorning() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals("11:30", SandwichShop.getPickupTime(11, 30, 11, 0), "SandwichShop.getPickupTime(11, 30, 11, 0)");
    }    


    @Test
    public void testGetPickupTimeWeekdayTwoFiftyTwoOrderTime() {
            
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals("3:12", SandwichShop.getPickupTime(11, 26, 2, 52), "SandwichShop.getPickupTime(11, 26, 2, 52)"); 

    }

    @Test
    public void testGetPickupTimeWeekendSixThirtyOrderTime() {
        
    // TODO: Replace the below code with an appropriate assert statement 
        assertEquals("7:00", SandwichShop.getPickupTime(10, 26, 6, 30), "SandwichShop.getPickupTime(10, 26, 6, 30)"); 

    }


    /**
     * Test the SandwichShop methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.isWeekday(2, 27),
                                 "SandwichShop.isWeekday(2, 27)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.isWeekday(2, 27) - " +
                     "exception message");
        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1),
                                           "SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1) - " +
                     "exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(1, 15, 3, 20),
                                 "SandwichShop.getPickupTime(1, 15, 3, 20)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(1, 15, 3, 20) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(11, 10, 8, 30),
                                 "SandwichShop.getPickupTime(11, 10, 8, 30)");
        assertEquals("Invalid time", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(11, 10, 8, 30) - " +
                     "exception message");


    }
}