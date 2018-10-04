/*
 * Tweet.java
 *
 * Version: Lab 4
 *
 * October 3, 2018
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a single Tweet. Stores a date, and a message,
 * along with a Boolean indicating whether this is a
 * NormalTweet or an ImportantTweet.
 *
 * Created by shida3 on 1/19/17.
 *
 * @author shida3
 * @author chomyc1
 * @see Tweetable
 * @see LonelyTwitterActivity
 * @version Lab 4
 *
 */

public abstract class Tweet implements Tweetable{
    public abstract Boolean isImportant();
    private Date date;
    private String message;

    /**
     * Tweet constructor. Stores the message specified by
     * the parameter. Creates a new date object using the
     * default Date constructor and stores it.
     *
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Tweet constructor with a Date.
     * Stores the message and date specified by the parameters.
     *
     * @param date The Tweet's date. Usually the time
     *             when the Tweet was created.
     * @param message The Tweet's message, was originally
     *                taken from the user's input.
     */
    public Tweet(Date date, String message){
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the Tweet's date.
     *
     * @return Returns the Tweet's date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the Tweet's date to the specified date.
     *
     * @param date The Date to be stored in the Tweet.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns the Tweet's message.
     *
     * @return Returns a String containing Tweet's message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the Tweet's message to the specified message.
     *
     * @param message String representing the message
     *               to be stored in the Tweet.
     * @throws TweetTooLongException If the Tweet has
     * over 140 characters.
     * @see TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Returns a String representation of the Tweet.
     *
     * @return String representing the Tweet, includes
     * the date.
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

}
