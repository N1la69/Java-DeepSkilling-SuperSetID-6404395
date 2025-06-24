package Week2_JUnitBasicTesting_Exercises.Exercise4_AAA.Code;

import org.junit.*;
import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(); // Arrange
    }

    @After
    public void tearDown() {
        userService = null; // Cleanup
    }

    @Test
    public void testIsValidUser() {
        // Act
        boolean result = userService.isValidUser("John");

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsInvalidUser() {
        assertFalse(userService.isValidUser("Jo"));
    }
}
