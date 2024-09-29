import java.util.Scanner;

public class SandwichShop {

    public static final int OCTOBER = 10;
    public static final int DECEMBER = 12;
    public static final int OCT_DAY_CUTOFF = 15;
    public static final int DEC_DAY_CUTOFF = 31;
    public static final int TIME_START_HRS = 11;
    public static final int TIME_END_HRS = 6;
    public static final int TIME_START_MINS = 0;
    public static final int TIME_END_MINS = 59;
    public static final int YEAR = 2024;

    public static final int CHICKEN_PRICE = 525;
    public static final int BURGER_PRICE = 550;
    public static final int VEGGIE_PRICE = 495;
    public static final int WATER_PRICE = 150;
    public static final int COFFEE_PRICE = 195;
    public static final int CHOCOLATE_PRICE = 355;

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

    //Returns true, if hour is a value ranging from 11 to 12 or 1 to 6 and min is a value from 0 to 59
    //You may assume that the hour represents 11 AM, 12 NOON, or 1 - 6 PM.
    //Returns false, otherwise
    public static boolean isValidTime(int hour, int min) {
        boolean hrs = ((hour > 0 && hour < TIME_END_HRS )|| hour == TIME_START_HRS || hour == TIME_START_HRS + 1);
        boolean mins = (min >= TIME_START_MINS && min <= TIME_END_MINS);
        return (hrs && mins);      
    }

    //Returns true, if the month and day represent a date that is between October 15 
    //and December 31, inclusive.
    //Returns false, otherwise
    public static boolean isValidDate(int month, int day) {
        return (month > OCTOBER && month <= DECEMBER && day > 0 && day <= DEC_DAY_CUTOFF) || (month == OCTOBER && day >= OCT_DAY_CUTOFF);         
    }

    //Returns true, if the date falls on Monday - Thursday in 2024
    //Returns false, otherwise 
    //This method must use Zeller's Algorithm as described in the Implementation section below.
    //
    //Throws an IllegalArgumentException with the message, "Invalid date",  
    //if the month and day do not represent a date that is between October 15 
    //and December 31, inclusive.
    //HINT: Use the isValidDate() method to determine this.   
    public static boolean isWeekday(int month, int day) {
        if(!isValidDate(month, day)){
            throw new IllegalArgumentException("Invalid date");
        }

        int w = YEAR - (14 - month) / 12;

        int x = w + w / 4 - w / 100 + w / 400;

        int z = month +  12 * ((14 - month) / 12) - 2;

        return (day + x + (31 * z) / 12) % 7 > 4;
    }

    //Returns the cost of the order for the given number of each item, as specified above, 
    //as an integer number of cents
    //
    //Throws an IllegalArgumentException with the message, "Invalid amount", if any parameter 
    //value is negative
    public static int getOrderCost(int chicken, int burger, int veggie, 
    int water, int coffee, int shake) {
        if(chicken < 0 || burger < 0 || veggie < 0 || water < 0 || coffee < 0 || shake < 0){
            throw new IllegalArgumentException("Invalid amount");
        }
        return (chicken * CHICKEN_PRICE) + (burger * BURGER_PRICE) + (veggie * VEGGIE_PRICE) + (water * WATER_PRICE) + (coffee * COFFEE_PRICE) + (shake * CHOCOLATE_PRICE);
    }

    //Determines and returns the pickup time as a String in which the hour and minutes are separated
    //by a colon (:), and minute values that are less than 10 are preceded by a 0. 
    //For example, "3:05", "12:29", etc.
    //HINT: Use the isWeekday() method to determine whether the date falls on weekday.
    //
    //Throws an IllegalArgumentException with the message, "Invalid date", if the date is invalid
    //HINT: Use the isValidDate() method to determine this
    //
    //Throws an IllegalArgumentException with the message, "Invalid time", if the time is invalid
    //HINT: Use the isValidTime() method to determine this
    //
    // You must check for these error conditions in the order given above.
    public static String getPickupTime(int month, int day, int hour, int min) {
        if(!isValidDate(month, day)) {
            throw new IllegalArgumentException("Invalid date");
        }
        if(!isValidTime(hour, min)) {
            throw new IllegalArgumentException("Invalid time");
        }
        boolean weekday = isWeekday(month, day);
        int mins = min + ((weekday) ? (20) : (30));
        int hrs = hour;
        if(mins > 59) {
            hrs = hrs + 1;
            mins -= 60;
        }
        boolean minLessThan10 = mins < 10;
        String hrsFinal = Integer.toString(hrs);
        String minsFinal = Integer.toString(mins);
        return hrsFinal + ":" + ((minLessThan10) ? ("0") : ("")) + minsFinal;              
    }
}