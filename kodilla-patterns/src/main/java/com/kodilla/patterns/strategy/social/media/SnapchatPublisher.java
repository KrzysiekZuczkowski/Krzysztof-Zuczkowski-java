package com.kodilla.patterns.strategy.social.media;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {

    public String share() {
        String str = "[Snapchat Publisher] You use Snapchat.";
        System.out.println(str);

        return str;
    }
}
