package Puzzle8;

import java.util.concurrent.ThreadLocalRandom;

public class SolvablePuzzleGenerator {
    public static Puzzle8 generate(){
        Puzzle8 puzzle8 = new Puzzle8();
        int randomNum;

        int min = 1;
        int range = 4;

        // Scramble the board by doing many randomly decided moves
        for(int i=0; i<5000; i++){
            randomNum = (int)(Math.random() * range) + min;

            switch (randomNum) {
                case 1 -> puzzle8.moveBlankDown();
                case 2 -> puzzle8.moveBlankUp();
                case 3 -> puzzle8.moveBlankLeft();
                case 4 -> puzzle8.moveBlankRight();
            }
        }

        return puzzle8;
    }
}
