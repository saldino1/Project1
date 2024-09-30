import java.util.Scanner;

/**
 * The SandwichShop class maintains information about the 
 * operating hours, pricing and average delivery time of a sandwich shop
 * @author Amelia Saldino
 */


public class SandwichShop {
    /**Constant storing the month number of october */
    public static final int OCTOBER = 10;

    /**Constant storing the month number of december */
    public static final int DECEMBER = 12;

    /**Constant storing the earliest day in october orders can be made */
    public static final int OCT_DAY_CUTOFF = 15;

    /**Constant storing the latest day in december orders can be made */
    public static final int DEC_DAY_CUTOFF = 31;

    /**Constant storing the earliest hour of the day orders can be made*/
    public static final int TIME_START_HRS = 11;

    /**Constant storing the latest hour of the day orders can be made */
    public static final int TIME_END_HRS = 6;

    /**Constant storing the first minute of the hour that orders can be made */
    public static final int TIME_START_MINS = 0;

    /**Constant sotring the last minute of the hour that orders can be made */
    public static final int TIME_END_MINS = 59;

    /**Constant storing the current year */
    public static final int YEAR = 2024;

    /**Constant storing the price of Chicken Supreme in cents */
    public static final int CHICKEN_PRICE = 525;

    /**Constant storing the price of Burger Bonanza in cents */
    public static final int BURGER_PRICE = 550;
    
    /**Constant storing the price of Veggie Delite in cents */
    public static final int VEGGIE_PRICE = 495;

    /**Constant storing the price of Water in cents */
    public static final int WATER_PRICE = 150;

    /**Constant storing the price of Coffee in cents */
    public static final int COFFEE_PRICE = 195;

    /**Constant storing the price of Chocolate Shake in cents */
    public static final int CHOCOLATE_PRICE = 355;

