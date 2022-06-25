package com.kodilla.patterns.strategy.social.media;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {

    public String share() {
        String str = "[Facebook Publisher] You use Facebook.";
        System.out.println(str);

        return str;
    }
}
