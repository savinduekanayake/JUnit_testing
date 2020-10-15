package io.javabrains;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
//    @EnabledOnOs(OS.LINUX)
    @DisplayName("Testing Divide method")
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"Divide by zero should throw");

    }

    @Test
    @DisplayName("Multiply nethod")
    void testMultiply(){
//        assertEquals(4,mathUtils.multiply(2,2),"should return the right product");
            assertAll(
                    () -> assertEquals(4,mathUtils.multiply(2,2)),
                    () -> assertEquals(0,mathUtils.multiply(0,2))
            );
    }


    @Test
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