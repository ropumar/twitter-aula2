import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.Serializable;

public class TweetManager implements LifecycleManager , Serializable {
    StatusListener listener = new MyStatusListener();
    public TwitterStream twitter;
    @Override
    public void start() {
        String _consumerKey = System.getenv().get("TWITTER_CONSUMER_KEY");
        String _consumerSecret = System.getenv().get("TWITTER_CONSUMER_SECRET");
        String _accessToken = System.getenv().get("TWITTER_ACCESS_TOKEN");
        String _accessTokenSecret = System.getenv().get("TWITTER_ACCESS_TOKEN_SECRET");

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(_consumerKey)
                .setOAuthConsumerSecret(_consumerSecret)
                .setOAuthAccessToken(_accessToken)
                .setOAuthAccessTokenSecret(_accessTokenSecret);

        twitter = new TwitterStreamFactory(configurationBuilder.build()).getInstance();
        twitter.addListener(listener);
        twitter.filter("Clojure");
    }

    @Override
    public void stop() {
        twitter.cleanUp();
        twitter.clearListeners();
    }
}
