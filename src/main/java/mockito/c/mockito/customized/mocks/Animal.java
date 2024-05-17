package mockito.c.mockito.customized.mocks;
// class under test
public class Animal {

    // external dependency
    private ZooKeeper zooKeeper;
    public int age;

    public Animal(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

}
