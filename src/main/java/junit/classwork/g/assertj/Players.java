package junit.classwork.g.assertj;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
// class is used as external dependency for PlayersStatistics.class
@Getter
@AllArgsConstructor
public class Players {
    private String name;
    private int age;
    private String sport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players player = (Players) o;
        return age == player.age
                && Objects.equals(name, player.name)
                && Objects.equals(sport, player.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
