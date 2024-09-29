import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Program to test GradeCalculator methods
 * @author
 */
public class GradeCalculatorTest {
 
    @Test
    public void testIsValidAverage1() {
        
        assertTrue(GradeCalculator.isValidAverage(78), "GradeCalculator.isValidAverage(78)");
        
    }

    @Test
    public void testIsValidAverage2() {
        
        assertFalse(GradeCalculator.isValidAverage(104), "GradeCalculator.isValidAverage(104)");
 
    }
    @Test
    public void testIsValidAverage3() {
        
        assertFalse(GradeCalculator.isValidAverage(-5), "GradeCalculator.isValidAverage(-5)");
 
    }
    @Test
    public void testIsValidAverage4() {
        
        assertFalse(GradeCalculator.isValidAverage(100000000), "GradeCalculator.isValidAverage(100000000)");
 
    }
    @Test
    public void testIsValidAverage5() {
        
        assertTrue(GradeCalculator.isValidAverage(100), "GradeCalculator.isValidAverage(100)");
 
    }

    // Add 3 more JUnit test cases for the isValidAverage method

    @Test
    public void testCalculateGrade1() {
        // Example valid test case for calculateGrade method
        assertEquals("A", GradeCalculator.calculateGrade(95), "GradeCalculator(95)");
        
    }

    @Test
    public void testCalculateGrade2() {
        
        assertEquals("D", GradeCalculator.calculateGrade(65), "GradeCalculator(65)");
         
    }

    // Add 7 more *valid* JUnit test cases here for calculateGrade method
    @Test
    public void testCalculateGrade3() {
        
        assertEquals("A", GradeCalculator.calculateGrade(90), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade4() {
        
        assertEquals("B", GradeCalculator.calculateGrade(85), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade5() {
        
        assertEquals("B", GradeCalculator.calculateGrade(80), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade6() {
        
        assertEquals("C", GradeCalculator.calculateGrade(75), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade7() {
        
        assertEquals("C", GradeCalculator.calculateGrade(70), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade8() {
        
        assertEquals("D", GradeCalculator.calculateGrade(65), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade9() {
        
        assertEquals("D", GradeCalculator.calculateGrade(60), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade10() {
        
        assertEquals("F", GradeCalculator.calculateGrade(35), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGrade11() {
        
        assertEquals("F", GradeCalculator.calculateGrade(0), "GradeCalculator(65)");
         
    }
    @Test
    public void testCalculateGradeInvalid() {
        
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        
        Exception exception = assertThrows( IllegalArgumentException.class, () -> GradeCalculator.calculateGrade(103),
                                            "calculateGrade(103)");
        assertEquals("Invalid average", exception.getMessage(), "Testing calculateGrade(103) - exception message");
        
        exception = assertThrows( IllegalArgumentException.class, () -> GradeCalculator.calculateGrade(-1),
                                            "calculateGrade(-1)");
        assertEquals("Invalid average", exception.getMessage(), "Testing calculateGrade(-1) - exception message");
            
    }
}
