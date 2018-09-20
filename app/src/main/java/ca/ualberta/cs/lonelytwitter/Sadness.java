package ca.ualberta.cs.lonelytwitter;

//import ca.ualberta.cs.lonelytwitter.Mood;

import java.util.Date;

public class Sadness extends Mood {
    private String sadMessage;

    public Sadness() {
        sadMessage = "I am sad.";
    }

    public Sadness(Date newDate) {
        this.date = newDate;
        sadMessage = "I am sad.";
    }

    public String sadMoodFormat() {
        return this.sadMessage;
    }
}
