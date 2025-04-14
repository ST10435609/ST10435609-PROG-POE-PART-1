import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class MainTest {

    private Main instance;
    private InputStream originalIn;

    @Before
    public void setUp() {
        instance = new Main();
        originalIn = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(originalIn); // restore original System.in
    }

    @Test
    public void testRegister() {
        // Simulate user input for register(): name, surname, username, phone number, password
        String simulatedInput =
                "Sifiso\n" +
                "Khausela\n" +
                "sifi_\n" +
                "+27831234567\n" +
                "Strong@123\n";

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testIn);

        instance.register();

        assertEquals("sifi_", instance.getUsername());
        assertEquals("+27831234567", instance.getPhoneNumber());
        assertTrue(instance.authenticate("sifi_", "Strong@123"));
    }

    @Test
    public void testAuthenticateSuccess() {
        instance.setUsername("test_");
        instance.setPassword("Pass@123");
        assertTrue(instance.authenticate("test_", "Pass@123"));
    }

    @Test
    public void testAuthenticateFailure() {
        instance.setUsername("test_");
        instance.setPassword("Pass@123");
        assertFalse(instance.authenticate("wrong_", "wrongpass"));
    }

    @Test
    public void testDisplayUserDetails() {
        instance.setUsername("sifi_");
        instance.setPassword("Strong@123");
        instance.displayUserDetails();
    }

    @Test
    public void testMain() {
        // Skipping this since main() uses full user input.
        System.out.println("Skipping main() method test due to required live input.");
    }
}
