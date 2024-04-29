package day_one.assertj;

import org.assertj.core.api.AbstractAssert;

public class PlayerAssert extends AbstractAssert<PlayerAssert, Players> {

    public static PlayerAssert assertThat(Players players) {
        return new PlayerAssert(players);
    }

    protected PlayerAssert(Players players) {
        super(players, PlayerAssert.class);
    }

    public PlayerAssert hasName(String expectedName) {
        isNotNull();

        if (!actual.getName().equals(expectedName)) {
            failWithMessage("Expected name: " + expectedName + ", but was: " + actual.getName());
        }

        return this;
    }
}
