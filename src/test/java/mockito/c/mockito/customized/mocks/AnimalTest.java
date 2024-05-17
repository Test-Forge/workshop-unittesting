package mockito.c.mockito.customized.mocks;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
// test class to test Animal.class methods
class AnimalTest {

    // example test for default mock()
    @Test
    public void testAnimalDefault() {
        // default mocking behavior
        // all animal's variables will be null or the equivalent of null
        // all animal's methods will return null
        // NOTE! null returned from mocked instance's method will not provoke a NullPointerException
        Animal lionMock = mock();
        System.out.println(lionMock.getZooKeeper());
        System.out.println(lionMock.age);
    }

    // example test for RETURNS_DEFAULTS
    @Test
    public void testAnimalReturnDefaults() {
        // identical to the above mock
        // all animal's variables will be null or the equivalent of null
        // all animal's methods will return null
        Animal catMock = mock(RETURNS_DEFAULTS);
        System.out.println(catMock.getZooKeeper());
        System.out.println(catMock.age);
    }

    // example test for RETURNS_SMART_NULLS
    @Test
    public void testAnimalReturnSmartNulls() {
        // Smart null - provides guidance on which methods returns null and require stubbing
        // all animal's variables will be null or the equivalent of null
        // all animal's methods will return null
        // BUT - will warn us in the console if a called method is not stubbed
        Animal doggoMock = mock(RETURNS_SMART_NULLS);
        System.out.println(doggoMock.getZooKeeper());
        System.out.println(doggoMock.age);
    }

    // example test for RETURNS_MOCKS
    @Test
    public void testAnimalReturnMocks() {
        // Returns mock - replaces objects with mocked instances to avoid a possible null pointer
        // all animal's primitive variables will be the equivalent of null
        // Object type variables will be mocked
        // all animal's methods will return null
        Animal catoMock = mock(RETURNS_MOCKS);
        // RETURNS_MOCKS acts like a stub for the getZookeeper() method of Animal class
        // effectively replacing: when(catoMock.getZooKeeper()).thenReturn(mock());

        System.out.println(catoMock.getZooKeeper());
        System.out.println(catoMock.age);
    }

    // example test for RETURNS_DEEP_STUBS
    @Test
    public void testAnimalReturnDeepStubs() {
        // Returns deep stubs - stub chains of method calls within objects for highly specific contexts
        // all animal's primitive variables will be the equivalent of null
        // Object type variables will be mocked
        // all animal's methods will return null
        // all Object's methods are available for stubbing
        Animal tigerMock = mock(RETURNS_DEEP_STUBS);
        // stubbing of the .getName() method from ZooKeeper.class
        // that is itself called by getZooKeeper() method from Animal.class
        when(tigerMock.getZooKeeper().getName()).thenReturn("Alan");
        System.out.println(tigerMock.getZooKeeper().getName());
    }
}