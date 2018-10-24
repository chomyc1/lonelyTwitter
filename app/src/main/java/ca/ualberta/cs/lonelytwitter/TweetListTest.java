package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super (LonelyTwitterActivity.class);
    }
/*
    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        boolean result = tweets.addTweet(tweet);
        if (!result) { // If a duplicate tweet exists
            assertTrue(Boolean.FALSE);
        }
    }

    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        ArrayList<Tweet> returnedList = tweets.getTweets();
        assertNotNull(returnedList);
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet returnedTweet = tweets.getTweet(0);
        boolean result = tweets.hasTweet(tweet);
        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
    }*/

    /* Old methods from lab:

    public void testHasTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet returnedTweet = tweets.getTweet(0);
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
    */}



//}