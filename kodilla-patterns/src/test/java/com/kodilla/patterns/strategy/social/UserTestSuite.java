package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.media.FacebookPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User steven = new YGeneration("Steven Links");
        User john = new ZGeneration("John Hemerald");
        User will = new Millenials("Will Kod");

        //When
        String stevenMedia = steven.sharePost();
        String johnMedia = john.sharePost();
        String willMedia = will.sharePost();

        //Then
        assertEquals("[Twitter Publisher] You use Twitter.", stevenMedia);
        assertEquals("[Facebook Publisher] You use Facebook.", johnMedia);
        assertEquals("[Snapchat Publisher] You use Snapchat.", willMedia);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User steven = new YGeneration("Steven Links");

        //When
        steven.sharePost();
        steven.setSocialPublisher(new FacebookPublisher());
        String stevenMedia = steven.sharePost();

        //Then
        assertEquals("[Facebook Publisher] You use Facebook.", stevenMedia);
    }
}
