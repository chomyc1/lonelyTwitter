package ca.ualberta.cs.lonelytwitter;

//import ca.ualberta.cs.lonelytwitter.Mood;

import java.util.Date;

public class Happiness extends Mood {
    private String happyMessage;

    public Happiness() {
        happyMessage = "I am happy.";
    }

    public Happiness(Date newDate) {
        this.date = newDate;
        happyMessage = "I am happy.";
    }

    public String happyMoodFormat() {
        return this.happyMessage;
    }
}
