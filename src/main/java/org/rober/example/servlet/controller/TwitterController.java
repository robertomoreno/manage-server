package org.rober.example.servlet.controller;

import org.rober.example.servlet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;



    @RequestMapping(value = "/doSomethingThatTakesToMuchTime",method = RequestMethod.GET)
    public String doSomethingThatTakesToMuchTime(Model model) {

        String timeline = "";

        for (Tweet tweet : twitterService.getUserTimeline("VENETHIS","Favstar500Favs","urbandictionary","Favstar_Bot","AmexOffers")) {
            timeline += tweet.getText()+"\n";
        }

        return timeline;
    }





    public void setTwitterService(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    public TwitterService getTwitterService() {
        return twitterService;
    }




}