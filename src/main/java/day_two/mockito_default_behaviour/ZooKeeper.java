package day_two.mockito_default_behaviour;

public class ZooKeeper {

    private String name;

    public ZooKeeper(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return STR."ZooKeeper{name='\{name}\{'\''}\{'}'}";
    }
}
