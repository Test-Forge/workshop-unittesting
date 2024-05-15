package mockito.mockito_default_behaviour;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnimalTest {

    @Test
    public void testAnimal() {
        Animal lion = mock(Animal.class);

        Animal cat = mock(Animal.class, RETURNS_DEFAULTS);

        // Smart null
        ZooKeeper zooKeeperJohn = new ZooKeeper("John");
        Animal doggo = mock(Animal.class, RETURNS_SMART_NULLS);
        when(doggo.getZooKeeper()).thenReturn(zooKeeperJohn);
        System.out.println(doggo.getZooKeeper());

        // Returns mock
        Animal cato = mock(Animal.class, RETURNS_MOCKS);

        // Returns deep stubs
        Animal tiger = mock(RETURNS_DEEP_STUBS);
        when(tiger.getZooKeeper().getName()).thenReturn("Alan");
        System.out.println(tiger.getZooKeeper().getName());
    }

}