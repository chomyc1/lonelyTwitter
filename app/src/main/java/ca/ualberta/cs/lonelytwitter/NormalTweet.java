/*
 * NormalTweet.java
 *
 * Version: Lab 4
 *
 * October 3, 2018
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * A Tweet that is not flagged as important.
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

public class NormalTweet extends Tweet {

    /**
     * NormalTweet constructor. Calls the Tweet
     * constructor.
     *
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * NormalTweet constructor with a date parameter.
     * Calls the Tweet constructor.
     *
     * @param date The Tweet's date. Usually the time
     *             when the Tweet was created.
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Returns a Boolean indicating whether
     * the Tweet is important.
     *
     * @return Returns False, as this is for NormalTweet objects.
     */
    @Override
    public Boolean isImportant(){
        return false;
    }
}