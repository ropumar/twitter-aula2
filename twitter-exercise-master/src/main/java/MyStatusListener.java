import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

import java.util.logging.Logger;

public class MyStatusListener implements StatusListener {
    private static final Logger logger = Logger.getLogger(TweetCollectorResource.class.getName());
    @Override
    public void onStatus(Status status) {
        System.out.println(status.getUser().getName() + " : " + status.getText());
        Tweet tweet = new Tweet(status.getUser().getName(),status.getText(),status.getCreatedAt() );
        displayTweet(tweet);
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {
        e.printStackTrace();
    }

    public void displayTweet (Tweet tweet){
        System.out.println(tweet.getName() + tweet.getMessage() + tweet.getDate());
        System.out.println("Teste");
    }
}

