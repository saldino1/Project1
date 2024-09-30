import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test SandwichShop methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Amelia Saldino
 */
public class SandwichShopTest {

    /**
     * Asserts that isValidTime returns true when time is 2:20
     */
    @Test
    public void testIsValidTimeAfternoonValid() {

        assertTrue(SandwichShop.isValidTime(2, 20), "SandwichShop.isValidTime(2, 20)");

    }

    /**
     * Asserts that isValidTime returns false with time 7:04
     */
    @Test
    public void testIsValidTimeEveningInvalid() {

        assertFalse(SandwichShop.isValidTime(7, 4), "SandwichShop.isValidTime(7, 4)");

    }

    /**
     * Asserts that isValidTime returns true with time 11:00
     */
    @Test
    public void testIsValidTimeMorningBorderValid() {
        
        assertTrue(SandwichShop.isValidTime(11, 0), "SandwichShop.isValidTime(11, 0)");
        
    }

    /**
     * Asserts that isValidTime returns false with time 10:59
     */
    @Test
    public void testIsValidTimeMorningBorderInvalid() {
        
        assertFalse(SandwichShop.isValidTime(10, 59), "SandwichShop.isValidTime(10, 59)");
        
    }

    /**
     * Asserts that isValidTime returns false with time 3:-05
     */
    @Test
    public void testIsValidTimeNegativeMinute() {
        
        assertFalse(SandwichShop.isValidTime(3, -5), "SandwichShop.isValidTime(3, -5)");

    }    
    
    /**
     * Asserts that isValidDate returns true with date 10/20
     */
    @Test
    public void testIsValidDateOctoberValid() {

        assertTrue(SandwichShop.isValidDate(10, 20), "SandwichShop.isValidDate(10, 20)");

    }

    /**
     * Asserts that isValidDate returns true with date 12/04
     */
    @Test
    public void testIsValidDateDecember() {

        assertTrue(SandwichShop.isValidDate(12, 4), "SandwichShop.isValidDate(12, 4)");

    }

    /**
     * Asserts that isValidDate returns false with date 10/02
     */
    @Test
    public void testIsValidDateOctoberInvalid() {
            
        assertFalse(SandwichShop.isValidDate(10, 2), "SandwichShop.isValidDate(10, 2)");

    }

    /**
     * Asserts that isValidDate returns true with date 12/31
     */
    @Test
    public void testIsValidDateDecemberBorderValid() {
        
        assertTrue(SandwichShop.isValidDate(12, 31), "SandwichShop.isValidDate(12, 31)");

    }

    /**
     * Asserts that isValidDate returns false with date 11/33
     */
    @Test
    public void testIsValidDateNovemberInvalidDay() {
        
        assertFalse(SandwichShop.isValidDate(11, 33), "SandwichShop.isValidDate(11, 33)");

    }    

    /**
     * Asserts that isWeekday returns true for date 12/05
     */
    @Test
    public void testIsWeekdayDecemberThursday() {

        assertTrue(SandwichShop.isWeekday(12, 5), "SandwichShop.isWeekday(12, 5)");

    }

    /**
     * Asserts that isWeekday returns false for date 10/26
     */
    @Test
    public void testIsWeekdayOctoberSaturday() {

        assertFalse(SandwichShop.isWeekday(10, 26), "SandwichShop.isWeekday(10, 26)");

    }

    /**
     * Asserts that isWeekday returns false for date 11/08
     */
    @Test
    public void testIsWeekdayNovemberFriday() {
            
        assertFalse(SandwichShop.isWeekday(11, 8), "SandwichShop.isWeekday(11, 8)");

    }

    /**
     * Asserts that isWeekday returns true for date 11/04
     */
    @Test
    public void testIsWeekdayNovemberMonday() {
        
        assertTrue(SandwichShop.isWeekday(11, 4), "SandwichShop.isWeekday(11, 4)"); 

    }

