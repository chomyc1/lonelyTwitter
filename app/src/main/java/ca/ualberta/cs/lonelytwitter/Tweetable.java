/*
 * Tweetable.java
 *
 * Version: Lab 4
 *
 * October 3, 2018
 *
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Interface for Tweet objects. Created by shida3 on 1/19/17.
 *
 * @author shida3, chomyc1
 * @see Tweet
 * @version Lab 4
 *
 */

public interface Tweetable{
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;
}