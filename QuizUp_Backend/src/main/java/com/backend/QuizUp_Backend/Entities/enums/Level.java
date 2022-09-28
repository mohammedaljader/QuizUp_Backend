package com.backend.QuizUp_Backend.Entities.enums;

public enum Level {
    Zero,
    Hundred,
    TwoHundred,
    ThreeHundred,
    FiveHundred,
    Thousand,
    TwoThousand,
    FourThousand,
    EightThousand,
    SixteenThousand,
    ThirtyTwoThousand,
    SixtyFourThousand,
    OneHundredTwentyFiveThousand,
    TwoHundredFiftyThousand,
    FiveHundredThousand,
    Million;

    private static final Level[] vals = values();
    public Level next() {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