    /**
     * Asserts that isWeekday returns false for date 12/08
     */
    @Test
    public void testIsWeekdayDecemberSundayValid() {
        
        assertFalse(SandwichShop.isWeekday(12, 8), "SandwichShop.isWeekday(12, 8)");

    }    

    /**
     * Asserts that getOrderCost returns 525 with 1 chicken input
     */
    @Test
    public void testGetOrderCostOneChicken() {
        assertEquals(525, SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0),
                     "SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0)");

    }

    /**
     * Asserts that getOrderCost returns 1100 with 2 burger input
     */
    @Test
    public void testGetOrderCostTwoBurgers() {
            
        assertEquals(1100, SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0), 
                        "SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0)");

    }

    /**
     * Asserts that getOrderCost returns 645 with 1 veggie and 1 water input
     */
    @Test
    public void testGetOrderCostOneVeggieOneWater() {
        
        assertEquals(645, SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0), 
                        "SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0)");

    }

    /**
     * Asserts that getOrderCost returns 585 with 3 coffee input
     */
    @Test
    public void testGetOrderCostThreeCoffees() {
        
        assertEquals(585, SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0), 
                        "SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0)");
        
    }    


    /**
     * Asserts that getOrderCost returns 355 with 1 shake input
     */
    @Test
    public void testGetOrderCostOneShake() {
            
        assertEquals(355, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1), 
                        "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1)");
 
    }

    /**
     * Asserts that getOrderCost returns 0 with all 0 inputs
     */
    @Test
    public void testGetOrderCostNothing() {
        
        assertEquals(0, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0), 
                        "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0)");
 
    }

    /**
     * Asserts that getOrderCost returns 2270 with 1 of every input
     */
    @Test
    public void testGetOrderCostOneOfEverything() {
        
        assertEquals(2270, SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1), 
                        "SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1)");
 
    }    

    /**
     * Asserts that getPickupTime returns "6:25" with input of 10/23 at 6:05
     */
    @Test
    public void testGetPickupTimeWeekdayEvening() {
        assertEquals("6:25", SandwichShop.getPickupTime(10, 23, 6, 5),
                     "SandwichShop.getDeliveryTime(10, 23, 6, 5)");

    }

    /**
     * Asserts that getPickupTime returns "7:19" with input of 12/11 at 6:59
     */
    @Test
    public void testGetPickupTimeWeekdayLatestOrderTime() {
            
        assertEquals("7:19", SandwichShop.getPickupTime(12, 11, 6, 59), 
                        "SandwichShop.getPickupTime(12, 11, 6, 59)");

    }

    /**
     * Asserts that getPickupTime returns "1:00" with input of 12/14 at 12:30
     */
    @Test
    public void testGetPickupTimeWeekendTwelveThirtyOrderTime() {
        
        assertEquals("1:00", SandwichShop.getPickupTime(12, 14, 12, 30), 
                        "SandwichShop.getPickupTime(12, 14, 12, 30)");

    }

    /**
     * Asserts that getPickupTime returns "11:30" with input of 11/30 at 11:00
     */
    @Test
    public void testGetPickupTimeWeekendMorning() {
        
        assertEquals("11:30", SandwichShop.getPickupTime(11, 30, 11, 0), 
                        "SandwichShop.getPickupTime(11, 30, 11, 0)");
    }    


    /**
     * Asserts that getPickupTime returns "3:12" with input 11/26 at 2:52
     */
    @Test
    public void testGetPickupTimeWeekdayTwoFiftyTwoOrderTime() {
            
        assertEquals("3:12", SandwichShop.getPickupTime(11, 26, 2, 52), 
                        "SandwichShop.getPickupTime(11, 26, 2, 52)"); 

    }

    /**
     * Asserts that getPickupTime returns "7:00" with input of 10/26 at 6:30
     */
    @Test
    public void testGetPickupTimeWeekendSixThirtyOrderTime() {
        
        assertEquals("7:00", SandwichShop.getPickupTime(10, 26, 6, 30), 
                "SandwichShop.getPickupTime(10, 26, 6, 30)"); 

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