package org.rober.example.servlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public List<Tweet> getUserTimeline(String... users) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        long overalStartTime = System.nanoTime();

        for (String user : users) {
            System.out.println("getting tweets from "+user);
            long startTime = System.nanoTime();
            long count = 0;
            int countPage;
            do {
                countPage = 0;
                for (Tweet tweet : twitter.timelineOperations().getUserTimeline("@" + user,countPage)) {

                    tweets.add(tweet);
                    count++;
                    countPage++;
                }
            }while (countPage==20 && count/20 < 10);

            long endTime = System.nanoTime();
            System.out.println("retrieved tweets from "+user+", time; "+(endTime-startTime) + " for "+count +" tweets");
        }

        long overalEndTime = System.nanoTime();
        System.out.println("Overal time; "+(overalEndTime-overalStartTime));

        return tweets;
    }






    //Getters & Setters
    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public Twitter getTwitter() {
        return twitter;
    }
}
