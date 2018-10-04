/*
 * ImportantTweet.java
 *
 * Version: Lab 4
 *
 * October 3, 2018
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A Tweet that is flagged as important.
 *
 * Created by shida3 on 1/19/17.
 *
 * @author shida3
 * @author chomyc1
 * @see Tweet
 * @see LonelyTwitterActivity
 * @version Lab 4
 *
 */

public class ImportantTweet extends Tweet {

    /**
     * ImportantTweet constructor. Calls the Tweet
     * constructor.
     *
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * ImportantTweet constructor with a date parameter.
     * Calls the Tweet constructor.
     *
     * @param date The Tweet's date. Usually the time
     *             when the Tweet was created.
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Returns a Boolean indicating whether
     * the Tweet is important.
     *
     * @return Returns True, as this is for ImportantTweet objects.
     */
    @Override
    public Boolean isImportant(){
        return true;
    }
}
