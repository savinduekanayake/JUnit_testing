package io.javabrains;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running" + testInfo.getDisplayName() + "With tags"+ testInfo.getTags());
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("add method")
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Testing add method for +")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1,1);
            assertEquals(expected, actual, () -> "should return the right sum"+expected+ "But returns the"+actual);
        }

        @Test
        @DisplayName("Testing add method for -")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1,-1);
            assertEquals(expected, actual, "should return the right sum");
        }
    }

    @Test
    @Tag("Math")
//    @EnabledOnOs(OS.LINUX)
    @DisplayName("Testing Divide method")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"Divide by zero should throw");

    }

    @Test
    @Tag("Math")
    @DisplayName("Multiply method")
    void testMultiply(){

            assertAll(
                    () -> assertEquals(4,mathUtils.multiply(2,2)),
                    () -> assertEquals(0,mathUtils.multiply(0,2))
            );
    }



    @Tag("Circular")
    @RepeatedTest(3)
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return right circle area");
    }

    @Test
    @Disabled
    @DisplayName("Test Disable")
    void testDisabled(){
        fail("The test should be disabled");
    }
}