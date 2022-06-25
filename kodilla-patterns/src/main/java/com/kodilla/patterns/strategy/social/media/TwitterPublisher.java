package com.kodilla.patterns.strategy.social.media;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {

    public String share() {
        String str = "[Twitter Publisher] You use Twitter.";
        System.out.println(str);

        return str;
    }
}