    /**
     * Starts the program and prompts user for inputs
     * @param args Command line, not used
     */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {

            // Welcome prompting
            System.out.println("                 Welcome to the Wolfpack Sandwich Shop!");
            System.out.println("Orders must be placed between 11:00 AM and 6:59 PM on Oct 15 - Dec 31.");
            System.out.println("When prompted, please enter the time and date. You will then be asked to");
            System.out.println("enter the number of each sandwich/beverage you would like to purchase -");
            System.out.println("Chicken Supreme, Burger Bonanza, Veggie Delite, Water, Coffee, Chocolate");
            System.out.println("Shake. Your order cost and estimated pickup time will then be output.");

            // Time input and error handling
            System.out.print("Please enter time (hour min, e.g. 4 59): ");
            int hour = scanner.nextInt();
            int min = scanner.nextInt();
            if(!isValidTime(hour, min)){
                System.out.println("Invalid time");
                return;
            }
            
            // Date input and error handling
            System.out.print("Please enter date (month day, e.g. 12 15): ");
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            if(!isValidDate(month, day)){
                System.out.println("Invalid date");
                return;
            }

            // Input prompting for order
            System.out.println("Please enter the number of each sandwich/beverage that you would like to purchase: ");

            System.out.print("Chicken Supreme: ");
            int chickenNum = scanner.nextInt();
            if(chickenNum < 0) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.print("Burger Bonanza: ");
            int burgerNum = scanner.nextInt();
            if(burgerNum < 0) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.print("Veggie Delite: ");
            int veggieNum = scanner.nextInt();
            if(veggieNum < 0) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.print("Water: ");
            int waterNum = scanner.nextInt();
            if(waterNum < 0) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.print("Coffee: ");
            int coffeeNum = scanner.nextInt();
            if(coffeeNum < 0) {
                System.out.println("Invalid amount");
                return;
            }
            System.out.print("Chocolate Shake: ");
            int shakeNum = scanner.nextInt();
            if(shakeNum < 0) {
                System.out.println("Invalid amount");
                return;
            }

            //Output of program formatting
            int totalCents = getOrderCost(chickenNum, burgerNum, veggieNum, waterNum, coffeeNum, shakeNum);
            int dollars = totalCents / 100;
            int centsLeft = totalCents % 100;
            System.out.printf("Cost of Order: $%d.%02d\n", dollars, centsLeft);
            
            if(totalCents > 0){
                System.out.printf("Estimated Piuckup Time: %s", getPickupTime(month, day, hour, min));
            }
        }
    }

    /**
     * Gives a boolean representing if the time inputed is within opertating hours
     * (11am - 6pm)
     * @param hour the hour part of time
     * @param min the minute part of time
     * @return boolean that shows if a time is within operating hours
     */
    public static boolean isValidTime(int hour, int min) {
        boolean hrs = ((hour > 0 && hour <= TIME_END_HRS )|| hour == TIME_START_HRS || hour == TIME_START_HRS + 1);
        boolean mins = (min >= TIME_START_MINS && min <= TIME_END_MINS);
        return (hrs && mins);      
    }

    /**
     * Gives a boolean representing if the date inputed is within dates of operation
     * October 15 - December 31
     * @param month the current month
     * @param day the current day
     * @return a boolean that shows if a given date is within operating dates
     */
    public static boolean isValidDate(int month, int day) {
        boolean novDecValid = (month > OCTOBER && month <= DECEMBER && day > 0 && day <= DEC_DAY_CUTOFF);
        boolean octValid = (month == OCTOBER && day >= OCT_DAY_CUTOFF);
        return novDecValid || octValid;         
    }

    /**
     * Gives a boolean representing if a given day is a weekday
     * (Monday, Tuesday, Wednesday, Thursday)
     * Otherwise returns false
     * @param month the given month
     * @param day the given day
     * @return boolean representing if it is a weekday
     * @throws IllegalArgumentExeption if the date is outside of the operating dates (Oct 15 - Dec 31)
     */  
    public static boolean isWeekday(int month, int day) {
        if(!isValidDate(month, day)){
            throw new IllegalArgumentException("Invalid date");
        }

        int w = YEAR - ((14 - month) / 12);

        int x = w + (w / 4) - (w / 100) + (w / 400);

        int z = month +  12 * ((14 - month) / 12) - 2;

        return ((day + x + (31 * z) / 12) % 7 > 0) && ((day + x + (31 * z) / 12) % 7 < 5);
    }

    /**
     * Returns the total cost in cents given the number of each of the items ordered
     * @param chicken the number of Chicken Supremes ordered
     * @param burger the number of Burger Bananzas ordered
     * @param veggie the number of Veggie Delights ordered
     * @param water the number of waters ordered
     * @param coffee the number of coffees ordered
     * @param shake the number of chocolate shakes ordered
     * @return the total cost in cents given the quantity of each item ordered
     * @throws IllegalArgumentExeption if any of the quantities ordered are negative
     */
    public static int getOrderCost(int chicken, int burger, int veggie, 
    int water, int coffee, int shake) {
        if(chicken < 0 || burger < 0 || veggie < 0 || water < 0 || coffee < 0 || shake < 0){
            throw new IllegalArgumentException("Invalid amount");
        }
        return (chicken * CHICKEN_PRICE) + (burger * BURGER_PRICE) + (veggie * VEGGIE_PRICE) + (water * WATER_PRICE) + (coffee * COFFEE_PRICE) + (shake * CHOCOLATE_PRICE);
    }

    // You must check for these error conditions in the order given above.
    /**
     * Determines and returns a string representing the pickup time depeding on if it is a weekday
     * Time in format (hrs:mins) "3:09"
     * @param month the month the order is placed during
     * @param day the day the order is placed during
     * @param hour the hour the order is placed during
     * @param min the minute the order is placed during
     * @return a string of the estimted time of pickup
     * @throws IllegalArgumentException if order is placed outside of valid hours or valid dates
     */
    public static String getPickupTime(int month, int day, int hour, int min) {
        // Validates Dates and times are in operation
        if(!isValidDate(month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
        if(!isValidTime(hour, min)) {
            throw new IllegalArgumentException("Invalid time");
        }

        boolean weekday = isWeekday(month, day);
        int mins = min + ((weekday) ? (20) : (30)); // Adds 30 mins if weekwend, 20 if weekday
        int hrs = hour;
        // Trim based on time conventions
        if(mins > 59) {
            hrs = hrs + 1;
            mins -= 60;
        }
        if(hrs > 12) {
            hrs = hrs - 12;
        }
        boolean minLessThan10 = mins < 10;
        String hrsFinal = Integer.toString(hrs);
        String minsFinal = Integer.toString(mins);
        return hrsFinal + ":" + ((minLessThan10) ? ("0") : ("")) + minsFinal;              
    }
}