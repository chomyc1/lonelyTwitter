package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public boolean addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            return false;
        }
        tweets.add(tweet);
        return true;
    }

    public ArrayList<Tweet> getTweets() {

        //try {
        //    for (int i = 0; i < 999; i++) {
        //        Tweet returnedTweet = tweets.getTweet(i);
        //        tweets.add
        //    }
        //} finally {
        //}
        return tweets;
    }


    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void deleteTweet(Tweet tweet) {
        tweets.remove(tweet);
    }


    /*public Tweet getTweet(int index) {
        return tweets.get(index);
    }*/
}
