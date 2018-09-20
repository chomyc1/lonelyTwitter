package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {
    protected Date date = new Date(0);

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date newDate) {
        this.date = newDate;
    }
}