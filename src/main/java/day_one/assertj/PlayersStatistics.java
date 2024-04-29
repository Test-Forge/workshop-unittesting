package day_one.assertj;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayersStatistics {

    private Players player;
    private int games;
    private int goals;

    public double gamesPerGoal(){
        return (double)this.games / (double)this.goals;
    }

    public double goalsPerGame(){
        return (double)this.goals / (double)this.games;
    }

    public boolean underThirty(){
        return this.player.getAge() < 30;
    }

    public Double[] createCsvRecord(){
        if (this.games == 0){
            return null;
        }
        else{
            return new Double[]{goalsPerGame(), gamesPerGoal()};
        }
    }

    public static Players getYoungerPlayer(Players player1, Players player2){
        if(player2.getAge() < player1.getAge()){
            return player2;
        }
        return player1;
    }

}
