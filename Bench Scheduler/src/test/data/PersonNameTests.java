package test.data;

import main.data.PersonName;
import org.junit.*;

public class PersonNameTests {

    private PersonName target;

    @Before
    public void setup() {
        target = new PersonName("Bob", "Smith");
    }

    @Test
    public void get_full_name_returns_full_name() {
        Assert.assertEquals("Smith, Bob", target.getFullName());
    }

}
