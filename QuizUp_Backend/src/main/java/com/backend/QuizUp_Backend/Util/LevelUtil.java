package com.backend.QuizUp_Backend.Util;

import com.backend.QuizUp_Backend.Entities.enums.Level;

public class LevelUtil {
    public static Level getLevel(Integer bonus){
        return switch (bonus) {
            case 0 -> Level.Zero;
            case 100 -> Level.Hundred;
            case 200 -> Level.TwoHundred;
            case 300 -> Level.ThreeHundred;
            case 500 -> Level.FiveHundred;
            case 1000 -> Level.Thousand;
            case 2000 -> Level.TwoThousand;
            case 4000 -> Level.FourThousand;
            case 8000 -> Level.EightThousand;
            case 16000 -> Level.SixteenThousand;
            case 32000 -> Level.ThirtyTwoThousand;
            case 64000 -> Level.SixtyFourThousand;
            case 125000 -> Level.OneHundredTwentyFiveThousand;
            case 250000 -> Level.TwoHundredFiftyThousand;
            case 5000000 -> Level.FiveHundredThousand;
            default -> Level.Million;
        };
    }
}
